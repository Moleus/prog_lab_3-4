package com.lab3.things;

abstract public class AbstractThing {
	private String name;

	AbstractThing(String name) { this.name = name; }
	public String getName() { return this.name; }

  public AbstractThing looksLike() {
    return this;
  }
}
