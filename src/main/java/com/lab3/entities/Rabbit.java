package com.lab3.entities;

public class Rabbit extends Animal {
  public Rabbit(String name) { super(name); }

  public void doAction(String action) {
    System.out.println("Персонаж " + name + " в припрыжку " +  action);
  }
}

