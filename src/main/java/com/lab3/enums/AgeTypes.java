package com.lab3.enums;


public enum AgeTypes {
	ANCIENT("старинный"),
	AGED("поношенный временем"),
	OLD("старый"),
	NEW("новый");
  
  private String ageType;
  AgeTypes(String ageType) { this.ageType = ageType; }
  
  public String getAgeType() { return ageType; }
}