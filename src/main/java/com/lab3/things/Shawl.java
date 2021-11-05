package com.lab3.things;

import com.lab3.enums.Cleanliness;

public class Shawl extends AbstractThing {
    Shawl(String name) 
      { super(name); }  
    
      @Override
      public AbstractThing looksLike() { 
        Towel towel = new Towel("полотенце");
        towel.setCleanliness(Cleanliness.DIRTY);
        return towel;
      }
}
