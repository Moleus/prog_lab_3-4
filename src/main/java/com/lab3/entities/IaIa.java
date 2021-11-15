package com.lab3.entities;

import com.lab3.locations.AbstractInhabitedPlace;

public class IaIa extends Animal {
  public IaIa(String name) { super(name); }

  public void doAction(String action) {
    System.out.println("Персонаж " + name + " " +  action);
  }
}
