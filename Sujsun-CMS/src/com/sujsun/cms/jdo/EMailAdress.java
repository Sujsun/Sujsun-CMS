package com.sujsun.cms.jdo;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Key;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

public class EMailAdress {
	
	@PrimaryKey
	@Persistent( valueStrategy = IdGeneratorStrategy.IDENTITY )
    private String id;
	
	@Persistent
	String eMail;
	@Persistent
	String type;

}
