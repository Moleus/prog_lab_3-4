package com.lab3.enums;

import java.util.Random;

public enum Cleanliness {
	SPOTLESS("без единой пылинки"),
	CLEAN("чистый"),
	DIRTY("грязное"),
	DUSTY("пыльный"),
	OVERGROWN("заросший"),
	FILTHY("утонувший в грязи");

  private String name;

  Cleanliness(String name) { this.name = name; }
	
	public static Cleanliness getRandomState() {
		return Cleanliness.values()[new Random().nextInt(Cleanliness.values().length)];
	}

	@Override
	public String toString() {
			return name;
	}
}