package demo;

import java.sql.*;
import java.util.List;

import beans.Event;
import beans.ForestAuthority;
import beans.Location;
import beans.Login;
import database.DBConnection;
import database.DBUtils;

class MainClass {
	
	private static DBConnection dbConnection;
	
	public static void main(String args[]) {
		dbConnection = new DBConnection();
		Connection con = null;
		try {
			
			con = dbConnection.getConnection();

			String query = "select location_id, "
							+ "longitude, latitude, city from LOCATION "
							+ " where location_id = '100002' ";
			String eventQuery = "SELECT EVENT_ID, LATITUDE, LONGITUDE, THREAT_LEVEL,"
					+ " STATUS, AUTHORITY_ID, LOGGED_TIME, EVENT_TYPE, DESCRIPTION FROM EVENT ";
			String forest_authority_query = "SELECT ID, TYPE_C, LOCATION_ID FROM FOREST_AUTHORITY ";
			String login_query = "SELECT USER_NAME, ROLE, PASSWORD FROM LOGIN";
			//*******************
			System.out.println("*******Location******");
			List<Location> location = (List<Location>)DBUtils.getDataFromTable(con, new Location(),
					query);
			
			for(Location loc : location){
				System.out.println(loc.getCity());
			}
			//**********************
			System.out.println("********Event********");
			List<Event> eventList = (List<Event>)DBUtils.getDataFromTable(con, new Event(),
					eventQuery);
			for(Event event : eventList){
				System.out.println(event.getId()+", "+event.getEventType()+", "+event.getDescription());
			}
			//***************
			System.out.println("********Forest Authority*******");
			List<ForestAuthority> forestList = (List<ForestAuthority>)DBUtils.getDataFromTable(con, new ForestAuthority(),
					forest_authority_query);
			for(ForestAuthority authority : forestList){
				System.out.println(authority.getId()+", "+authority.getType()+", "+authority.getLocation().getCity());
			}
			//****************
			System.out.println("******Login*******");
			List<Login> loginList = (List<Login>)DBUtils.getDataFromTable(con, new Login(),
					login_query);
			for(Login login : loginList){
				System.out.println(login.getUserName()+", "+login.getRole());
			}
			
			
			con.close();

		} catch (Exception e) {
			System.out.println("Exception 0");
			System.out.println(e);
		}

	}
}