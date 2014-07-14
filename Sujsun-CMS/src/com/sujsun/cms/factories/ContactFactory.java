package com.sujsun.cms.factories;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sujsun.cms.finalObjects.PMF;
import com.sujsun.cms.jdo.Contact;

public class ContactFactory {
	
	private static final Logger log = Logger.getLogger( ContactFactory.class.getName() );
	
	public Contact createContact( Contact contactToPersist ) {
		boolean isSuccess = false;
		Contact returnContact = null;
		PersistenceManager persitenceManager = PMF.get().getPersistenceManager();
		try {
			contactToPersist.setId( UUID.randomUUID().toString() );
			returnContact = persitenceManager.makePersistent( contactToPersist );
			isSuccess = true;
		} catch( Exception exception ) {
			log.log( Level.SEVERE, "Error while writing contact to datastore." );
			exception.printStackTrace();
		}
		return returnContact;
	}
	
}
