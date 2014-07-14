package com.sujsun.cms.jdo;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Key;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Address {
	
	@PrimaryKey
	@Persistent( valueStrategy = IdGeneratorStrategy.IDENTITY )
    private Long id;
	
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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
