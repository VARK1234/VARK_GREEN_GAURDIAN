package services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Event;
import database.DBConnection;
import database.DBUtils;
public class FetchUserData {
	
	public List<Event> getEventData(String userId){
		Connection con  = null;
		List<Event> events = null;
		try{
			
			con = DBConnection.getConnection();
			String query = "SELECT AUTHORITY_ID FROM LOGIN WHERE USER_NAME = '"+userId+"' ";
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			String authorityId = "";
			while(rs.next()){
				authorityId = rs.getString(1);
				break;
			}
			if(authorityId == ""){
				return null;
			}
			else {
				String eventQuery = "SELECT EVENT_ID, LATITUDE, LONGITUDE, THREAT_LEVEL,"
						+ " STATUS, AUTHORITY_ID, LOGGED_TIME, EVENT_TYPE,"
						+ " DESCRIPTION FROM EVENT WHERE AUTHORITY_ID = '"+authorityId+"' ";
				events = (List<Event>)DBUtils.getDataFromTable(con, new Event(),
						eventQuery);
			}
		}
		catch(Exception e){
			
		}
		return events;
		
	}
}
