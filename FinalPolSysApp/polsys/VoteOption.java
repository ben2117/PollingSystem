package polsys;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class VoteOption implements Serializable{

	private static final long serialVersionUID = -6171546281865860717L;
	
	@XmlElement(name = "voteOptionID")
	private String ID;
	@XmlElement(name = "voteOption")
	private String voteOption;
	@XmlElement(name = "vote")
	private ArrayList<Vote> votes = new ArrayList<Vote>();
	
	public VoteOption(){
		super();
	}
	
	public VoteOption(String ID, String voteOption) {
		this.ID = ID;
		this.voteOption = voteOption;
	}
	
	public String getId() {
		// TODO Auto-generated method stub
		return ID;
	}
	public String getVoteOption(){
		return voteOption;
	}
	
	//returns the array list of vote objects that contain the user id
	//this seems inneficient
	public ArrayList<Vote> getVotes(){
		return votes;
	}
	
	public int getTotalVotes(){
		int i = 0;
		for(Vote v: votes){
			i++;
		}
		return i;
	}
	
	//returns the amount of votes for this meeting date time
	public int getVoteCount(){
		return votes.size();
	}
	public void vote(String name) {
		// TODO Auto-generated method stub
		//votes = String.valueOf(Integer.parseInt(votes)+1);
		//changed votes to an object to keep track of users
		//each userid recorded will count as a vote
		votes.add(new Vote(name));
	}
	
}
