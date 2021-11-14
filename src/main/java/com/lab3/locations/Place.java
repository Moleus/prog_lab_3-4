package com.lab3.locations;

import java.util.ArrayList;

import com.lab3.enums.Thing;
import com.lab3.interfaces.AbleToContainThings;

public abstract class Place implements AbleToContainThings {
	private ArrayList<Thing> things;
	protected String name;

	protected Place(String name) { 
		this.name = name; 
		things = new ArrayList<Thing>();
	}

	public boolean containsThing(Thing thing) {
		for(Thing e : things){
			if(e.equals(thing)){
				return true;
			}
		}
		return false;
	}

	public void addThing(Thing thing) {
		things.add(thing);
	}

	public void addThings(Thing ... thingsToAdd) {
		for (Thing t: thingsToAdd){
			things.add(t);
		}
	}

	public ArrayList<Thing> getThings() {
		return things;
	}

	public void removeThing(Thing thing) {
		for(Thing e : things){
			if(e.equals(thing)){
				things.remove(e);
				return;
			}
		}
	}
	
	@Override
  public String toString() {
      return name;
	}  
}
