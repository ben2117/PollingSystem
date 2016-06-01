package polsys;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Vote implements Serializable{

	private static final long serialVersionUID = 4875187255743049819L;
	@XmlElement(name = "votername")
	private String name;
	
	public Vote(){
		super();
	}
	
	public Vote(String name){
		this.name = name;
	}
	
	public String getVoterName(){
		return name;
	}
}
