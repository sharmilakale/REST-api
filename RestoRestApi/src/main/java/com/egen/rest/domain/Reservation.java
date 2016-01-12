package com.egen.rest.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Reservation {

	@Id
	private Integer id;

	private String reserveDate;
	private String reserveTime;

	private Integer noOfPeople;
	private String status;
	private Integer tableNo;
	private String customerName;
	private String customerPhone;
	private String customerEmail;

	public String getReserveDate() {
		return reserveDate;
	}

	public void setReserveDate(String reserveDate) {
		this.reserveDate = reserveDate;
	}

	public String getReserveTime() {
		return reserveTime;
	}

	public void setReserveTime(String reserveTime) {
		this.reserveTime = reserveTime;
	}

	public Integer getNoOfPeople() {
		return noOfPeople;
	}

	public void setNoOfPeople(Integer noOfPeople) {
		this.noOfPeople = noOfPeople;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getTableNo() {
		return tableNo;
	}

	public void setTableNo(Integer tableNo) {
		this.tableNo = tableNo;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Reservation() {

	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}


	public Reservation(Integer id, String reserveDate, String reserveTime, Integer noOfPeople, String status, Integer tableNo,
			String customerName, String customerPhone, String customerEmail) {
		super();
		this.id = id;
		this.reserveDate = reserveDate;
		this.reserveTime = reserveTime;
		this.noOfPeople = noOfPeople;
		this.status = status;
		this.tableNo = tableNo;
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.customerEmail = customerEmail;
	}

	

}
