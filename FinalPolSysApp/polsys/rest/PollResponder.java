package polsys.rest;

import polsys.*;
import java.util.ArrayList;

import javax.xml.bind.annotation.*;

import polsys.Poll;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class PollResponder {
	
	public PollResponder(){
		super();
	}
	public PollResponder(ArrayList<Poll> meetings){
		super();
		this.meetings = meetings;
	}
	
	@XmlElement(name = "meeting")
	private ArrayList<Poll> meetings = new ArrayList<Poll>();
	
	
}
