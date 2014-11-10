package correosRedesSociales;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

//import net.sf.json.JSONObject;
//import net.sf.json.JsonConfig;
import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Post;
import facebook4j.ResponseList;
import facebook4j.conf.Configuration;
import facebook4j.conf.ConfigurationBuilder;

public class FacebookPost {
	
	public static void main(String[] args) throws FacebookException {
		// Create conf builder and set authorization and access keys
		ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
		configurationBuilder.setDebugEnabled(true);
		configurationBuilder.setOAuthAppId("334348700069929");
		configurationBuilder.setOAuthAppSecret("565fa03681fa56e2d7c42e9ed817913a");
		configurationBuilder.setOAuthAccessToken("CAACEdEose0cBANUu3qhxUziHxbANNekC3D7GzBGLZAHzVJFhtdtUVmXkVPXisNsS74BtFII6lVhJZAZBLmEo08UzT4EaXzzsWwAZAXZB8yAmgmT4zhOOvTlVZAs5gqPnz4TQLmGoP8Ky6PhIgeZBd3ZCAR6lYhA8bF1p3q8ZAYrGlPOQpaxiKtMJwpmDii7EGEGVNBQvKcYaPTDhsITAZAYJlt3zUfodFCAW8ZD");
		configurationBuilder
				.setOAuthPermissions("email, publish_stream, id, name, first_name, last_name, read_stream , generic");
		configurationBuilder.setUseSSL(true);
		configurationBuilder.setJSONStoreEnabled(true);

		// Create configuration and get Facebook instance
		Configuration configuration = configurationBuilder.build();
		FacebookFactory ff = new FacebookFactory(configuration);
		Facebook facebook = ff.getInstance();

		System.out.println("completed");
		facebook.postStatusMessage("Hello World from Facebook4J.");
	}

	// This method is used to get Facebook posts based on the search string set
	// above
	public static String getFacebookPostes(Facebook Facebook, String searchPost)
			throws FacebookException {
		String searchResult = "Item : " + searchPost + "\n";
		StringBuffer searchMessage = new StringBuffer();
		ResponseList<Post> results = Facebook.getPosts(searchPost);
		for (Post post : results) {
			System.out.println(post.getMessage());
			searchMessage.append(post.getMessage() + "\n");
			for (int j = 0; j < post.getComments().size(); j++) {
				searchMessage.append(post.getComments().get(j).getFrom()
						.getName()
						+ ", ");
				searchMessage.append(post.getComments().get(j).getMessage()
						+ ", ");
				searchMessage.append(post.getComments().get(j).getCreatedTime()
						+ ", ");
				searchMessage.append(post.getComments().get(j).getLikeCount()
						+ "\n");
			}
		}
		String feedString = getFacebookFeed(Facebook, searchPost);
		searchResult = searchResult + searchMessage.toString();
		searchResult = searchResult + feedString;
		return searchResult;
	}

	// This method is used to get Facebook feeds based on the search string set
	// above
	public static String getFacebookFeed(Facebook Facebook, String searchPost)
			throws FacebookException {
		String searchResult = "";
		StringBuffer searchMessage = new StringBuffer();
		ResponseList<Post> results = Facebook.getFeed(searchPost);
		for (Post post : results) {
			System.out.println(post.getMessage());
			searchMessage.append(post.getFrom().getName() + ", ");
			searchMessage.append(post.getMessage() + ", ");
			searchMessage.append(post.getCreatedTime() + "\n");
		}
		searchResult = searchResult + searchMessage.toString();
		return searchResult;
	}

	// This method is used to create JSON object from data string
//	public static String stringToJson(String data) {
////		JsonConfig cfg = new JsonConfig();
////		try {
////			JSONObject jsonObject = JSONObject.fromObject(data, cfg);
////			System.out.println("JSON = " + jsonObject.toString());
////		} catch (Exception e) {
////			e.printStackTrace();
////		}
////		return "JSON Created";
//	}
}