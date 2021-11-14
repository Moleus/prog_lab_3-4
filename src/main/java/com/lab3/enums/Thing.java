package com.lab3.enums;

import java.util.Random;

import com.lab3.interfaces.AbleGetDirty;

public enum Thing implements AbleGetDirty {
	Chair("стул"),
	Painting("картина"),
	Table("стол"),
	AbstractThing("очередная вещь"),
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
      towel.setCleanliness(Cleanliness.DIRTY_NEUTRAL);
      return towel;
    }
  },
  Towel("полотенце"),
	Fungus("поганки"),
	Doormat("дырявый половик"),
  ;

	private String str;
  private Cleanliness cleanliness;

	Thing(String str) { this.str = str; }

  public Thing looksLike() { return this; }

  public String getCleanString() { 
    if (this.cleanliness == null) return "";
    return this.cleanliness.toString() + " ";
  }

  public Cleanliness getCleanliness() { 
    return this.cleanliness ;
  }

  public void setCleanliness(Cleanliness newCleanliness) { 
    this.cleanliness = newCleanliness;
  }

	@Override
	public String toString() {
			return getCleanString() + this.str;
	}

}