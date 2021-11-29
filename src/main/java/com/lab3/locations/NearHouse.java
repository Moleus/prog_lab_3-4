package com.lab3.locations;

import com.lab3.entities.Character;

public class NearHouse extends InhabitedPlace {
  public NearHouse(String name) {
    super(name);
  }
  
  @Override
  public void removeCharacter(Character character) {
    // System.out.printf("%s покинул место %s\n", character, name);
    super.removeCharacter(character);
  }
}
