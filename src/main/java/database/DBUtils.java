package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Event;
import beans.ForestAuthority;
import beans.Location;
import beans.Login;

public class DBUtils {
	
	public static Object getDataFromTable(Connection con, Object obj, String query){
		
			try {
				//step3 create the statement object
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				return getObject(con, obj, rs);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Exception 1");
				e.printStackTrace();
			}
		
		return obj;
	}
	public static String getTable(Object obj){
		
		if(obj instanceof Location){
			return " LOCATION ";
		}
		else if(obj instanceof ForestAuthority){
			return " FOREST_AUTHORITY ";
		}
		else if(obj instanceof Login){
			return " LOGIN ";
		}
		else if(obj instanceof Event){
			return " EVENT ";
		}
		
		return null;
	}
	
	public static void insertEvent(Connection con, Event event){
		try {
			Statement stmt = null;
			stmt = con.createStatement();
			
			String q = "SELECT max(EVENT_ID) FROM EVENT ";
			ResultSet rs = stmt.executeQuery(q);
			int maxEvent= 10000;
			while(rs.next()){
				maxEvent = Integer.parseInt(rs.getString(1));
			}
			
			String query = "INSERT INTO EVENT VALUES( '"+(maxEvent+1)+"', '"+event.getLatitude()+"', '"+event.getLongitude()+"', '"+
					event.getThreatLevel()+"', '"+event.getStatus()+"', '"+event.getAuthorityId()+"', '"+
					event.getTime()+"', '"+event.getEventType()+"' )";
			
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static Object getObject(Connection con, Object obj, ResultSet rs){
		
		try{
			if(obj instanceof Location){
				List<Location> list = new ArrayList<Location>();
				while (rs.next())
				{
					Location location = new Location();
					location.setLocationId(rs.getString(1));
					location.setLocationId(rs.getString(2));
					location.setLatitude(rs.getString(3));
					location.setCity(rs.getString(4));
					list.add(location);
				}
				return list;
			}
			else if(obj instanceof Event){
				List<Event> list = new ArrayList<Event>();
				while (rs.next())
				{
					Event event = new Event();
					event.setId(rs.getString(1));
					event.setLatitude(rs.getString(2));
					event.setLongitude(rs.getString(3));
					event.setThreatLevel(rs.getString(4));
					event.setStatus(rs.getString(5));
					event.setAuthorityId(rs.getString(6));
					event.setTime(rs.getString(7));
					event.setEventType(rs.getString(8));
					list.add(event);
				}
				return list;
			}
			else if(obj instanceof ForestAuthority){
				List<ForestAuthority> list = new ArrayList<ForestAuthority>();
				while(rs.next()){
					ForestAuthority f = new ForestAuthority();
					f.setId(rs.getString(1));
					f.setType(rs.getString(2));
					String query = "select location_id, "
							+ "longitude, latitude, city from LOCATION "
							+ " where location_id = "+rs.getString(3);
					List<Location> location = (List<Location>)DBUtils.getDataFromTable(con, new Location(),
							query);
					f.setLocation(location.get(0));
					list.add(f);
				}
				return list;
			}
			else if(obj instanceof Login){
				List<Login> list = new ArrayList<Login>();
				while(rs.next()){
					Login login = new Login();
					login.setUserName(rs.getString(1));
					login.setPassword(rs.getString(2));
					login.setRole(rs.getString(3));
					list.add(login);
				}
				return list;
			}
		}
		catch(Exception e){
			System.out.println("Exception 2");
			e.printStackTrace();
		}
		return null;
	}
}
