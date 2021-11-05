package com.lab3.things;

import com.lab3.enums.Cleanliness;
import com.lab3.interfaces.AbleGetDirty;

public class Towel extends AbstractThing implements AbleGetDirty {
  private Cleanliness cleanliness;
  
  Towel(String name) { 
    super(name);
  }
  
  public String getCleanliness() { 
    return cleanliness.name();
  }

  public void setCleanliness(Cleanliness newCleanliness) { 
    this.cleanliness = newCleanliness;
  }
  
}
