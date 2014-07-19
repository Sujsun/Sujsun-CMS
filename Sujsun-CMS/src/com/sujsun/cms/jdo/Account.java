package com.sujsun.cms.jdo;

import javax.jdo.annotations.IdGeneratorStrategy;

import com.google.appengine.api.datastore.Key;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Account {

	private static final long serialVersionUID = 1L;

	@PrimaryKey
    @Persistent( valueStrategy = IdGeneratorStrategy.IDENTITY )
    private Key key;
	
	@Persistent
	private String applicationId;
	@Persistent
	private String applicationTitle;
	
}
