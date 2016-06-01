package polsys;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

import javax.xml.bind.*;



public class PolSysApp implements Serializable {

	private static final long serialVersionUID = 4117755568727158460L;
	private String filePath;
	private Users users;
	private User sessionUser;
	
	public PolSysApp(){
		super();
	}
	
	//this marshals the data from the filePath provided
	public void setFilePath(String filePath) throws JAXBException, IOException {
		
		JAXBContext jc = JAXBContext.newInstance(Users.class);
		Unmarshaller u = jc.createUnmarshaller();
		FileInputStream fin = new FileInputStream(filePath);
		users = (Users)u.unmarshal(fin);
		fin.close();
		this.filePath = filePath;
	}
	
	public void saveData() throws JAXBException, IOException{
		JAXBContext jc = JAXBContext.newInstance(Users.class);
		Marshaller m = jc.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		//uses the filepath provided by setFilePath
		FileOutputStream fos = new FileOutputStream(filePath);
		m.marshal(users, fos);
		fos.close();
	}
	
	public void logout()throws JAXBException, IOException{
		saveData();
		this.sessionUser = null;
	}
	
	//for task login and logout
	public User login(String username, String password){
		for(User user : users.getUsers()){
			if(user.getUserName().equals(username) &&
					user.getPassword().equals(password)){
				sessionUser = user;
				return getSessionUser();
			}
		}
		return null;
	}
	
	
	
	// for task create a new poll
	public void createNewPoll(String pollID, String pollTitle, String meetingLocation, String meetingDescription) throws JAXBException, IOException{
		for(User user : users.getUsers()){
			if(user.getUserId().equals(sessionUser.getUserId())){
				user.createNewPoll(pollID, pollTitle, meetingLocation, meetingDescription);
			}
		}
		saveData();
	}
	//to add meeting times to a poll
	public void createPollMeetingTime(String pollId, String meetingDateTimeId, String meetingDateTime) throws JAXBException, IOException{
		getPoll(pollId).createVoteOption(meetingDateTimeId, meetingDateTime);
		saveData();
	}
	
	//for task close a poll
	public void closePoll(String pollId) throws JAXBException, IOException{
		for(User user : users.getUsers()){
			if(user.getUserId().equals(sessionUser.getUserId())){
				user.closePoll(pollId);
			}
		}
		saveData();
	}
	
	//creates a list of all open Polls (meeting object)
	//you will use this for selecting which poll to vote on
	public ArrayList<Poll> getAllOpenPolls(){
		return getPollsByStatus("open");
	}
	
	public ArrayList<Poll> getAllClosedPolls(){
		return getPollsByStatus("closed");
	}
	
	public ArrayList<Poll> getPollsByStatus(String status){
		ArrayList<Poll> polls = new ArrayList<Poll>();
		for(User user : users.getUsers()){
			for(Poll poll : user.getPolls()){
				if(poll.getStatus().equals(status)){
					polls.add(poll);
				}
			}
		}
		return polls;
	}
	
	//creates a list of all Polls (meeting object)
	public ArrayList<Poll> getAllPolls() {
		ArrayList<Poll> allPolls = new ArrayList<Poll>();
		for(User user : users.getUsers()){
			System.out.println(user.getUserId());
			for(Poll poll : user.getPolls()){
				allPolls.add(poll);
			}
		}
		return allPolls;
	}
	
	//return specified poll(meeting object)
	public Poll getPoll(String pollId){
		for(Poll poll : getAllPolls()){
			if(poll.getId().equals(pollId)){
				return poll;
			}
		}
		return null;
	}
	
	//returns all of the meeting date times so you can see what options you have for
	//voting on a particular poll
	public ArrayList<VoteOption> getPollVotingOptions(String pollId){
		for(Poll poll : getAllOpenPolls()){
			if(poll.getId().equals(pollId)){
				return poll.getVoteOptions();
			}
		}
		return null;
	}
	
	//returns a specific meeting date time from a specific poll (meeting)
	public VoteOption getMeetingDateTime(String pollId, String meetingDateTimeID){
		for(Poll poll : getAllOpenPolls()){
			if(poll.getId().equals(pollId)){
				for(VoteOption voteOption : poll.getVoteOptions()){
					if(voteOption.getId().equals(meetingDateTimeID)){
						return voteOption;
					}
				}
			}
		}
		return null;
	}
	
