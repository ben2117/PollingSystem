package polsys;

import java.util.*;
import java.io.Serializable;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class Users implements Serializable{
	
	private static final long serialVersionUID = 4096308121399665531L;
	
	@XmlElement(name = "user")
	private ArrayList<User> users = new ArrayList<User>();
	
	public ArrayList<User> getUsers(){
		return users;
	}
	
	public void add(User user){
		users.add(user);
	}
	public void add(String username, String password, String fullName){
		add(new User((Integer.toString((users.size() +1))),username,password,fullName));
	}
}
