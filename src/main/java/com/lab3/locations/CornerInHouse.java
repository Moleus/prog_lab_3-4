package com.lab3.locations;

import java.util.ArrayList;

import com.lab3.enums.Cleanliness;
import com.lab3.enums.Thing;
import com.lab3.interfaces.AbleGetDirty;

public class CornerInHouse extends Place implements AbleGetDirty {
  private Cleanliness cleanlinessState;
  
  private ArrayList<Thing> things;

  public CornerInHouse(String name, Cleanliness cleanliness) { 
    super(name);
    this.cleanlinessState = cleanliness;
  }
  
  public Cleanliness getCleanliness() { return cleanlinessState; }
  public void setCleanliness(Cleanliness cleanliness) { this.cleanlinessState = cleanliness; }

}
