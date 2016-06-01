package polsys.soap;

import java.io.IOException;
import java.util.*;
import polsys.*;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.servlet.ServletContext;
import javax.xml.bind.JAXBException;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

@WebService
public class PolSysSoapService {
	@Resource
	private WebServiceContext context;
	
	private PolSysApp getPollSysApp(){
		ServletContext application = (ServletContext)context.getMessageContext().get(MessageContext.SERVLET_CONTEXT);
		PolSysApp polSysApp = (PolSysApp)application.getAttribute("polSysApp");
		if(polSysApp == null){
			polSysApp = new PolSysApp();
			try{
				polSysApp.setFilePath(application.getRealPath("WEB-INF/Polling.xml")); //../WebContent/
				
			}catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			application.setAttribute("polSysApp", polSysApp);
		}
		return polSysApp;
	}
	
	@WebMethod
	public boolean login(String username, String password){
		if(getPollSysApp().login(username, password) != null){
			return true;
		}
		return false;
	}
	
	@WebMethod
	public boolean isLogin(){
		if(getPollSysApp().getSession() != null){
			return true;
		}
		return false;
	}
	
	@WebMethod
	public String createPoll(String pollTitle, String pollLocation, String pollDescription){
		String pollID = Integer.toString(getPollSysApp().getAllPolls().size()+1);
		getPollSysApp().getSessionUser().createNewPoll(pollID, pollTitle, pollLocation, pollDescription);
		return pollID;
	}
	
	@WebMethod
	public void createOptions(String pollID, String voteOptionID,String voteOption){
		getPollSysApp().getPoll(pollID).createVoteOption(voteOptionID, voteOption);
	}
	
	@WebMethod
	public String[] getPolls(){
		String[] pollList = new String[getPollSysApp().getAllPolls().size()];
		for(int i = 0; i < pollList.length; i++){
			Poll p = getPollSysApp().getAllPolls().get(i);
			pollList[i] = "ID: " + p.getId() + ", Title: " + p.getTitle() + ", Description: " + p.getDescription();
		}
		return pollList;
	}
	
	@WebMethod
	public String getPoll(int pollID){
		Poll p = getPollSysApp().getPoll(Integer.toString(pollID));
		return  "ID: " + p.getId() + ", Title: " + p.getTitle() + ", Description: " + p.getDescription() + ", Status: " + p.getStatus() + ", Total Response: " + p.getTotalVotes();
	}
	
	@WebMethod
	public String[] viewPoll(int userid, String status, int minResponse){
		int i = 0;
		ArrayList<Poll> polls = getPollSysApp().viewPollForServices(userid, status, minResponse);
		String[] pollList = new String[polls.size()];
		for(Poll p: polls){
			pollList[i] = "ID: " + p.getId() + ", Title: " + p.getTitle() + ", Description: " + p.getDescription() + ", Status: " + p.getStatus() + ", Total Response: " + p.getTotalVotes();
			i++;
		}
		return pollList;
	}
	
	@WebMethod
	public void closePoll(String pollID){
		getPollSysApp().getSessionUser().closePoll(pollID);
	}
}