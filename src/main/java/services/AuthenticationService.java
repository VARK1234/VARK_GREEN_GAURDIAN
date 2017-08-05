package services;

import java.sql.Connection;
import java.util.List;

import beans.Login;
import database.DBConnection;
import database.DBUtils;

public class AuthenticationService {
	
	
	
	public boolean authenticateUser(String userId, String password)
	{
		boolean found = false;
		
		Connection con = DBConnection.getConnection();
		String loginQuery = "SELECT USER_NAME, PASSWORD, AUTHORITY_ID FROM LOGIN WHERE USER_NAME = '"+userId+"' and PASSWORD = '"
				+ password+"'";
		
		List<Login> loginList = (List<Login>) DBUtils.getDataFromTable(con, new Login(), loginQuery);
		
		
		
		
		return !loginList.isEmpty();
	}

}
