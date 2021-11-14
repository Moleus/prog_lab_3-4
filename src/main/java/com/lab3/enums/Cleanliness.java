package com.lab3.enums;

import java.util.Random;

public enum Cleanliness {
	DIRTY("грязный"),
	OVERGROWN("заросший"),
	FILTHY("утонувший в грязи"),
	DIRTY_NEUTRAL("грязное"),
	DUSTY_NEUTRAL("пыльное"),
	SPOTLESS("без единой пылинки"),
	CLEAN("чистый");

  private String name;

  Cleanliness(String name) { this.name = name; }
	
	public static Cleanliness getRandomState() {
		return Cleanliness.values()[new Random().nextInt(Cleanliness.values().length - 3)];
	}

	@Override
	public String toString() {
			return name;
	}
}