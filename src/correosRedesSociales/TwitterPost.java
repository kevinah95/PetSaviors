package correosRedesSociales;


import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;


public class TwitterPost {

	    public static void main(String[] args) throws IOException, TwitterException {
	 
	        //Your Twitter App's Consumer Key
	        String consumerKey = "kOlqGpDbHD7FM6YpgYgexX0KX";
	 
	        //Your Twitter App's Consumer Secret
	        String consumerSecret = "Gq4NCDE9XLJWEyUq5J3mHgVLm8Is8fqaEkbTHH7yXCdZNEQXUT";
	 
	        //Your Twitter Access Token
	        String accessToken = "1140402386-aO4jGxogQGuQpRdyF6CpqtNd6DnxR4CWSERDEfg";
	 
	        //Your Twitter Access Token Secret
	        String accessTokenSecret = "GqI95hkEBFjMgUs4EAvG50uK0utYSQLtTFvgj8wloDr2L";
	 
	        //Instantiate a re-usable and thread-safe factory
	        TwitterFactory twitterFactory = new TwitterFactory();
	 
	        //Instantiate a new Twitter instance
	        Twitter twitter = twitterFactory.getInstance();
	 
	        //setup OAuth Consumer Credentials
	        twitter.setOAuthConsumer(consumerKey, consumerSecret);
	 
	        //setup OAuth Access Token
	        twitter.setOAuthAccessToken(new AccessToken(accessToken, accessTokenSecret));
	 
	        //Instantiate and initialize a new twitter status update
	        StatusUpdate statusUpdate = new StatusUpdate(
	                //your tweet or status message
	                "Testing Twitter Java API for Pet Saviors Application");
	        //attach any media, if you want to
	        statusUpdate.setMedia(
	                //title of media
	                "http://h1b-work-visa-usa.blogspot.com"
	                , new URL("https://38.media.tumblr.com/8397f74a6058db124d861242c334a3fe/tumblr_ne7z0f3YZJ1tdscmao1_400.gif").openStream());
	 
	        //tweet or update status
	        Status status = twitter.updateStatus(statusUpdate);
	        System.out.println("status.getText() = " + status.getText());
	     
	    }
	 
	}
	
