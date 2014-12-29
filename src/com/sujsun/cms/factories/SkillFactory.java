package com.sujsun.cms.factories;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;

import com.sujsun.cms.finalObjects.PMF;
import com.sujsun.cms.jdo.Contact;
import com.sujsun.cms.jdo.Skill;

public class SkillFactory {

	private static final Logger log = Logger.getLogger( SkillFactory.class.getName() );
	
	public Skill createSkill( Skill skillToPersist ) {
		boolean isSuccess = false;
		Skill returnSkill = null;
		PersistenceManager persistenceManager = PMF.get().getPersistenceManager();
		try {
			persistenceManager.currentTransaction().begin();
			returnSkill = persistenceManager.makePersistent( skillToPersist );
			persistenceManager.currentTransaction().commit();
			isSuccess = true;
		} catch( Exception exception ) {
			persistenceManager.currentTransaction().rollback();
			log.log( Level.SEVERE, "Error while writing Skill to datastore." );
			exception.printStackTrace();
		} finally {
			persistenceManager.close();
		}
		return returnSkill;
	}
	
	public Skill getSkill( String id ) {
		boolean isSuccess = false;
		Skill returnSkill = null;
		PersistenceManager persistenceManager = PMF.get().getPersistenceManager();
		try {
			persistenceManager.currentTransaction().begin();
			returnSkill = persistenceManager.getObjectById( Skill.class, id );
			persistenceManager.currentTransaction().commit();
			isSuccess = true;
		} catch( JDOObjectNotFoundException jdoObjectNotFoundException ) {
			log.log( Level.SEVERE, "Warning :: Skill not found with the given id. Given skill id : " + id );
			persistenceManager.currentTransaction().rollback();
			// jdoObjectNotFoundException.printStackTrace();
		} catch( Exception exception ) {
			persistenceManager.currentTransaction().rollback();
			log.log( Level.SEVERE, "Error while getting skill from datastore." );
			exception.printStackTrace();
		} finally {
			persistenceManager.close();
		}
		return returnSkill;
	}
	
	public boolean deleteSkill( Contact skillToDelete ) {
		boolean isSuccess = false;
		Skill returnSkill = null;
		PersistenceManager persistenceManager = PMF.get().getPersistenceManager();
		try {
			persistenceManager.currentTransaction().begin();
			persistenceManager.deletePersistent( skillToDelete );
			persistenceManager.currentTransaction().commit();
			isSuccess = true;
		} catch( Exception exception ) {
			persistenceManager.currentTransaction().rollback();
			log.log( Level.SEVERE, "Error while updating contact in datastore." );
			exception.printStackTrace();
		} finally {
			persistenceManager.close();
		}
		return isSuccess;
	}
	
}
