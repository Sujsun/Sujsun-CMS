package com.sujsun.cms.jdo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.jdo.annotations.*;

@PersistenceCapable
public class Contact implements Serializable {
	
	@PrimaryKey
    @Persistent( valueStrategy = IdGeneratorStrategy.IDENTITY )
    private String id;
	
	@Persistent
	private Date createdDate;
	@Persistent
	private Date lastUpdateDate;
	
	@Persistent
	private String login;
	@Persistent
	private String firstName;
	@Persistent
	private String middleName;
	@Persistent
	private String lastName;
	@Persistent
	private String password;
	@Persistent
    private String pictureUrl;
	
	@Persistent( defaultFetchGroup = "true" )
	private List<Address> addressList;
	
	@Persistent
	private List<String> phoneNumberList;
	@Persistent( defaultFetchGroup = "true" )
	private List<Account> accountList;
	@Persistent( defaultFetchGroup = "true" )
	private List<Skill> skillList;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPictureUrl() {
		return pictureUrl;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	public List<Address> getAddressList() {
		return addressList;
	}
	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}
	public List<String> getPhoneNumberList() {
		return phoneNumberList;
	}
	public void setPhoneNumberList(List<String> phoneNumberList) {
		this.phoneNumberList = phoneNumberList;
	}
	public List<Account> getAccountList() {
		return accountList;
	}
	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}
	public List<Skill> getSkillList() {
		return skillList;
	}
	public void setSkillList(List<Skill> skillList) {
		this.skillList = skillList;
	}
	public Contact(String id, Date createdDate, Date lastUpdateDate,
			String login, String firstName, String middleName, String lastName,
			String pictureUrl, List<Address> addressList,
			List<String> phoneNumberList, List<Account> accountList,
			List<Skill> skillList) {
		super();
		this.id = id;
		this.createdDate = createdDate;
		this.lastUpdateDate = lastUpdateDate;
		this.login = login;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.pictureUrl = pictureUrl;
		this.addressList = addressList;
		this.phoneNumberList = phoneNumberList;
		this.accountList = accountList;
		this.skillList = skillList;
	}
}
