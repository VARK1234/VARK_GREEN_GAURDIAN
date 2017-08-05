package services;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class TwitterAuto {
	
	static String consumerKeyStr = "2moWw0EXsoyErAV6T6zZpVdeY";
	static String consumerSecretStr = "cgxCzdg1R8ICIIh61Y8mjgdgJ74iKY816VZtUDcbZZsNHYXloE";
	static String accessTokenStr = "893548846789279744-LLfWSr9sD4ZWlArPcKXXrQ831D4eqOG";
	static String accessTokenSecretStr = "Vy7bzB1aOCNhiVHSzWchM7T7OIcCLrYvQHSEFq8TQ5E7r";

	public static void postTweet(String des) {

		try {
			Twitter twitter = new TwitterFactory().getInstance();
			
			twitter.setOAuthConsumer(consumerKeyStr, consumerSecretStr);
			AccessToken accessToken = new AccessToken(accessTokenStr,
					accessTokenSecretStr);

			twitter.setOAuthAccessToken(accessToken);
			//String des = "I am here to save the Environment.\nDon't worry Mother Earth\nLet's try to add more than 140 characters";
			String status = "@vikassheelu "+des+" #greenhack";
			if(status.length()<140){
				twitter.updateStatus(status);
				
			}
			else{
				int parts = (status.length()/140);
				
				int ini = 0, end = 140;
				do{
					twitter.updateStatus(status.substring(ini, end));
					ini +=140;
					if(parts==1){
						end = status.length();
					}else{
						end +=140;
					}
					parts--;
				}while(parts>=0);
			}
			

			System.out.println("Successfully updated the status in Twitter.");
		} catch (TwitterException te) {
			te.printStackTrace();
		}
	}
}