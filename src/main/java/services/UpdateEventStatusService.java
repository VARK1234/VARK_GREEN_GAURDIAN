package services;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import database.DBConnection;

public class UpdateEventStatusService {
	
	public void updateStatus(String eventId, String statusReceived){
		Connection con  = null;
		Statement stmt = null;
		try {
			
			con = DBConnection.getConnection();
			stmt = con.createStatement();
			String query = "UPDATE EVENT SET STATUS = '"+statusReceived+"' WHERE EVENT_ID "
					+ "= '"+eventId+"'";
			stmt.executeUpdate(query);
		}
		catch(Exception e){
			
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
}