	public void vote(String pollID, String voteOptionID, String voter)throws JAXBException, IOException{
		getPoll(pollID).vote(voteOptionID, voter);
		saveData();
	}
	
	public void voteOnPoll(String pollId, String meetingDateTimeID, String voterName) throws JAXBException, IOException{
		VoteOption voteOption = getMeetingDateTime(pollId, meetingDateTimeID);
		if(voteOption != null){
			//mdt.vote(sessionUser.getUserId());
			//voter does not have to be logged in to vote, voter name is supplied in form
			voteOption.vote(voterName);
			
		}
		saveData();
	}
	
	// for task View a list of their own existing polls 
	public ArrayList<Poll> getSessionUsersPolls(){
		for(User user : users.getUsers()){
			if(user.getUserId().equals(sessionUser.getUserId())){
				user.getPolls();
			}
		}
		return null;
	}
	
	//get all the polls by a user
	public ArrayList<Poll> getPollsByUser(String userid){

		for(User user : users.getUsers()){
			//System.out.println(u.getUserId() + "and " + userid);
			if(user.getUserId().equals(userid)){
				return user.getPolls();
			}
		}
		return null;
	}
	
	public ArrayList<Poll> getPollsByMinResponse(int minResponse){
		ArrayList<Poll> minResponses = new ArrayList<Poll>();
		for(Poll poll : getAllPolls()){
			int responseCount = 0;
			for(VoteOption voteOption : poll.getVoteOptions()){
				responseCount+= voteOption.getVoteCount();
			}
			if(responseCount >  minResponse){
				minResponses.add(poll);
			}
		}
		return minResponses;
	}
	
	public String getFilePath() {
		return filePath;
	}

	public Users getUsers() {
		// TODO Auto-generated method stub
		return this.users;
		
	}

	public void createUser(String username, String password, String fullName)throws JAXBException, IOException{
		getUsers().add(username,password,fullName);
		saveData();
	}
	
	public User getSessionUser(){
		for(User user : users.getUsers()){
			if(user.getUserId().equals(sessionUser.getUserId())){
				return user;
			}
		}
		return null;
	}
	
	
	///uses bubble sort polls by title alphabeticaly 
	public Poll[] sortPollsByTitle(){
		ArrayList<Poll> pollArrayList = getAllPolls();
		Poll[] simplePollArray = new Poll[pollArrayList.size()];
		simplePollArray = pollArrayList.toArray(simplePollArray);
		int i;
		boolean fin = false;
		Poll temp = null;
		
		while(!fin) {
			fin = true;
			
			for(i = 0; i < simplePollArray.length; i++){
				if((i+1) < simplePollArray.length ){
					if(simplePollArray[i].getTitle().compareToIgnoreCase(simplePollArray[i+1].getTitle()) > 0 ){
						temp = simplePollArray[i];
						simplePollArray[i] = simplePollArray[i+1];
						simplePollArray[i+1] = temp;
						fin = false;
					}
				}
			}
		}
		
		for(Poll p : simplePollArray){
			System.out.println(p.getTitle());
		}
		return simplePollArray;
	}
	public User getSession(){
		return this.sessionUser;
	}
	
	
	//create a list of all the polls and remove filtered polls one by one
	//for use in REST and SOAP services
	public ArrayList<Poll> viewPollForServices(int userid, String status, int minResponse){
		ArrayList<Poll> polls = getAllPolls();
		ArrayList<Poll> toRemove = new ArrayList<Poll>();
		switch(1){
			case 1:
				if(userid == 0){
					//do nothing
				}else{
					for(Poll p: polls){
						if(!p.getId().equals(Integer.toString(userid))){
							toRemove.add(p);
						}
					}
				}
			case 2:
				if(status.equals("")){
					//do nothing
				}else{
					for(Poll p: polls){
						if(!p.getStatus().equals(status)){
							toRemove.add(p);
						} 
					}
				}
			case 3:
				if(minResponse == 0){
					//do nothing
				}else{
					for(Poll p : polls){
						if(!(p.getTotalVotes() >= minResponse)){
							toRemove.add(p);
						}
					}
				}
		}
		polls.removeAll(toRemove);
		return polls;
	}
	
	
}
//I have changed quite a fair bit to the back end. 
//Reasons = we were kept storing things on sessionUser when it's sole purpose was just to store session not data or records.'
//naming conventions has mostly been changed.
//front end is pretty much done just needs to implement open and close.