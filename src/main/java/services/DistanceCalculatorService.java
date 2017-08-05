package services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONObject;

import beans.Constants;
import beans.Location;

public class DistanceCalculatorService {
	
	
	public Double findDistance(Location originLocation, Location destinationLocation) throws MalformedURLException
	{
		String sub2 = "";
		try{
		String response = "";
		String url = "https://maps.googleapis.com/maps/api/distancematrix/json?"+"origins="+originLocation.getLatitude()+","+destinationLocation.getLongitude()+"&destinations="+destinationLocation.getLatitude()+","+originLocation.getLongitude()+"&key="+Constants.DISTANCE_API_KEY;

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
		int c = response.indexOf("distance");
	      //System.out.println(jsonText);
	      String sub = response.substring(response.indexOf('{', c)+1, response.indexOf('}', c));
	      //System.out.println(sub);
	      int d = sub.indexOf("value");
	      //System.out.println(d);
	      sub2 = sub.substring(sub.indexOf(':', d)+2);
		}
		catch(Exception e)
		{
			
		}
		return Double.parseDouble(sub2);
	
	}
	

}
