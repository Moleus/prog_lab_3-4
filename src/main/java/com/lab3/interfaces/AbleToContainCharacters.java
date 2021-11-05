package com.lab3.interfaces;

import java.util.ArrayList;

public interface AbleToContainCharacters { 
	public boolean containsCharacter(Character character); 
	public void addCharacter(Character character); 
	public ArrayList<Character> getCharacters(); 
	public void removeCharacter(Character character); 
}

