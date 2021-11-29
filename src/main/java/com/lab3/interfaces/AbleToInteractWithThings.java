package com.lab3.interfaces;

import com.lab3.enums.Thing;
import com.lab3.locations.House;
import com.lab3.locations.Place;

public interface AbleToInteractWithThings {
	public void moveThingToPlace(Thing thing, Place oldPlace, Place newPlace);
	public void pickUpThing(Thing thing, Place fromPlace);
	public void pullOut(Thing thing, House house, Place newPlace);
	public Thing getRandomFurniture();
}
