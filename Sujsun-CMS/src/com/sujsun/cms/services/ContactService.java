package com.sujsun.cms.services;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.AbstractDocument.Content;

import org.codehaus.jackson.type.TypeReference;

import com.sujsun.cms.factories.ContactFactory;
import com.sujsun.cms.finalObjects.ObjectMapper;
import com.sujsun.cms.jdo.Contact;

public class ContactService {
	
	private static final Logger log = Logger.getLogger( ContactService.class.getName() );

	public Map<String, Object> createContact( String requestBodyString ) {
		boolean isSuccess = false;
		Map<String, Object> returnHashMap = new HashMap<String, Object>();
		try {
			ContactFactory contactFactory = new ContactFactory();
			System.out.println( requestBodyString );
			Contact contact = ObjectMapper.get().readValue( requestBodyString, new TypeReference<Contact>() {} );
			System.out.println( "FirstName :: " + contact.getFirstName() );
			contact = contactFactory.createContact( contact );
			if( contact != null ) {
				returnHashMap.put( "contact", contact );
				isSuccess = true;
			}
		} catch( Exception exception ) {
			log.log( Level.SEVERE, "Exception while creating contact." );
			exception.printStackTrace();
		} finally {
			returnHashMap.put( "success", isSuccess );
		}
		return returnHashMap;
	}
	
}
