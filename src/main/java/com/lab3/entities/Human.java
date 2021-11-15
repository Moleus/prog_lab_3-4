package com.lab3.entities;

public class Human extends Character {

  public Human(String name) { super(name); }
  
  public void doAction(String action) {
    System.out.println("Персонаж " + name + " " +  action);
  }
}
