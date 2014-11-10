package correosRedesSociales;

import facebook4j.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import facebook4j.Facebook;
import facebook4j.FacebookBase;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Friend;
import facebook4j.Post;
import facebook4j.ResponseList;
import facebook4j.User;

import facebook4j.conf.ConfigurationBuilder;



public class FacebookPost {
	public static void main(String[] args) {
		
		String testStatus="Encontré a mi mascota gracias a Pet Saviors, pruébalo tu también";
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
		
		cb.setDebugEnabled(true)
		  .setOAuthAppId("334348700069929")
		  .setOAuthAppSecret("565fa03681fa56e2d7c42e9ed817913a")
		  .setOAuthAccessToken("c5f8ba4ac3652234715a38f405aeda85")
		  .setOAuthPermissions("email,publish_stream,...");
		FacebookFactory ff = new FacebookFactory(cb.build());
		Facebook facebook = ff.getInstance();
		try {
			facebook.postStatusMessage(testStatus);
		} catch (FacebookException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
