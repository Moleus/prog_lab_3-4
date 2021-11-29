package com.lab3.exceptions;

public class ExcitementOutOfRangeError extends Error {
  public String getMessage() {
      return(" ExcitementLevel вышел за границы ");
  }
}
