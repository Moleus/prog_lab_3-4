package com.lab3.entities;

import com.lab3.locations.AbstractInhabitedPlace;

public class Owl extends Character{
  public Owl(String name) { 
    super(name);
  }
  
  public void doAction(String action) {
    System.out.println("Персонаж " + name + " " +  action);
  }

	void responseWithIndignation(String respone) {
		System.out.println(this.getName() + " c негодованием отвечала: " + respone);
	}
	void beSurprised() {
		System.out.println(this.getName() + " удивилась.");
	}
	void look() {
		System.out.println(this.getName() + " посмотрела.");
	}
	void laughWithSarcasm() {
		System.out.println(this.getName() + " саркастически засмеялась.");
	}
	void explain(String message) {
		System.out.print(this.getName() + "объяснила, что " + message);
	}
}
