package polsys.soap.client;

import java.rmi.RemoteException;
import java.util.Scanner;

import javax.xml.rpc.ServiceException;

public class PolSysClient {
	public static void main(String[] args) throws ServiceException, RemoteException {
		PolSysSoapServiceServiceLocator loc = new PolSysSoapServiceServiceLocator();
		PolSysSoapService service = loc.getPolSysSoapServicePort();
		Scanner scanner = new Scanner(System.in);
		boolean option = true;
		while(option){
			System.out.println("Options 1: Login");
			System.out.println("Options 2: View All Polls");
			System.out.println("Options 3: Get Polls with ID");
			System.out.println("Options 4: View Polls with Parameters");
			System.out.println("Options 5: Create a new Poll( REQUIRES LOGIN )");
			System.out.println("Options 6: Close a Poll");
			System.out.println("Options 7: Exit");
			System.out.print("Enter options: ");
			switch(scanner.nextInt()){
			case 1:
				login(service);
				break;
			case 2:
				viewPolls(service);
				break;
			case 3:
				getPoll(service);
				break;
			case 4:
				viewPoll(service);
				break;
			case 5:
				createPoll(service);
				break;
			case 6:
				closePoll(service);
				break;
			case 7:
				option = false;
				break;
			}
		}
		
	}
	private static void login(PolSysSoapService service)throws ServiceException, RemoteException{
		while(true){
			Scanner scanner = new Scanner(System.in);
			String user, pass = "";
			System.out.print("Enter username: ");
			user = scanner.next();
			System.out.print("Enter password: ");
			pass = scanner.next();
			
			if(service.login(user, pass)){
				System.out.print("Success\n");//do something
				break;
			} else{
				System.out.print("Please try again!\n");// do something
			}
		}
	}
	private static void viewPolls(PolSysSoapService service)throws ServiceException, RemoteException{
		String[] list = service.getPolls();
		for(int i = 0; i < list.length; i++){
			System.out.println(list[i]);
		}
	}
	private static void getPoll(PolSysSoapService service)throws ServiceException, RemoteException{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter poll ID: ");
		System.out.println(service.getPoll(scanner.nextInt()));
	}
	private static void viewPoll(PolSysSoapService service)throws ServiceException, RemoteException{
		Scanner scanner = new Scanner(System.in);
		int i, j = 0;
		String s = "";
		System.out.print("Enter User ID('0' for N/A): ");
		i = scanner.nextInt();
		System.out.print("Enter Minimum responses('0' for N/A): ");
		j = scanner.nextInt();
		System.out.print("Is the poll open(y/n): ");
		s = scanner.next(); 
		if(s.toLowerCase().charAt(0) == 'y'){s = "open";} else { s = "closed";}
		String[] list = service.viewPoll(i,s,j);
		for(int counter = 0; counter < list.length; counter++){
			if(list[counter] != null){
				System.out.println(list[counter]);
			}
		}
	}
	private static void createPoll(PolSysSoapService service)throws ServiceException, RemoteException{
		Scanner scanner = new Scanner(System.in);
		if(service.isLogin()){
			String i, j, k = "";
			int options = 0;
			System.out.print("Enter Poll Title: ");
			i = scanner.nextLine();
			System.out.print("Enter Poll Description: ");
			j = scanner.nextLine();
			System.out.print("Enter Poll Location: ");
			k = scanner.nextLine();
			String oid = service.createPoll(i, j, k);
			System.out.print("How many options do you want: ");
			options = scanner.nextInt();
			for(int x = 1; x <= options; x++){
				System.out.print("Option"+ x +": ");
				i = scanner.next();
				service.createOptions(oid, String.valueOf(x), i);
			}
		}else{System.out.println("Please Log-In to create new Poll");}
	}
	private static void closePoll(PolSysSoapService service)throws ServiceException, RemoteException{
		Scanner scanner = new Scanner(System.in);
		if(service.isLogin()){
			System.out.print("Enter Poll ID to close: ");
			service.closePoll(scanner.nextLine());
		}else{System.out.println("Please Log-In to close a poll");}
	}
}
