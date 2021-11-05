package com.lab3.enums;

import com.lab3.interfaces.AbleGetDirty;

public enum Thing implements AbleGetDirty {
	Chair("стулья"),
	Painting("картины"),
	Sponge("губка") {
    @Override
    public Thing looksLike() { 
      return Thing.Fungus;
    }
  },
  Shawl("шаль") {
    @Override
    public Thing looksLike() { 
      Thing towel = Thing.Towel;
      towel.setCleanliness(Cleanliness.DIRTY);
      return towel;
    }
  },
  Towel("полотенце"),
	Fungus("поганки"),
	AbstractThing("очередная вещь") {
	};

	private String name;
  private Cleanliness cleanliness;

	Thing(String name) { this.name = name; }
	public String getName() { return this.name; }

  public Thing looksLike() {
    return this;
  }

  public String getCleanliness() { 
    return cleanliness.name();
  }

  public void setCleanliness(Cleanliness newCleanliness) { 
    this.cleanliness = newCleanliness;
  }

}
