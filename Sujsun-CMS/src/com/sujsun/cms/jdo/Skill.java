package com.sujsun.cms.jdo;

import java.util.List;

import javax.jdo.annotations.Extension;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;

@PersistenceCapable
public class Skill {
	
	private static final long serialVersionUID = 1L;

	@PrimaryKey
    @Persistent( valueStrategy = IdGeneratorStrategy.IDENTITY )
	@Extension(vendorName="datanucleus", key="gae.encoded-pk", value="true")
    private String id;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSkillTitle() {
		return skillTitle;
	}
	public void setSkillTitle(String skillTitle) {
		this.skillTitle = skillTitle;
	}
	public String getSkillDescription() {
		return skillDescription;
	}
	public void setSkillDescription(String skillDescription) {
		this.skillDescription = skillDescription;
	}
	public List<String> getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(List<String> applicationId) {
		this.applicationId = applicationId;
	}
	@Persistent
	private String skillTitle;
	@Persistent
	private String skillDescription;
	@Persistent
	private List<String> applicationId;
	
}
