package com.sujsun.cms.jdo;

import javax.jdo.annotations.IdGeneratorStrategy;

import com.google.appengine.api.datastore.Key;

import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

public class EMailAdress {
	
	private static final long serialVersionUID = 1L;
	
	@PrimaryKey
    @Persistent( valueStrategy = IdGeneratorStrategy.IDENTITY )
    private Key key;
	
	@Persistent
	String eMail;
	@Persistent
	String type;

}
