import java.util.ArrayList;
import java.util.Objects;

import src.Thing;
import src.Thing ..;

interface AbleToHear {
	public void heared();
}

public abstract class Character implements AbleToHear {
	private String name;
	protected Place place;
	
	public String getName() { return this.name; }

	public void doSomething(String toDo) {...}
	public void obtain(Thing Rope) {...}

	public void pullOut(Building house, Thing ... things) {
		System.out.println("Вытаскивали ")
		for (Thing thing : things) {
			System.out.println(thing);
		}
		System.out.println(" из" + house.getFrom())

	public void laugh() {}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null) {
			return false;
		}
		if (!(o instanceof Character))
			return false;
		Character character = (Character) o;
		return Objects.equals(name, character.name) && Objects.equals(place, character.place);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, place);
	}

  @Override
  public String toString() {
      return "Character{" +
              "name='" + name + '\'' +
              ", location=" + place +
              '}';
  }
}

class Place {
	protected String name;
	protected ArrayList<Character> characters;
	public void Place(String name) {}
	public String getName() {}

	public void describe(){}
	public void addCharacters(Character ... characters) {}
	public ArrayList<Character> getCharacters() {}
	public boolean contains(Character character) {}
	public void removeCharacter(Character character) {}

	public boolean equals(Object o) {}
	public int hashCode() {}
	public String toString() {}
}

class HouseBuilding {
	- houseStands : boolean 
		- isNew : boolean 

		+ setOwner(Character)
		+ getOwner() : Character 

					   + fellDown() 
						   + isHouseStands() 
}



public enum Thing {
	Rope("канат"),
	Chair("стулья"),
	Painting("картины"),
	Sponge("губка") ,
	Fungus("поганки"),
	AbstractThing("очередная вещь") {
	};

	private String name;
	Thing(String name) { this.name = name; }

	public String getName() { return this.name; }

	public void liftedWithRope() {
		System.out.println(this.name + " поднимается канатом");
	}

	public void readyForAction(String action) {
		System.out.println("Вещи готовы к " + action); // переезд в NewOwlsHouse
	}
}

public class House {
	private boolean houseStands = true;
	private boolean isNew = true;

	public void fellDown() {
		this.houseStands = false;
		this.isNew = false;
	}

	public boolean isHouseStands() {
		return houseStands;
	}
}

public class CornerOfHouse {
	private static String state = "зарос";
	public static void getCornerState() {
		System.out.println("угол " + state);
	}
}

public class Kenga extends Character {
	public void tieKnots() {
		System.out.println(this.getName() + " Связывала узлы");
	}

	public void getNervous(String reason) {
		System.out.println(this.getName() + " нервничала, потому что " + reason);
	}
	public void shoutAt(Character character, String message) {
		System.out.println(this.getName() + " покрикивала на" + character.getName() + ": "
				+ message);
	}

	public boolean distinguish(Thing thing1, Thing thing2) {
		if (thing1.getName() == "губка" && thing2.getName() == "поганка") {
			System.out.print(this.getName() + " не может отличить " + thing1.getName() + " от " + thing2.getName());
			return false;
		}
		return true;
	}
}

public class Owl extends Character{
	void responseWithIndignation(String respone) {
		System.out.println(this.getName() + " c негодованием отвечала: " + respone);
	}
	void beSurprised() {
		System.out.println(this.getName() + " удивилась.");
	}
	void look() {
		System.out.println(this.getName() + " посмотрела.");
	}
	void laughWithSarcasm() {
		System.out.println(this.getName() + " саркастически засмеялась.");
	}
	void explain(String message) {
		System.out.print(this.getName() + "объяснила, что " + message);
	}
}

public class main() { 
	public static void main(String[] args) {

		TinyRu tinyRu = new TinyRu("Крошка Ру");

		ChristopherRobin christopherRobin = new ChristopherRobin("Кристофер Робин");
		Pooh pooh = new Pooh("Винни-Пух");
		Eeyore eeyore = new Eeyore("Иа-иа");
		Kenga kenga = new Kenga("Кенга");
		Owl owl = new Owl("Сова");
		Rabbit rabbit = new Rabbit("Кролик");

		House oldOwlsHouse = new House("Дом Совы");
		House newOwlsHouse = new House("Новый Дом Совы");
		Thing abstractThing = Thing.AbstractThing;
		// Tiny Ru 
		tinyRu.hideInHouse();
		tinyRu.appear("верхом на " + abstractThing.getName());
		abstractThing.liftedWithRope();
		kenga.getNervous("она не могла присматривать ним за");
		kenga.shoutAt(owl, oldOwlsHouse.getName() + 
				" - это просто позор, там такая грязища, удивительно, что он не опрокинулся раньше." +
				" Вы только посмотрите, как " + CornerOfHouse.getCornerState() 
				+ "! Там " + Thing.Fungus.getName());

		owl.explain(Thing.Sponge.getName() + " - её и что, если ");
		if (!Kenga.distinguish(Thing.Sponge, Thing.Fungus)) {
			System.out.println(", то в хорошие времена мы живем!");
		}
	}
}

public class ChristoferRobin extends Character{
}

public class Rabbit extends Character{
}

public class IaIa extends Character {

}

public class TinyRu extends Character {
	public void hideInHouse() {
		System.out.println(this.getName() + " исчезал в Доме");
	}
	public void appear(String action) {
		System.out.println(this.getName() + " появлялся " + action);
	}
}

public class Bear extends Character {
	подойти к "дом Совы"
}

public class Piglet extends Character {{
	подойти к "дом Совы"
}

NewHouse

Feelings:
негодование
нервированность
удивилась
