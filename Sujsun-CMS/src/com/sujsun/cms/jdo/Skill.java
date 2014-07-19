package com.sujsun.cms.jdo;

import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Skill {
	
	private static final long serialVersionUID = 1L;

	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;
	
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private String id;
	
	@Persistent
	private String skillTitle;
	@Persistent
	private String skillDescription;
	@Persistent
	private List<String> applicationId;
	
}
