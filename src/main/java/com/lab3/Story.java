package com.lab3;

import java.util.ArrayList;

import com.lab3.entities.*;
import com.lab3.entities.Character;
import com.lab3.locations.CornerInHouse;
import com.lab3.locations.House;
import com.lab3.locations.NearHouse;
import com.lab3.things.Rope;
import com.lab3.enums.*;

public class Story {
  public static ArrayList<CornerInHouse> create4Corners() {
    ArrayList<CornerInHouse> corners = new ArrayList<CornerInHouse>();      
    for (int i = 0; i < 4; i++) {
      Cleanliness cleanState = Cleanliness.getRandomState();
      corners.add(new CornerInHouse("угол", cleanState));
    }
    return corners;
  }

  public static House prepareHouse() { 
    ArrayList<CornerInHouse> corners = create4Corners();
    corners.get(0).addThing(Thing.Sponge);
		House oldOwlsHouse = new House("Дом Совы", AgeTypes.OLD, Cleanliness.OVERGROWN, corners);

    oldOwlsHouse.addThings(Thing.Chair, Thing.Painting, Thing.Shawl, Thing.Sponge);

    return oldOwlsHouse;
  }

  public static void fillAllCharacters(ArrayList<Character> allArrayList, Character ... c) {
    for (Character e : c) {
      allArrayList.add(e);
    }
  }
  public static void main(String[] args) {
    ArrayList<Character> allCharacters = new ArrayList<Character>();
    
		House oldOwlsHouse = prepareHouse();
		House newOwlsHouse = new House("Дом Совы", AgeTypes.NEW, Cleanliness.CLEAN, create4Corners());

    NearHouse nearHouse = new NearHouse("Возле бывшего дома Совы");

		Thing abstractThing = Thing.AbstractThing;

		Human christopherRobin = new Human("Кристофер Робин");
		IaIa iaIa = new IaIa("Иа-иа");
		Kenga kenga = new Kenga("Кенга");
		Owl owl = new Owl("Сова");
		Pooh pooh = new Pooh("Винни-Пух");
		Rabbit rabbit = new Rabbit("Кролик");
		TinyRu tinyRu = new TinyRu("Крошка Ру");
		Piglet piglet = new Piglet("Пяточок");
    
    fillAllCharacters(allCharacters, christopherRobin, iaIa, kenga, owl, pooh, rabbit, tinyRu, piglet);

    christopherRobin.moveToPlace(nearHouse);
    kenga.moveToPlace(nearHouse);
    owl.moveToPlace(nearHouse);
    rabbit.moveToPlace(nearHouse);
    tinyRu.moveToPlace(nearHouse);

    // описать, кто собрался на поляне
    nearHouse.describe();
    
    // Винни и Пяточoк подошли к бывшему дому Совы
    pooh.doAction("подошёл к бывшему дому Совы");
    pooh.moveToPlace(nearHouse);
    piglet.doAction("подошёл к бывшему дому Совы");
    piglet.moveToPlace(nearHouse);
    
    // на поляне были все, кроме
    System.out.print("На поляне были все, кроме персонажа с именем ");
    for (Character character : allCharacters) {
      if (!nearHouse.containsCharacter(character)) {
        System.out.print(character.getName() + ", ");
      }
    }
    System.out.println();

    String task = "разбирать вещи из дома";

    // Кристофер Робин всем объяснял, что делать, 
    christopherRobin.sayToAll("Всем нужно " + task);

    // и Кролик объяснял всем то же самое, на тот случай, если они не расслышали,
    rabbit.sayToAll("Всем нужно " + task);
    
    System.out.println();
    
    // Они где-то раздобыли канат и вытаскивали стулья и картины, и всякие вещи из прежнего дома Совы, чтобы все было готово для переезда в новый дом. 
    Character someOne = nearHouse.getRandomCharacter();
    while (!someOne.hasHeard()) {
      someOne = nearHouse.getRandomCharacter();
    }
    Rope rope = new Rope("канат");
    someOne.doAction("Раздобыл " + rope.getName());
    
    for (Character c : nearHouse.getCharacters()) {
      if (!c.hasHeard()) continue;
      Thing someThing = c.getRandomFurniture();
      c.pullOut(oldOwlsHouse, nearHouse, someThing);
    }

    System.out.println();
    
    // Кенга связывала узлы и покрикивала на Сову: "Я думаю, тебе не нужна эта старая грязная посудная тряпка. Правда? И половик тоже не годится, он весь дырявый", на что Сова с негодованием отвечала: "Конечно, он годится-- надо только правильно расставить мебель! А это совсем не посудное полотенце, а моя шаль!" 
    Thing owlsShawl = Thing.Shawl;
    kenga.tieKnots();
    kenga.sayToOne(owl, owl.getName() + ", тебе не нужно " + 
              owlsShawl.looksLike().toString() + "? И" + Thing.Doormat.toString() + " не годится.");
    owl.sayToOne(kenga, "Конечно, " + Thing.Doormat.toString() + 
            " годится - надо только правильно расставить мебель!\n" + 
            "\tА это совсем не " + owlsShawl.looksLike().toString() + ", а моя" + owlsShawl.toString());

    System.out.println();
    
    // Крошка Ру поминутно то исчезал в доме, то появлялся оттуда верхом на очередном предмете, который поднимали канатом, что несколько нервировало Кенгу, потому что она не могла за ним как следует присматривать.
    tinyRu.hideInHouse(oldOwlsHouse);

    if (!tinyRu.getPlace().equals(kenga.getPlace())) {
      kenga.getNervous("Не может уследить за Крошкой Ру");
    }

		// tinyRu.appear("верхом на " + abstractThing.getName());
		// abstractThing.liftedWithRope();
    // tinyRu.appear(nearHouse, )from(randomThing)
    // ToolRope.moveUp(randomThing)
    
    
     // Она даже накричала на Сову, заявив, что ее дом-- это просто позор, там такая грязища, удивительно, что он не опрокинулся раньше! 
    // Kenga:say(
    
    

		// Tiny Ru 
		// kenga.shoutAt(owl, oldOwlsHouse.getName() + 
		// 		" - это просто позор, там такая грязища, удивительно, что он не опрокинулся раньше." +
		// 		" Вы только посмотрите, как " + CornerOfHouse.getCornerState() 
		// 		+ "! Там " + Thing.Sponge.looksLike().toString());

		// owl.explain(Thing.Sponge.getName() + " - её и что, если ");
		// if (!Kenga.distinguish(Thing.Sponge, Thing.Fungus)) {
		// 	System.out.println(", то в хорошие времена мы живем!");
		// }
  }
}
