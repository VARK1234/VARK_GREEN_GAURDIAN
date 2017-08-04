package demo;

import services.AuthenticationService;

public class DemoClass {
	
	
	
	public static void main(String args[]){
		AuthenticationService authentication = new AuthenticationService();
		
		boolean b = authentication.authenticateUser("ADMIN", "greenHackathon");
		System.out.println(b);
		
	}
}
