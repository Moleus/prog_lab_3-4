package com.lab3.strategies;

import com.lab3.enums.Thing;
import com.lab3.locations.InhabitedPlace;
import com.lab3.locations.Place;
import com.lab3.entities.Character;

public class InteractWithOthers implements InteractionStrategy {
  @Override 
  public void moveThingToPlace(Thing thing, Place oldPlace, Place newPlace) {
    oldPlace.removeThing(thing);
    newPlace.addThing(thing);
  }

  @Override
  public void pickUpThing(Thing thing, Place fromPlace) {
    fromPlace.removeThing(thing);
  }

  @Override
  public String sayToAll(InhabitedPlace location, String message) {
    String heardCharacters = "";
    for (Character c : location.getCharacters()) {
      if(tryToHear(message)) {
        c.setHeard(true);
        heardCharacters += c.getName() + " ";
      }
    }
    return heardCharacters;
  }
    
  private boolean tryToHear(String message) {
    if (getRandomBoolean()) {
      return true;
    }
    return false;
  }

  private boolean getRandomBoolean(){
    return Math.random() < 0.5;
  }
}
