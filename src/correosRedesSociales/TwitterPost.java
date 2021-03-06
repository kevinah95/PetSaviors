package correosRedesSociales;
//Basado en el ejemplo de http://xmeng.wordpress.com/2011/07/10/how-to-handle-sign-in-with-twitter-using-twitter4j/
import twitter4j.*;
import twitter4j.auth.*;
import twitter4j.conf.ConfigurationBuilder;
import java.awt.Desktop;
import java.io.IOException;
import java.net.*;
 
public final class TwitterPost {

	//private String pin;
	//private boolean advance;
	private RequestToken requestToken;
	private TwitterFactory tf;
	private Twitter twitter;
	
    public TwitterPost() {
        //pin = "";
        //advance = false;
        ConfigurationBuilder cb = new ConfigurationBuilder();
        
         
        //the following is set without accesstoken- desktop client
        cb.setDebugEnabled(true)
      .setOAuthConsumerKey("kOlqGpDbHD7FM6YpgYgexX0KX")
      .setOAuthConsumerSecret("Gq4NCDE9XLJWEyUq5J3mHgVLm8Is8fqaEkbTHH7yXCdZNEQXUT");
   
        try {
            tf = new TwitterFactory(cb.build());
            twitter = tf.getInstance();
            requestToken = twitter.getOAuthRequestToken();
            URL url= new URL(requestToken.getAuthorizationURL());
            openWebpage(url);
	        
            
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to get timeline: " + te.getMessage());
            System.exit(-1);
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.out.println("Failed to read the system input.");
            System.exit(-1);
        }
    }
    
    public void validarPIN(String pin){
    try{
    	String testStatus = "Encontr� a mi mascota gracias a Pet Saviors, pru�balo tu tambi�n";
	    try {
	        //System.out.println("-----");
	
	        // get request token.
	        // this will throw IllegalStateException if access token is already available
	        // this is oob, desktop client version
	        //RequestToken requestToken = twitter.getOAuthRequestToken(); 
	
	        //System.out.println("Got request token.");
	       // System.out.println("Request token: " + requestToken.getToken());
	        //System.out.println("Request token secret: " + requestToken.getTokenSecret());
	
	        //System.out.println("|-----");
	
	        AccessToken accessToken = null;
	        
	        while (null == accessToken) {
	        
	            try {
	                if (pin.length() > 0) {
	                    accessToken = twitter.getOAuthAccessToken(requestToken, pin);
	                } else {
	                    accessToken = twitter.getOAuthAccessToken(requestToken);
	                }
	            } catch (TwitterException te) {
	                if (401 == te.getStatusCode()) {
	                    System.out.println("Unable to get the access token.");
	                } else {
	                    te.printStackTrace();
	                }
	            }
	        }
	        System.out.println("Got access token.");
	        System.out.println("Access token: " + accessToken.getToken());
	        System.out.println("Access token secret: " + accessToken.getTokenSecret());
	         
	    } catch (IllegalStateException ie) {
	        // access token is already available, or consumer key/secret is not set.
	        if (!twitter.getAuthorization().isEnabled()) {
	            System.out.println("OAuth consumer key/secret is not set.");
	            System.exit(-1);
	        }
	    }
     
	    Status status = twitter.updateStatus(testStatus);

	    System.out.println("Successfully updated the status to [" + status.getText() + "].");

	    System.out.println("ready exit");
    } catch (TwitterException te) {
        te.printStackTrace();
        System.out.println("Failed to get timeline: " + te.getMessage());
        System.exit(-1);}
    }
    
    
    //Funcion Auxiliar de openWebpage para URL
    public static void openWebpage(java.net.URI string) {
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(string);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    //Abre el navegador predeterminado con el URL que reciba
    public static void openWebpage(URL url) {
        try {
            openWebpage(url.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
   
}