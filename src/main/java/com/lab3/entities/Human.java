package com.lab3.entities;

import com.lab3.locations.Place;

public class Human extends Character {

  public Human(String name) { 
    super(name);
  }
  
  public void doAction(String action) {
    System.out.println("Персонаж " + name + " " +  action);
  }
}
