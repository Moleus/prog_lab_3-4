package com.lab3.locations;

import java.util.ArrayList;
import java.util.Random;

import com.lab3.interfaces.AbleToContainCharacters;

import com.lab3.entities.Character;

public abstract class AbstractInhabitedPlace extends Place implements AbleToContainCharacters {
	protected ArrayList<Character> characters;
	protected AbstractInhabitedPlace(String name) { 
		super(name);
		characters = new ArrayList<Character>();
	}
	
	// Описать сцену
	public void describe() {
		if (characters.isEmpty()) {
			System.out.println("На местности \"" + name + "\" никого нет.");
			return;
		}

		String output = "На местности \"" + name + "\" собрались";
		ArrayList<Character> characters = getCharacters();
		for (Character e : characters) {
			output += " \"" + e.getName() + "\"";
		}
		System.out.println(output);
	}

	public boolean containsCharacter(Character character) {
		for (Character e : characters) {
			if (e.equals(character)) {
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
		for (Character e : characters) {
			if (e.equals(character)) {
				characters.remove(e);
				return;
			}
		}
	}
	
	public Character getRandomCharacter() { 
		return characters.get(new Random().nextInt(characters.size()));
	}
	
	public void echoPhraseInPlace(String message) { 
		for (Character c : characters) {
			c.tryToHear(message);
		}
	}

}
