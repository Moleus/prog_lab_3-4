package com.lab3.strategies;

import com.lab3.enums.Thing;
import com.lab3.locations.InhabitedPlace;
import com.lab3.locations.Place;

public interface InteractionStrategy {
	public void moveThingToPlace(Thing thing, Place oldPlace, Place place);
	public void pickUpThing(Thing thing, Place place);
  public String sayToAll(InhabitedPlace location, String message);
}