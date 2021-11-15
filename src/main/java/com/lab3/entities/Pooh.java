package com.lab3.entities;

public class Pooh extends Animal {
  public Pooh(String name) { 
    super(name);
  }

  public void doAction(String action) {
    System.out.println("Персонаж " + name + " медленно и нерасторопно " +  action);
  }
}