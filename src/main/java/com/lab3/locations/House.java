package com.lab3.locations;

import com.lab3.interfaces.AbleToContainCharacters;


public class House extends AbstractInhabitedPlace implements AbleToContainCharacters {
	- houseStands : boolean 
	- houseCleanliness : HouseCleanliness
	- HouseTypes : HouseTypes
	
	- corners : ArrayList<CornerInHouse>
	- things : ArrayList<Thing>
	
	+ House(HouseTypes, houseCleanliness)

	+ getType()
	+ getCleanness()
	+ setOwner(Character)
	+ getOwner() : Character 
	+ settleIn(Character) : void
	+ settleOut(Character) : void
												
	+ fellDown() 
	+ isHouseStands() 

}
