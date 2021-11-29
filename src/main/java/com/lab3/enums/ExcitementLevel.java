package com.lab3.enums;

import com.lab3.exceptions.ExcitementOutOfRangeError;

public enum ExcitementLevel {
  NORMAL {
    public ExcitementLevel decrease(){  
      throw new ExcitementOutOfRangeError();
    }
  },
  MEDIUM,
  HIGH {
    public ExcitementLevel increase(){  
      throw new ExcitementOutOfRangeError();
    }
  };
  
  static final ExcitementLevel[] VALUES = values();
  public ExcitementLevel increase() { return VALUES[ordinal()+1]; }
  public ExcitementLevel decrease() { return VALUES[ordinal()-1]; }
}
