package com.lab3.locations;

import java.util.ArrayList;

import com.lab3.interfaces.AbleToContainCharacters;

public class AbstractInhabitedPlace extends AbstractPlace implements AbleToContainCharacters {
	private ArrayList<Character> characters;

	public boolean containsCharacter(Character character) {
		for(Character e : characters){
			if(e.equals(character)){
				return true;
			}
		}
		return false;
	}

	public void addCharacter(Character character) {
		characters.add(character);
	}

	public ArrayList<Character> getCharacters() {
		return characters;
	}

	public void removeCharacter(Character character) {
		for(Character e : characters){
			if(e.equals(character)){
				characters.remove(e);
				return;
			}
		}
	}
  
  
}
