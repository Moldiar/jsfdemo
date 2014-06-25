package com.example.jsfdemo.domain;

import javax.validation.constraints.Size;

public class Bloodline {

	private String name;
	private String power;
	private String hematexGene;
	
	@Size(min=4)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}
	@Size(min=3)
	public String getHematexGene() {
		return hematexGene;
	}
	
	public void setHematexGene(String hematexGene) {
		this.hematexGene = hematexGene;
	}
}
