package com.sujsun.cms.services;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sujsun.cms.factories.ContactFactory;
import com.sujsun.cms.factories.SkillFactory;
import com.sujsun.cms.jdo.Contact;
import com.sujsun.cms.jdo.Skill;

public class SkillService {
	
	private static final Logger log = Logger.getLogger( SkillService.class.getName() );
	
	public Map<String, Object> getSkill( String id ) {
		boolean isSuccess = false;
		Map<String, Object> returnHashMap = new HashMap<String, Object>();
		try {
			SkillFactory skillFactory = new SkillFactory();
			Skill skill = skillFactory.getSkill( id );
			if( skill != null ) {
				returnHashMap.put( "skill", skill );
				isSuccess = true;
			}
		} catch( Exception exception ) {
			log.log( Level.SEVERE, "Exception while getting skill." );
			exception.printStackTrace();
		} finally {
			returnHashMap.put( "success", isSuccess );
		}
		return returnHashMap;
	}
	
}
