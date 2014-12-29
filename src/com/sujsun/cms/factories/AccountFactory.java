package com.sujsun.cms.factories;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;

import com.sujsun.cms.finalObjects.PMF;
import com.sujsun.cms.jdo.*;

public class AccountFactory {
	
	private static final Logger log = Logger.getLogger( AccountFactory.class.getName() );
	
	public Account createAccount( Account accountToPersist ) {
		boolean isSuccess = false;
		Account returnAccount = null;
		PersistenceManager persistenceManager = PMF.get().getPersistenceManager();
		try {
			persistenceManager.currentTransaction().begin();
			returnAccount = persistenceManager.makePersistent( accountToPersist );
			persistenceManager.currentTransaction().commit();
			isSuccess = true;
		} catch( Exception exception ) {
			persistenceManager.currentTransaction().rollback();
			log.log( Level.SEVERE, "Error while writing account to datastore." );
			exception.printStackTrace();
		} finally {
			persistenceManager.close();
		}
		return returnAccount;
	}
	
	public Account getAccount( String id ) {
		boolean isSuccess = false;
		Account returnAccount = null;
		PersistenceManager persistenceManager = PMF.get().getPersistenceManager();
		try {
			persistenceManager.currentTransaction().begin();
			returnAccount = persistenceManager.getObjectById( Account.class, id );
			persistenceManager.currentTransaction().commit();
			isSuccess = true;
		} catch( JDOObjectNotFoundException jdoObjectNotFoundException ) {
			log.log( Level.SEVERE, "Warning :: Account not found with the given id. Given contactId : " + id );
			persistenceManager.currentTransaction().rollback();
			// jdoObjectNotFoundException.printStackTrace();
		} catch( Exception exception ) {
			persistenceManager.currentTransaction().rollback();
			log.log( Level.SEVERE, "Error while getting account from datastore." );
			exception.printStackTrace();
		} finally {
			persistenceManager.close();
		}
		return returnAccount;
	}
	
	public boolean deleteAccount( Contact accountToDelete ) {
		boolean isSuccess = false;
		PersistenceManager persistenceManager = PMF.get().getPersistenceManager();
		try {
			persistenceManager.currentTransaction().begin();
			persistenceManager.deletePersistent( accountToDelete );
			persistenceManager.currentTransaction().commit();
			isSuccess = true;
		} catch( Exception exception ) {
			persistenceManager.currentTransaction().rollback();
			log.log( Level.SEVERE, "Error while updating account in datastore." );
			exception.printStackTrace();
		} finally {
			persistenceManager.close();
		}
		return isSuccess;
	}
	
}
