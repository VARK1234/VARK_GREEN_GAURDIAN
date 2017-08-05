package services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import beans.Event;
import beans.Location;
import database.DBConnection;
import database.DBUtils;

public class LocatorService {
	
	public Location findEvent(String eventId)
	{
		Location location = new Location();
		Connection con  = null;
		List<Event> events = null;
		try{
			
			con = DBConnection.getConnection();
			String eventQuery = "SELECT EVENT_ID, LATITUDE, LONGITUDE, THREAT_LEVEL,"
					+ " STATUS, AUTHORITY_ID, LOGGED_TIME, EVENT_TYPE, "
					+ " DESCRIPTION FROM EVENT WHERE EVENT_ID = '"+eventId+"' ";
			
			List<Event> eventList = (List<Event>)DBUtils.getDataFromTable(con, new Event(),
					eventQuery);
			
			
			location.setLatitude(eventList.get(0).getLatitude());
			location.setLongitude(eventList.get(0).getLongitude());
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return location;
	}
		

}
