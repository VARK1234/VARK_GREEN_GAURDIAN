import java.net.*;

import org.json.JSONObject;

import beans.Constants;
import beans.ForestAuthority;
import beans.Location;
import java.io.*;

public class CityCalculationService {
	
	public Strings caluclateCity(Location location) throws Throwable
	{
		String response = "";
		String url = "https://maps.googleapis.com/maps/api/distancematrix/json?"+"origins="+location.getLatitude()+","+location.getLongitude()+"&destinations=26.439664,80.274440"+"&key="+Constants.DISTANCE_API_KEY;

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		int responseCode = con.getResponseCode();

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;

		while ((inputLine = in.readLine()) != null) {
			response = response+inputLine;
		}
		in.close();
		JSONObject json = new JSONObject(response);
		String[] strings = json.get("origin_addresses").toString().split(",");
		

		return strings[strings.length-3].trim();
	}

}
