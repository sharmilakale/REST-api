package com.egen.rest.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TableDetails {
	@Id
	private Integer id;
	private Integer capacity;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCapacity() {
		return capacity;
	}
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}
	public TableDetails(){
		
	}
	public TableDetails(Integer id, Integer capacity) {
		super();
		this.id = id;
		this.capacity = capacity;
	}
	
	
}
