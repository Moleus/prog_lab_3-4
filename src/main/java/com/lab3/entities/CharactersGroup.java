package com.lab3.entities;

import java.util.ArrayList;

import com.lab3.enums.Thing;
import com.lab3.interfaces.AbleToInteractWithThings;
import com.lab3.locations.House;
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
  
  public ArrayList<Character> getCharacters() {
    return characters;
  }

  public String getNames() {
    String charactersStr = "";
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
    
  @Override
	public Thing getRandomFurniture() {
    return strategy.getRandomFurniture();
	}

  @Override
	public void moveThingToPlace(Thing thing, Place oldPlace, Place newPlace) {
    System.out.printf("%s понесли предмет \"%\" из локации \"%s\" на локацию \"%s\"\n", getNames(), thing, oldPlace, newPlace);
    strategy.moveThingToPlace(thing, oldPlace, newPlace); 
  }

  @Override
	public void pickUpThing(Thing thing, Place fromPlace) {
    System.out.printf("%s вытащили предмет \"%\" из локации \"%s\"\n", getNames(), thing, fromPlace);
    strategy.pickUpThing(thing, fromPlace); 
  }

  @Override
	public void pullOut(Thing thing, House house, Place newPlace) {
    System.out.printf("%s вытащили предмет \"%s\" из Дома и понесли его на локацию \"%s\"\n", getNames(), thing, newPlace);
    strategy.pullOut(thing, house, newPlace);
  }
  
  public void sayToAll(String message) {
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
