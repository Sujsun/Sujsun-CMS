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
import com.sujsun.cms.jdo.Account;
import com.sujsun.cms.jdo.Address;
import com.sujsun.cms.jdo.Contact;

public class ContactService {
	
	private static final Logger log = Logger.getLogger( ContactService.class.getName() );

	public Map<String, Object> createContact( String requestBodyString ) {
		boolean isSuccess = false;
		Map<String, Object> returnHashMap = new HashMap<String, Object>();
		try {
			ContactFactory contactFactory = new ContactFactory();
			System.out.println( "Request String  :: " + requestBodyString );
			Contact contact = ObjectMapper.get().readValue( requestBodyString, new TypeReference<Contact>() {} );
			List<Address> addressList = new ArrayList<Address>();
			for( Address address : contact.getAddressList() ) {
				System.out.println( "After parsing :: HouseNumber :: " + address.getHouseNumber() );
			}
			for( Account account : contact.getAccountList() ) {
				System.out.println( "After parsing :: ApplicationTitle :: " + account.getApplicationTitle() );
			}
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
	
	public Map<String, Object> getContact( String id ) {
		boolean isSuccess = false;
		Map<String, Object> returnHashMap = new HashMap<String, Object>();
		try {
			ContactFactory contactFactory = new ContactFactory();
			Contact contact = contactFactory.getContact( id );
			if( contact != null ) {
				returnHashMap.put( "contact", contact );
				isSuccess = true;
			}
		} catch( Exception exception ) {
			log.log( Level.SEVERE, "Exception while getting contact." );
			exception.printStackTrace();
		} finally {
			returnHashMap.put( "success", isSuccess );
		}
		return returnHashMap;
	}
	
	public Map<String, Object> updateContact( String requestBodyString ) {
		boolean isSuccess = false;
		Map<String, Object> returnHashMap = new HashMap<String, Object>();
		try {
			ContactFactory contactFactory = new ContactFactory();
			Contact contact = ObjectMapper.get().readValue( requestBodyString, new TypeReference<Contact>() {} );
			contact = contactFactory.createContact( contact );
			isSuccess = true;
		} catch( Exception exception ) {
			log.log( Level.SEVERE, "Exception while updating contact." );
			exception.printStackTrace();
		} finally {
			returnHashMap.put( "success", isSuccess );
		}
		return returnHashMap;
	}
	
	public Map<String, Object> deleteContact( String requestBodyString ) {
		boolean isSuccess = false;
		Map<String, Object> returnHashMap = new HashMap<String, Object>();
		try {
			ContactFactory contactFactory = new ContactFactory();
			Contact contact = ObjectMapper.get().readValue( requestBodyString, new TypeReference<Contact>() {} );
			if( contactFactory.deleteContact( contact ) ) {
				returnHashMap.put( "contact", contact );
				isSuccess = true;
			}
		} catch( Exception exception ) {
			log.log( Level.SEVERE, "Exception while deleting contact." );
			exception.printStackTrace();
		} finally {
			returnHashMap.put( "success", isSuccess );
		}
		return returnHashMap;
	}
	
}
