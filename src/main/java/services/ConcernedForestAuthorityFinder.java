package services;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import beans.Event;
import beans.ForestAuthority;
import beans.Location;
import dao.CacheClass;
import database.DBConnection;
import database.DBUtils;

public class ConcernedForestAuthorityFinder {
	
	private static DBConnection dbConnection; 
	
	public ForestAuthority findForestAuthority(Event event) throws Throwable
	{ 
		ForestAuthority concernedAuthority = new ForestAuthority();
		try{
		
		Location localLocation = new Location();
		localLocation.setLatitude(event.getLatitude());
		localLocation.setLongitude(event.getLongitude());
		String city = new CityCalculationService().caluclateCity(localLocation); 
		localLocation.setCity(city);
		List<ForestAuthority> forestAuthorities  = new ArrayList<>();
		dbConnection = new DBConnection(); 
		Connection con = null;  
		con = dbConnection.getConnection();
		String query = "select location_id, "
				+ "longitude, latitude, city from LOCATION "
				+ " where city = '"+localLocation.getCity()+"'";
		List<Location> locations = (List<Location>)DBUtils.getDataFromTable(con, new Location(),
				query);
		String q = "";
		for(Location loc : locations){
			q = q + "'"+loc.getLocationId()+"',";
		}
		q = q.substring(0, q.length()-1);
		String forest_authority_query = "SELECT ID, TYPE_C, LOCATION_ID FROM FOREST_AUTHORITY"
				+ " where location_id in ( "+q+")";
		forestAuthorities = (List<ForestAuthority>)DBUtils.getDataFromTable(con, new ForestAuthority(),
				forest_authority_query);
		int count = 0;
		for(ForestAuthority forestAuthority : forestAuthorities)
		{ 
			int tagsFound = 0;
			CacheClass cacheClass = new CacheClass();
			HashMap<String, Set<String>> tagsHashMap = (HashMap<String, Set<String>>) CacheClass.getAllDepTags();
			Set<String> tags = tagsHashMap.get(forestAuthority.getType());
			String[] descriptionTokens = event.getDescription().toLowerCase().split(" ");
			for(int i = 0; i<descriptionTokens.length;i++)
			{
				if(tags.contains(descriptionTokens[i]))
				{
					tagsFound++;
				}
			}
			if(tagsFound>count)
			{
				count = tagsFound;
				concernedAuthority = forestAuthority;
			}
			
		}
	}
	
	
	catch(Exception e)
	{
		
	}
	return concernedAuthority;
	}
	
	public ForestAuthority refineAuthorityFinder(Event event, String authorityType) throws Throwable
	{
		 
		ForestAuthority concernedAuthority = new ForestAuthority();
		try{
		
		Location localLocation = new Location();
		localLocation.setLatitude(event.getLatitude());
		localLocation.setLongitude(event.getLongitude());
		String city = new CityCalculationService().caluclateCity(localLocation); 
		localLocation.setCity(city);
		List<ForestAuthority> forestAuthorities  = new ArrayList<>();
		dbConnection = new DBConnection(); 
		Connection con = null;  
		con = dbConnection.getConnection();
		String query = "select location_id, "
				+ "longitude, latitude, city from LOCATION "
				+ " where city = '"+localLocation.getCity()+"'";
		List<Location> locations = (List<Location>)DBUtils.getDataFromTable(con, new Location(),
				query);
		String q = "";
		for(Location loc : locations){
			q = q + "'"+loc.getLocationId()+"',";
		}
		q = q.substring(0, q.length()-1);
		String forest_authority_query = "SELECT ID, TYPE_C, LOCATION_ID FROM FOREST_AUTHORITY"
				+ " where location_id in ( "+q+")";
		forestAuthorities = (List<ForestAuthority>)DBUtils.getDataFromTable(con, new ForestAuthority(),
				forest_authority_query);
		
		double min = 0;
		Location eventLoc = new Location();
		eventLoc.setLatitude(event.getLatitude());
		eventLoc.setLongitude(event.getLongitude());
		for(ForestAuthority forestAuthority : forestAuthorities)
		{
			double distance = 0;
			if(authorityType.equalsIgnoreCase(forestAuthority.getType())){
			distance = new DistanceCalculatorService().findDistance(eventLoc, forestAuthority.getLocation());
			if(distance>min)
			{
				min = distance;
				concernedAuthority = forestAuthority;
			}
		}
		}
	}
	
	
	catch(Exception e)
	{
		
	}
	return concernedAuthority;
	
	}
}
