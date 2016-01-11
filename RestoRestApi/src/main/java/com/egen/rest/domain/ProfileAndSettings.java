package com.egen.rest.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProfileAndSettings {
	@Id
	private Integer restId;
	private String restName;
	private String tagLine;
	private String addrLine1;
	private String addrLine2;
	private String city;
	private String state;
	private String zipCode;
	private String phone;
	private String email;
	private boolean autoAssign;
	private String openCloseDetails;
	
	public Integer getRestId() {
		return restId;
	}
	public void setRestId(Integer restId) {
		this.restId = restId;
	}
	public String getRestName() {
		return restName;
	}
	public void setRestName(String restName) {
		this.restName = restName;
	}
	public String getTagLine() {
		return tagLine;
	}
	public void setTagLine(String tagLine) {
		this.tagLine = tagLine;
	}
	public String getAddrLine1() {
		return addrLine1;
	}
	public void setAddrLine1(String addrLine1) {
		this.addrLine1 = addrLine1;
	}
	public String getAddrLine2() {
		return addrLine2;
	}
	public void setAddrLine2(String addrLine2) {
		this.addrLine2 = addrLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isAutoAssign() {
		return autoAssign;
	}
	public void setAutoAssign(boolean autoAssign) {
		this.autoAssign = autoAssign;
	}
	public String getOpenCloseDetails() {
		return openCloseDetails;
	}
	public void setOpenCloseDetails(String openCloseDetails) {
		this.openCloseDetails = openCloseDetails;
	}
	public ProfileAndSettings(){
		
	}
	public ProfileAndSettings(Integer restId, String restName, String tagLine, String addrLine1, String addrLine2,
			String city, String state, String zipCode, String phone, String email, boolean autoAssign,
			String openCloseDetails) {
		super();
		this.restId = restId;
		this.restName = restName;
		this.tagLine = tagLine;
		this.addrLine1 = addrLine1;
		this.addrLine2 = addrLine2;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.phone = phone;
		this.email = email;
		this.autoAssign = autoAssign;
		this.openCloseDetails = openCloseDetails;
	}
	
	
}
