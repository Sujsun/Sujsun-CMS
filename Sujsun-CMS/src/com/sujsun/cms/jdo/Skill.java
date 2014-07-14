package com.sujsun.cms.jdo;

import java.util.List;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Key;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Skill {
	
	@PrimaryKey
	@Persistent( valueStrategy = IdGeneratorStrategy.IDENTITY )
    private String id;
	
	@Persistent
	private String skillTitle;
	@Persistent
	private String skillDescription;
	@Persistent
	private List<String> applicationId;
	
}
