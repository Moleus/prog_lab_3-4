package com.lab3.entities;

import java.util.ArrayList;

import com.lab3.enums.Thing;
import com.lab3.interfaces.AbleToInteractWithThings;
import com.lab3.locations.Place;
import com.lab3.strategies.InteractionStrategy;


public class CharactersGroup implements AbleToInteractWithThings {
  protected ArrayList<Character> characters = new ArrayList<Character>();
  private InteractionStrategy strategy;
  
  public CharactersGroup(InteractionStrategy strategy, Character ... new_characters) {
    for (Character c : new_characters) {
      characters.add(c);
    }
    this.strategy = strategy;
  }

  protected String getNames() {
    String charactersStr = " ";
    for (int i = 0; i < characters.size(); i++) {
      charactersStr += characters.get(i);
      if (i == characters.size() - 1) { break; }
      if (i == characters.size() - 2) { 
        charactersStr += " и ";
        continue;
       }
      charactersStr += ", ";
    }
    return charactersStr;
  }

	public void moveThingToPlace(Thing thing, Place oldPlace, Place newPlace) {
    strategy.moveThingToPlace(thing, oldPlace, newPlace); 
  }

  @Override
	public void pickUpThing( Thing thing, Place fromPlace) {
    strategy.pickUpThing(thing, fromPlace); 
  }
  
public void sayToAll( String message) {
    // TODO Exception: share same location 
    if (!isInSameLocation()) {
      // throw "Characters in group should share same location";
    }
    System.out.printf("%s сказали всем: %s\n", getNames(), message);   
    String heardCharacters = strategy.sayToAll(characters.get(0).getPlace(), message);
    System.out.println("Персонажи " + heardCharacters + " услышали: " + message);   
  }
  
  public boolean isInSameLocation() {
    for (Character c : characters) {
      if (!c.getPlace().equals(characters.get(0).getPlace())) {
        return false;
      }
    }
    return true;
  }
  
}
