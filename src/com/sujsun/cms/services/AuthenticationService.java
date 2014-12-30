package com.sujsun.cms.services;

import java.security.MessageDigest;
import java.util.Map;
import java.util.logging.Logger;

import org.codehaus.jackson.type.TypeReference;

import com.google.appengine.labs.repackaged.org.json.JSONObject;
import com.sujsun.cms.factories.ContactFactory;
import com.sujsun.cms.finalObjects.ObjectMapper;
import com.sujsun.cms.jdo.Contact;
import com.sujsun.cms.util.MD5HashUtil;

public class AuthenticationService {
	
	private static final Logger log = Logger.getLogger( AuthenticationService.class.getName() );
	
	public Contact authenticate( String requestJSONString ) {
		boolean isSuccess = false;
		Contact returnContact = null;
		try {
			JSONObject requestJSONObject = new JSONObject( requestJSONString );
			String login = requestJSONObject.getString( "login" );
			String password = requestJSONObject.getString( "password" );
			boolean skipPassword = requestJSONObject.getBoolean( "skipPassword" );
			returnContact = authenticate( login, password, skipPassword );
			isSuccess = true;
		} catch( Exception exception ) {
			log.severe( "Exception while authenticating. Exception Message : " + exception.getMessage() );
			exception.printStackTrace();
		}
		return returnContact;
	}
	
	public Contact authenticate( String login, String password, boolean skipPassword ) {
		boolean isSuccess = false, isAuthenticated = false;
		Contact returnContact = null;
		try {
			Contact contact = new ContactFactory().getContactByLogin( login );
			if( contact != null ) {
				if( !skipPassword ) {
					String hashPassword = MD5HashUtil.encode( password );
					if( contact.getPassword().equals( hashPassword ) ) {
						returnContact = contact;
						isAuthenticated = true;
					} else {
						log.info( "Password didnot match." );
					}
				} else {
					returnContact = contact;
					isAuthenticated = true;
				}
			}
			isSuccess = true;
		} catch( Exception exception ) {
			log.severe( "Exception while authenticating. Exception Message : " + exception.getMessage() );
			exception.printStackTrace();
		}
		return returnContact;
	}

}
