package com.lab3.interfaces;

import com.lab3.enums.Thing;
import com.lab3.locations.Place;

public interface AbleToInteractWithThings {
	public void moveThingToPlace(Thing thing, Place place);
	public void pickUpThing(Thing thing);
}
