package polsys.rest;

import javax.servlet.ServletContext;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.xml.bind.JAXBException;
import java.io.*;
import polsys.*;



//
// my url for rest
// http://localhost:8080/PolSys/rest/polSysApp/ 
//
@Path("/polSysApp")
public class PolSysService {
	@Context
	private ServletContext application;
	
	private PolSysApp getPolSysApp() throws JAXBException, IOException{
		synchronized (application) {
			PolSysApp polSysApp = (PolSysApp)application.getAttribute("polSysApp");
			if(polSysApp == null){
				polSysApp = new PolSysApp();
				polSysApp.setFilePath(application.getRealPath("WEB-INF/Polling.xml"));
				application.setAttribute("polSysApp", polSysApp);
			}
			return polSysApp;
		}
	}
	
	//example 
	//http://localhost:8080/PolSys/rest/polSysApp/polls?minResponse=1
	//http://localhost:8080/PolSysAppReconstructedagain/rest/polSysApp/poll?userid=1&minResponse=1
	
	@Path("polls")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public PollResponder getPolls() throws JAXBException, IOException{
		return new PollResponder(getPolSysApp().getAllPolls());
	}

	@Path("poll")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public PollResponder getPollsByUser(
			@QueryParam("userid") int userid,
			@QueryParam("status") String status,
			@QueryParam("minResponse") int minResponse
				) throws JAXBException, IOException{
		
		if(status==null){
			status = "";
		}
		return new PollResponder(getPolSysApp().viewPollForServices(userid, status, minResponse));
	}
	
	
	//get polls and compare query to remove irrelivent polls
	

}
