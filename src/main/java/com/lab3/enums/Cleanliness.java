package com.lab3.enums;

public enum Cleanliness {
	SPOTLESS("без единой пылинки"),
	CLEAN("чистый"),
	DIRTY("грязный"),
	DUSTY("пыльный"),
	OVERGROWN("заросший"),
	FILTHY("утонувший в грязи");

  private String name;
  Cleanliness(String name) { this.name = name; }
}