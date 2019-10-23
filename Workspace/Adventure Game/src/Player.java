import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class holds a bunch of the information about the character
 * @author Dr. Cheese
 */
public class Player {
	public int x; // holds the x value the character is at
	public int y; // holds the y value the character is at

	private Scanner reader = new Scanner(System.in); //lets the player set a new race if the old one doesn't work

	public int str; // holds the base damage the character would do, without any modifiers
	private int strmod = 0; // holds all of the bonuses to damage that the character has from their equipment
	public int dmg; // holds the total amount of damage the character will do

	public int def; // holds the base damage reduction the character would apply
	private int defmod = 0; // holds all of the bonuses to damage reduction the the character has from their equipment
	public int dmgred; // holds the total amount of protection the character has from damage

	public int spd; // holds how many spaces the character can move in a turn
	public int HP; // holds how much damage the character can take before dying
	public String name; // holds the name of the character

	String[] races = {"human", "orc", "goblin"}; // holds all of the legal races
	String race; // holds what race the character is

	public Item[] inventory = {new Item("Shortsword", 0)}; // the inventory[] array holds the character's inventory and is initialized with a Regular Shortsword
	public Item weapon; // Holds what the character has currently equipped as their weapon
	public Item gear; // holds what item the character has set for its gear, if any

	boolean firstWeapon = true; // used on initialization to set the first weapon of the character
	public boolean gearset; // tells if the character has set a gear item or not

	/**
	 * This constructor sets up the player with a character at some x and y decided by the author and a race set by the player.
	 * @param race String
	 */
	Player(String race) {
		x = 30; // sets the beginning x
		y = 1; // sets the beginning y

		legalRaceCheck(race); // checks if the race the player wants to be is defined
		raceSet(); // once the race is considered legal, the constructor sets up the base stats

		equip(inventory[0]); // equips the starting weapon
	}

	/**
	 * This constructor sets up the player at an x and y position without initializing their inventory.
	 */
	Player() {
		x = 30; // sets the beginning x
		y = 1; // sets the beginning y
	}

	/**
	 * This method lets the character add an item to their inventory.
	 * @param a Item object
	 */
	public void get(Item a) {
		ArrayList<Item> b = new ArrayList<Item>(); // makes an ArrayList
		for (int i = 0; i < inventory.length; i++) {
			b.add(inventory[i]); // adds the entire inventory to the created ArrayList
		}
		b.add(a); // adds the new item to the ArrayList
		inventory = new Item[b.size()]; // redefines the inventory[] array based on the size of the ArrayList
		b.toArray(inventory); // puts all of the values of the ArrayList into the new inventory[] array
	}

	/**
	 * This method sets the character's equipped weapon using a passed item object.
	 * @param weapon Item object
	 */
	public void setWeapon(Item weapon) {
		for (int i = 0; i < inventory.length; i++) { // checks the entire inventory
			if (weapon.name.equals(inventory[i].name)) { // checks for a matching name in the inventory
				equip(inventory[i]); // equips it if there is
			}
		}
	}

	/**
	 * This method sets the character's equipped weapon using the type of the weapon.
	 * @param type String
	 */
	public void setWeaponByType(String type) {
		for (int i = 0; i < inventory.length; i++) { // checks the entire inventory
			if (type.equals(inventory[i].type)) { // checks for a matching type in the inventory
				equip(inventory[i]); // equips it if there is
			}
		}
	}

	/**
	 * This method sets the character's equipped weapon using the type of the weapon.
	 * @param name String
	 */
	public void setWeaponByName(String name) {
		for (int i = 0; i < inventory.length; i++) { // checks the entire inventory
			if (name.equals(inventory[i].name)) { // checks for a matching name in the inventory
				equip(inventory[i]); // equips it if there is
			}
		}
	}

	/**
	 * This method sets the character's equipped gear using a passed item object.
	 * @param gear Item object
	 */
	public void setGear(Item gear) {
		for (int i = 0; i < inventory.length; i++) { // checks the entire inventory
			if (gear.name.equals(inventory[i].name)) { // checks for a matching name in the inventory
				equip(inventory[i]); // equips it if there is
			}
		}
	}

	/**
	 * This method sets the character's equipped gear using the name of the gear.
	 * @param name String
	 */
	public void setGearByName(String type) {
		for (int i = 0; i < inventory.length; i++) { // checks the entire inventory
			if (name.equals(inventory[i].name)) { // checks for a matching name in the inventory
				equip(inventory[i]); // equips it if there is
			}
		}
	}

	/**
	 * This method sets the character's equipped gear using the type of the gear.
	 * @param type String
	 */
	public void setGearByType(String type) {
		for (int i = 0; i < inventory.length; i++) { // checks the entire inventory
			if (type.equals(inventory[i].type)) { // checks for a matching type in the inventory
				equip(inventory[i]); // equips it if there is
			}
		}
	}

