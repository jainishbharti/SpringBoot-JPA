package com.mywebapp.model;

import javax.persistence.*;

@Entity(name="alien")
public class Alien {
	@Id
	private Integer alienId;
	private String alienName;
	private String technology;
	
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	public Integer getAlienId() {
		return alienId;
	}
	public void setAlienId(Integer alienId) {
		this.alienId = alienId;
	}
	public String getAlienName() {
		return alienName;
	}
	public void setAlienName(String alienName) {
		this.alienName = alienName;
	}
	@Override
	public String toString() {
		return "Alien [alienId=" + alienId + ", alienName=" + alienName + ", technology=" + technology + "]";
	}
	
	
	

}
