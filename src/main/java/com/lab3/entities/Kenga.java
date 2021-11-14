package com.lab3.entities;

import com.lab3.enums.Thing;
import com.lab3.locations.AbstractInhabitedPlace;

public class Kenga extends Animal {
	private boolean nervousFlag = false;
  public Kenga(String name) { 
    super(name);
  }

  public void doAction(String action) {
    System.out.println("Персонаж " + name + " " +  action);
  }
	public void tieKnots() {
		System.out.println(this.getName() + " связывает узлы");
	}

	public void getNervous(String reason) {
		nervousFlag = true;
		System.out.println(this.getName() + " нервничала, потому что " + reason);
	}
	
	public boolean isNervous() {return this.nervousFlag; }

	public void shoutAt(Character character, String message) {
		System.out.println(this.getName() + " покрикивала на" + character.getName() + ": "
				+ message);
	}

	public boolean distinguish(Thing thing1, Thing thing2) {
		if ("губка".equals(thing1.toString()) &&  "поганки".equals(thing2.toString())) {
			System.out.print(this.getName() + " не может отличить предмет " + thing1.toString() + " от " + thing2.toString());
			return false;
		}
		return true;
	}
}
