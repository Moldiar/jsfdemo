package com.example.jsfdemo.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Epoch {

	private String name="Epoch of ";
	private String description="";
	private int startDate;
	private int endDate;
	private String turningPoint="";

	@Size(min=11,max=50)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Size(min=20)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Min(0)
	public int getStartDate() {
		return startDate;
	}

	public void setStartDate(int startDate) {
		this.startDate = startDate;
	}

	public int getEndDate() {
		return endDate;
	}

	public void setEndDate(int endDate) {
		this.endDate = endDate;
	}

	@Size(min=20)
	public String getTurningPoint() {
		return turningPoint;
	}

	public void setTurningPoint(String turningPoint) {
		this.turningPoint = turningPoint;
	}
}
