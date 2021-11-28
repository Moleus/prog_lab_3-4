package com.lab3.locations;

import java.util.ArrayList;
import java.util.Random;

import com.lab3.interfaces.AbleToContainCharacters;

import com.lab3.entities.Character;

public class InhabitedPlace extends Place implements AbleToContainCharacters {
	protected ArrayList<Character> characters;
	protected InhabitedPlace(String name) { 
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

	public void addCharacters(Character ... new_characters) {
		for (Character e : new_characters) {
			characters.add(e);
			e.setPlace(this);
		}
	}
	
	public void acceptCharater(Character character, String message) {
		System.out.printf("%s %s\n", character, message);
		if (character.getPlace() == null) {
			return;
		}
		InhabitedPlace prev_place = character.getPlace();
		prev_place.removeCharacter(character);
		this.addCharacters(character);
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
}
