package com.lab3.entities;

import com.lab3.locations.AbstractInhabitedPlace;

public class Rabbit extends Character {
  public Rabbit(String name) { 
    super(name);
  }

  public void doAction(String action) {
    System.out.println("Персонаж " + name + " в припрыжку " +  action);
  }
}

