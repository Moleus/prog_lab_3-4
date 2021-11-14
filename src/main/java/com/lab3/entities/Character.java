package com.lab3.entities;

import com.lab3.interfaces.Moveable;
import com.lab3.locations.AbstractInhabitedPlace;
import com.lab3.locations.House;
import com.lab3.locations.Place;
import com.lab3.things.Rope;

import java.util.Objects;
import java.util.Random;

import com.lab3.enums.Thing;
import com.lab3.interfaces.AbleToHear;
import com.lab3.interfaces.AbleToInteractWithThings;

public abstract class Character implements Moveable, AbleToHear, AbleToInteractWithThings {
  protected AbstractInhabitedPlace place;
  protected final String name;
  private boolean heardFlag = false;

  Character(String name) { 
    this.name = name;
  }

  public abstract void doAction(String name) ;
  
  public String getName() { return this.name; }
  public Place getPlace() { return this.place; }

  public void setPlace(AbstractInhabitedPlace place) { this.place = place; }
  
  public boolean hasHeard() { return this.heardFlag; }


	public void pullOut(House house, Place newPlace, Thing ... things) {
		System.out.println("Персонаж " + this.getName() + " вытаскивал предмет " + "\"" + things[0] + "\" " );
		for (Thing thing : things) {
      this.moveThingToPlace(thing, newPlace);
		}
		System.out.println(" из локации " + "\"" + house.toString() +  "\"" + " наружу");
  }
  
  public void sayToAll(String message) {
    System.out.println("Персонаж " + name + " сказал: " + "\"" + message + "\"");
    String charactersHeard = "";
    for (Character c : this.place.getCharacters()) {
      if(c.tryToHear(message)) {
        charactersHeard += c.getName() + ", ";
      }
    }
    System.out.println("Персонажи " + charactersHeard + " услышали: " + message);   
  }

  public void sayToOne(Character character, String message) {
    System.out.println("Персонаж " + name + " сказал персонажу " + character.getName() + ": " + "\"" + message + "\"");
  }
  
  public boolean tryToHear(String message) {
    if (getRandomBoolean()) {
      heardFlag = true;
    }
    return heardFlag;
  }

  protected boolean getRandomBoolean(){
    return Math.random() < 0.5;
  }
  
	public Thing getRandomFurniture() {
		return Thing.values()[new Random().nextInt(4)];
	}
  
	public void moveThingToPlace(Thing thing, Place newPlace) {
    System.out.print("Персонаж " + this.getName() + " взял предмет " + thing.toString() + " и понес на место " + "\"" + newPlace.toString() + "\"");
    this.place.removeThing(thing);
    newPlace.addThing(thing);
  }

	public void pickUpThing(Thing thing) {
    System.out.println("Персонаж " + this.getName() + " поднял " + thing.toString());
    this.place.removeThing(thing);
  }
  
  public void liftupThing(Rope rope, Thing thing) {
    System.out.println("Персонаж " + this.getName() + " поднимает предмет \"" + thing.toString() + "\" с помощью приспособления \"" + rope.toString() + "\"");
    
  }
  
  public void leavePlace() {
    place = null;
  }
  
  public void moveToPlace(AbstractInhabitedPlace newPlace) { 
    this.leavePlace();
    newPlace.addCharacter(this);
    this.setPlace(newPlace);
  }

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null) {
			return false;
		}
		if (!(o instanceof Character))
			return false;
		Character character = (Character) o;
		return Objects.equals(name, character.name) && Objects.equals(place, character.place);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, place);
	}

  @Override
  public String toString() {
      return "Character{" +
              "name='" + name + '\'' +
              ", location=" + place +
              '}';
  }
}
