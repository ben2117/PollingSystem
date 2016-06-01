package polsys;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class User implements Serializable{

	private static final long serialVersionUID = 20046908560066955L;
	
	@XmlElement(name = "userID")
	private String ID;
	@XmlElement(name = "username")
	private String username;
	@XmlElement(name = "fullName")
	private String fullName;
	@XmlElement(name = "password")
	private String password;
	@XmlElement(name = "poll")
	private ArrayList<Poll> polls = new ArrayList<Poll>();
	
	public User(){
		super();
	}
	
	public User(String ID, String username, String password, String fullName){
		this.ID = ID;
		this.username = username;
		this.password = password;
		this.fullName = fullName;
	}
	
	public String getUserName(){
		return username;
	}
	
	public String getPassword(){
		return password;
	}

	public void createNewPoll(String pollID, String pollTitle, String pollLocation, String pollDescription) {
		// TODO Auto-generated method stub
		polls.add(new Poll(pollID, pollTitle, pollLocation, pollDescription, getFullName()));
		
	}


	public boolean closePoll(String ID) {
		// TODO Auto-generated method stub
		for(Poll m : polls){
			if(m.getId().equals(ID)){
				m.closePoll();
				return true;
			}
		}
		return false;
		
	}

	public ArrayList<Poll> getPolls() {
		return this.polls;
	}

	public ArrayList<Poll> getOpenedPolls(){
		ArrayList<Poll> open = new ArrayList<Poll>();
		for(Poll p: getPolls()){
			if(p.getStatus().equals("open")){
				open.add(p);
			}
		}
		return open;
	}
	
	public ArrayList<Poll> getClosedPolls(){
		ArrayList<Poll> closed = new ArrayList<Poll>();
		for(Poll p: getPolls()){
			if(p.getStatus().equals("closed")){
				closed.add(p);
			}
		}
		return closed;
	}
	
	public String getUserId() {
		// TODO Auto-generated method stub
		return ID;
	}
	public String getFullName(){
		return this.fullName;
	}
	
}
