package com.sujsun.cms.jdo;

import javax.jdo.annotations.IdGeneratorStrategy;
import com.google.appengine.api.datastore.Key;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Address {
	
	private static final long serialVersionUID = 1L;

	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;
	
	@Persistent
	private String houseNumber;
	@Persistent
	private String street;
	@Persistent
	private String addressLine1;
	@Persistent
	private String addressLine2;
	@Persistent
	private String region;
	@Persistent
	private String district;
	@Persistent
	private String pinCode;
	@Persistent
	private String state;
	@Persistent
	private String country;
	@Persistent
	private String landMark;
	
}
