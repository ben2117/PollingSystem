package polsys;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Poll implements Serializable{

	private static final long serialVersionUID = -2214715033634951514L;

	@XmlElement(name = "pollID")
	private String ID;
	@XmlElement(name = "pollTitle")
	private String title;
	@XmlElement(name = "pollCreator")
	private String creator;
	@XmlElement(name = "pollDate")
	private String date;
	@XmlElement(name = "pollLocation")
	private String location;
	@XmlElement(name = "pollDescription")
	private String description;
	@XmlElement(name = "status")
	private String status;
	
	@XmlElement(name = "VoteOption")
	private ArrayList<VoteOption> voteOptions = new ArrayList<VoteOption>();

	
	public Poll(){
		super();
	}
	
	public Poll(String id, String title, String location, String description, String creator) {
		// TODO Auto-generated constructor stub
		super();
		this.ID = id; //This should be auto generated
		this.title = title;
		
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Date dateobj = new Date();
		this.date = df.format(dateobj);
		
		this.location = location;
		this.description = description;
		this.status = "open";
		this.creator = creator;
	}
	
	
	public String getId() {
		// TODO Auto-generated method stub
		return ID;
	}
	public String getStatus() {
		// TODO Auto-generated method stub
		return this.status;
	}
	public String getTitle(){
		return title;
	}
	public String getDate(){
		return date;
	}
	public String getLocation(){
		return location;
	}
	public String getDescription(){
		return description;
	}

	public void closePoll() {
		// TODO Auto-generated method stub
		this.status = "closed";
		
	}

	public void vote(String voteID, String name){
		for(VoteOption vo: getVoteOptions()){
			if(vo.getId().equals(voteID)){
				vo.vote(name);
			}
		}
	}
	
	public int getTotalVotes()
	{
		int i = 0;
		for(VoteOption vo: voteOptions){
			i+=vo.getTotalVotes();
		}
		return i;
	}
	
	public ArrayList<VoteOption> getVoteOptions() {
		// TODO Auto-generated method stub
		return voteOptions;
	}

	public void createVoteOption(String voteOptionsID, String voteOption) {
		voteOptions.add(new VoteOption(voteOptionsID, voteOption));
		
	}

	public String getCreator() {
		return creator;
	}

}