	/**
	 * This method uses some logic to determine what type of item is trying to be equipped, then changes the mod and the equip slot.
	 * @param a Item object
	 */
	void equip(Item a) {
		if (a.weapon) { // if the Item is a weapon
			if (firstWeapon) { // if it is the starting weapon
				strmod = a.mod; // sets the damage bonus = to the starting weapon's damage bonus
				firstWeapon = false; // sets the boolean = false so this can only be run once
			} else {
				strmod -= weapon.mod; // if it's not the first weapon equipped, you gotta subtract the mod of the original weapon
				strmod += a.mod; // and then add the mod of the new weapon
			}
			weapon = a; // stores what the new weapon is
			dmg = str + strmod; // redefines damage
		} else if (a.gear) {
			if (gearset) { // if a gear item has already been set, change the modifiers accordingly
				if (gear.dmgBoost) { // if the previous gear was a damage-boosting item
					strmod -= gear.mod; // subtract the bonus the item gave from the damage bonus
				} else {
					defmod -= gear.mod; // otherwise subtract the bonus the item gave from the damage reduction bonus
				}
			} else { // if a gear item is being set, change the variable to reflect state
				gearset = true; // lets the rest of the program know that a gear item has been set. It changes how some things are displayed
			}

			if (a.dmgBoost) { // if the new Item is a damage-boosting item
				strmod += a.mod; // adds to the damage bonus total
			} else {
				defmod += a.mod; // otherwise, adds to the damage reduction bonus
			}

			dmg = str + strmod; // redefines damage
			dmgred = def + defmod; // redefines the damage reduction stat
			gear = a; // stores what the new gear item is
		}
	}

	/**
	 * this method checks if the movement of the player wants to achieve is legal and if it is, moves the character.
	 * @param direction String
	 * @param spaces int
	 */
	public void move(String direction, int spaces) {
		// ABSTRACT THIS
		if (direction.equals("up")) {
			int newY = y - spaces;
			if (newY <= 0) {
				System.out.println("Your character can't move through walls.");
			} else {
				y = newY;
			}
		} else if (direction.equals("right")) {
			int newX = x + spaces;
			if ((newX >= 31) || (newX == 6 && y != 2 && y != 10 && y != 15 && y != 23) || (newX == 25 && y != 10 && y != 17 && y != 29)) {
				System.out.println("Your character can't move through walls.");
			} else {
				x = newX;
			}
		} else if (direction.equals("down")) {
			int newY = y + spaces;
			if (newY >= 31) {
				System.out.println("Your character can't move through walls.");
				newY = y;
			} else {
				y = newY;
			}
		} else if (direction.equals("left")) {
			int newX = x - spaces;
			if (newX <= 0) {
				System.out.println("Your character can't move through walls.");
			} else {
				x = newX;
			}
		}
	}

	/**
	 * This method checks if the race the player wants to be has defined stats in the system. If not, the player has to enter a new race until it is one that's defined.
	 * @param race
	 */
	private void legalRaceCheck(String race) {
		boolean legal = false;
		do {
			for (int i = 0; i < races.length; i++) {
				if (race.equals(races[i])) {
					legal = true;
					this.race = race;
				}
			}
			if (!legal) {
				System.out.println("That is not an answer. What race would you like to be?");
				race = reader.nextLine();
			}
		} while (!legal);
	}

	/**
	 * This method sets the player's base stats based on their race.
	 */
	private void raceSet() {
		if (race.equals("goblin")) {
			HP = 3;
			str = 2;
			def = 1;
			spd = 2;
		} else if (race.equals("human")) {
			HP = 4;
			str = 3;
			def = 3;
			spd = 1;
		} else if (race.equals("orc")) {
			HP = 6;
			str = 5;
			def = 1;
			spd = 1;
		}
	}

	/**
	 * This toString() method prints out the stats of the character.
	 */
	public String toString() {
		String s = "";
		if (gearset && !gear.dmgBoost) {
			s += "Your stats: \n  Strength: " + dmg + " (base: " + str + " + " + weapon.name + ")\n  Defense: "
					+ dmgred + " (base: " + def + " + " + gear.name + ")\n  HP: " + HP + "\n  Movement Speed: " + spd;
		} else if (gearset) {
			s += "Your stats: \n  Strength: " + dmg + " (base: " + str + " + " + weapon.name + " + " + gear.name
					+")\n  Defense: " + def + "\n  HP: " + HP + "\n  Movement Speed: " + spd;
		} else {
			s += "Your stats: \n  Strength: " + dmg + " (base: " + str + " + " + weapon.name + ")\n  Defense: "
					+ def + "\n  HP: " + HP + "\n  Movement Speed: " + spd;
		}
		return s;
	}
}
