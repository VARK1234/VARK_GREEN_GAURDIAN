import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import beans.Event;
import beans.ForestAuthority;
import beans.Location;
import database.DBConnection;
import database.DBUtils;

public class ConcernedForestAuthorityFinder {
	
	private static DBConnection dbConnection;
	
	public ForestAuthority findForestAuthority(Event)
	{
		ForestAuthority concernedAuthority = new ForestAuthority();
		String city = new CityCalculationService().caluclateCity(location); 
		location.setCity(city);
		List<ForestAuthority> forestAuthorities  = new ArrayList<>();
		dbConnection = new DBConnection();
		Connection con = null;
		con = dbConnection.getConnection();
		String query = "select location_id, "
				+ "longitude, latitude, city from LOCATION "
				+ " where city = "+location.getCity();
		List<Location> location = (List<Location>)DBUtils.getDataFromTable(con, new Location(),
				query);
		String q = "";
		for(Location loc : location){
			q = q + "'"+loc.getLocationId()+"',";
		}
		q = q.substring(0, q.length()-1);
		String forest_authority_query = "SELECT ID, TYPE_C, LOCATION_ID FROM FOREST_AUTHORITY"
				+ " where location_id in ( "+location.get+")";
		forestAuthorities = (List<ForestAuthority>)DBUtils.getDataFromTable(con, new ForestAuthority(),
				forest_authority_query);
		int count = 0;
		for(ForestAuthority forestAuthority : forestAuthorities)
		{ 
			int tagsFound = 0;
			HashMap<String, Set<String>> hashMap = new HashMap<>();
			Set<String> tags = hashMap.get(forestAuthority.getType());
			List<String> tokens = new ArrayList<>();
			if(tagsFound>count)
			{
				count = tagsfound;
				concernedAuthority = forestAuthority;
			}
			
		}
	}

}
