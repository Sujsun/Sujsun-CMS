package com.sujsun.cms.factories;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sujsun.cms.finalObjects.PMF;
import com.sujsun.cms.jdo.*;

public class ContactFactory {
	
	private static final Logger log = Logger.getLogger( ContactFactory.class.getName() );
	
	public Contact createContact( Contact contactToPersist ) {
		boolean isSuccess = false;
		Contact returnContact = null;
		PersistenceManager persistenceManager = PMF.get().getPersistenceManager();
		try {
			if( getContactByLogin( contactToPersist.getLogin() ) == null ) {
				persistenceManager.currentTransaction().begin();
				returnContact = persistenceManager.makePersistent( contactToPersist );
				persistenceManager.currentTransaction().commit();
				isSuccess = true;
			}
		} catch( Exception exception ) {
			persistenceManager.currentTransaction().rollback();
			log.log( Level.SEVERE, "Error while writing contact to datastore. Exception Message : " + exception.getMessage() );
			exception.printStackTrace();
		} finally {
			persistenceManager.close();
		}
		return returnContact;
	}
	
	public Contact getContact( String id ) {
		boolean isSuccess = false;
		Contact returnContact = null;
		PersistenceManager persistenceManager = PMF.get().getPersistenceManager();
		try {
			persistenceManager.currentTransaction().begin();
			returnContact = persistenceManager.getObjectById( Contact.class, id );
			persistenceManager.currentTransaction().commit();
			isSuccess = true;
		} catch( JDOObjectNotFoundException jdoObjectNotFoundException ) {
			log.log( Level.SEVERE, "Warning :: Contact not found with the given id. Given contactId : " + id );
			persistenceManager.currentTransaction().rollback();
			// jdoObjectNotFoundException.printStackTrace();
		} catch( Exception exception ) {
			persistenceManager.currentTransaction().rollback();
			log.log( Level.SEVERE, "Error while getting contact from datastore." );
			exception.printStackTrace();
		} finally {
			persistenceManager.close();
		}
		return returnContact;
	}
	
	public boolean deleteContact( Contact contactToDelete ) {
		boolean isSuccess = false;
		Contact returnContact = null;
		PersistenceManager persistenceManager = PMF.get().getPersistenceManager();
		try {
			persistenceManager.currentTransaction().begin();
			persistenceManager.deletePersistent( contactToDelete );
			persistenceManager.currentTransaction().commit();
			isSuccess = true;
		} catch( Exception exception ) {
			persistenceManager.currentTransaction().rollback();
			log.log( Level.SEVERE, "Error while getting contact from datastore." );
			exception.printStackTrace();
		} finally {
			persistenceManager.close();
		}
		return isSuccess;
	}
	
	/*
	 * Get Contact By Login 
	 */
	public Contact getContactByLogin( String login ) {
		boolean isSuccess = false;
		Contact returnContact = null;
		PersistenceManager persistenceManager = PMF.get().getPersistenceManager();
		try {
			// persistenceManager.currentTransaction().begin();
			Query query = persistenceManager.newQuery( Contact.class, "login == loginParam" );
			query.declareParameters( "String loginParam" );
			List<Contact> contactList = (List<Contact>) query.execute( login );
			// persistenceManager.currentTransaction().commit();
			if( contactList.size() > 0 ) {
				returnContact = contactList.get( 0 );
			}
			isSuccess = true;
		} catch( Exception exception ) {
			log.log( Level.SEVERE, "Error while getting contact from datastore." );
			exception.printStackTrace();
		} finally {
			// persistenceManager.close();
		}
		return returnContact;
	}
	
}
