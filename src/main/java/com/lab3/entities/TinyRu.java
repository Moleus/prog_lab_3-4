package com.lab3.entities;

import com.lab3.locations.AbstractInhabitedPlace;
import com.lab3.locations.House;

public class TinyRu extends Animal {
  public TinyRu(String name) { 
    super(name);
  }

  public void doAction(String action) {
    System.out.println("Персонаж " + name + " " +  action);
  }
	public void hideInHouse(House house) {
		System.out.println(this.getName() + " исчез в Доме");
    this.moveToPlace(house);
	}
	public void appear(AbstractInhabitedPlace place, String action) {
		System.out.println(this.getName() + " появлялся " + action);
    this.moveToPlace(place);
	}
}
