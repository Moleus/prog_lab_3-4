package src;
import java.util.ArrayList;


public class Test {
 public static void main(String[] args) {
    Thing chair = Thing.Chair;
    Thing painting = Thing.Painting;
    House house = new House();
    house.addThing(chair);
    System.out.println(house.contains(chair));
    System.out.println(house.contains(painting));
  }
}

class House implements AbleToContainThings {
  protected ArrayList<Thing> things = new ArrayList<Thing>();
  public void addThing(Thing thing) {
    things.add(thing);
  }
  
  public boolean contains(Thing thing) {

    for (Thing e : things) {
      if (e.equals(thing)) {
        return true;
      }
    }
    return false;
  }
}

enum Thing {
	Chair("стулья"),
	Painting("картины"),
	Sponge("губка") ,
	Fungus("поганки"),
	AbstractThing("очередная вещь");

	private String name;

	Thing(String name) { this.name = name; }
	public String getName() { return this.name; }
}

interface AbleToContainThings {
	public boolean contains(Thing thing);
	public void addThing(Thing thing);
	// public ArrayList<Thing> getThings() {}
	// public removeThing(Thing) : void
}
