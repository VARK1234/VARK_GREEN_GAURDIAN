package demo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import beans.Event;
import database.DBConnection;
import database.DBUtils;

public class InsertMain {
	
private static DBConnection dbConnection;
	
	public static void main(String args[]) {
		dbConnection = new DBConnection();
		Connection con = null;
		Statement stmt = null;
		try {
			
			con = dbConnection.getConnection();
//			String query = "INSERT INTO LOCATION values ('100002', '73.707016','18.599371','Kanpur') ";
			Event event = new Event();
			event.setAuthorityId("2000");
			event.setEventType("Threat");
			event.setLongitude("73.737561");
			event.setLatitude("18.578375");
			event.setStatus("Logged");
			event.setThreatLevel("2");
			event.setTime("05/08/2017 04:13");
			event.setDescription("Animals have been killed by proachers");
			DBUtils.insertEvent(con, event);
//			stmt = con.createStatement();
//			stmt.executeUpdate(query);
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
