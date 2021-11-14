package com.lab3.locations;

import java.util.ArrayList;

import com.lab3.enums.Cleanliness;
import com.lab3.enums.Thing;

public class CornerInHouse extends Place {
  private Cleanliness cleanlinessState;
  
  private ArrayList<Thing> things;

  public CornerInHouse(String name, Cleanliness cleanliness) { 
    super(name);
    this.cleanlinessState = cleanliness;
  }
  
  public Cleanliness getCleanliness() { return cleanlinessState; }
  public void setCleanliness(Cleanliness cleanliness) { this.cleanlinessState = cleanliness; }

}
