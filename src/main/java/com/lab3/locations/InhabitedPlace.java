package com.lab3.locations;

import java.util.ArrayList;
import java.util.Random;

import com.lab3.interfaces.AbleToContainCharacters;

import com.lab3.entities.Character;
import com.lab3.entities.CharactersGroup;

public class InhabitedPlace extends Place implements AbleToContainCharacters {
	protected ArrayList<Character> characters;
	public InhabitedPlace(String name) { 
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
			if (e.getPlace() != null) {
				InhabitedPlace prev_place = e.getPlace();
				prev_place.removeCharacter(e);
			}
			characters.add(e);
			e.setPlace(this);
		}
	}
	
	public void moveWithMessage(Character character, String message) {
		System.out.printf("%s %s\n", character, message);
		if (character.getPlace() != null) {
			InhabitedPlace prev_place = character.getPlace();
			prev_place.removeCharacter(character);
		}
		this.addCharacters(character);
	}

	public void moveWithMessage(CharactersGroup group, String message) { 
		System.out.printf("%s %s %s\n", group.getNames(), message, this.name);
		for (Character character : group.getCharacters()) {
			InhabitedPlace prev_place = character.getPlace();
			if (prev_place == null) { continue; }
			prev_place.removeCharacter(character);
			this.addCharacters(character);
		}
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
