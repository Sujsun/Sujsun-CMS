package com.sujsun.cms.jdo;

import java.io.Serializable;

import javax.jdo.annotations.IdGeneratorStrategy;

import com.google.appengine.api.datastore.Key;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

public class EMailAdress implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@PrimaryKey
    @Persistent( valueStrategy = IdGeneratorStrategy.IDENTITY )
	@Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    private String id;
	
	@Persistent
	String eMail;
	@Persistent
	String type;

}
