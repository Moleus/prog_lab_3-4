package com.lab3.interfaces;

import com.lab3.locations.InhabitedPlace;

public interface Moveable { 
	public void moveToPlace(InhabitedPlace place);
	public void leavePlace();
}
