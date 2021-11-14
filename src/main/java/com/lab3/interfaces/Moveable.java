package com.lab3.interfaces;

import com.lab3.locations.AbstractInhabitedPlace;

public interface Moveable { 
	public void moveToPlace(AbstractInhabitedPlace place);
	public void leavePlace();
}
