package com.lab3.entities;

import com.lab3.enums.Thing;
import com.lab3.locations.House;
import com.lab3.locations.Place;
import com.lab3.strategies.InteractionStrategy;

public class Pooh extends Character {
	private String actionCharacteristic = "думая о мёде";
  
  public Pooh(String name, InteractionStrategy strategy) {
    super(name, strategy);
  }

  @Override
  public void doAction(String action) {
    System.out.printf("%s %s %s", name, actionCharacteristic, action);
  }

  @Override
public void sayToAll( String message) {
    System.out.printf("%s сказал всем: \"%s\"\n", name, message);
    super.sayToAll(message);
  }
  
  @Override
  public void sayToOne(Character character, String message) {
    System.out.printf("%s сказал персонажу %s: \"%s\"\n", name, character, message);
    super.sayToOne(character, message);
  }
  
  @Override
  public void pullOut(House house, Place newPlace, Thing thing) {
    System.out.printf("%s %s вытаскивает предмет \"%s\" из Дома.\n", name, actionCharacteristic, house);
    super.pullOut(house, newPlace, thing);
  }
}