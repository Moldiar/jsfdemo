package com.example.jsfdemo.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Hero {

	private String name = "";
	private String lastName = "";
	private String bloodline = "";
	private String birthSign;
	private int alignment;
	private String epochOfBirth;
	private String magicSchematicCode="";
	
	@Size(min=2, max=34)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Size(min=2, max=34)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Size(min=4)
	public String getBloodline() {
		return bloodline;
	}

	public void setBloodline(String bloodline) {
		this.bloodline = bloodline;
	}

	public String getBirthSign() {
		return birthSign;
	}

	public void setBirthSign(String birthSign) {
		this.birthSign = birthSign;
	}

	@Min(-1)
	@Max(1)
	public int getAlignment() {
		return alignment;
	}

	public void setAlignment(int alignment) {
		this.alignment = alignment;
	}

	public String getEpochOfBirth() {
		return epochOfBirth;
	}

	public void setEpochOfBirth(String epochOfBirth) {
		this.epochOfBirth = epochOfBirth;
	}
	
	@Size(min=6)
	public String getMagicSchematicCode() {
		return magicSchematicCode;
	}

	public void setMagicSchematicCode(String magicSchematicCode) {
		this.magicSchematicCode = magicSchematicCode;
	}
}
