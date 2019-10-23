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
	 * This constructor sets up the player with a character at some x and y decided by the author and a race set by the player
	 * @param race String
	 */
	Player(String race) {
		x = 30;
		y = 1;

		legalRaceCheck(race);
		raceSet();

		equip(inventory[0]);
	}

	/**
	 * This constructor sets up the player at an x and y position without initializing their inventory
	 */
	Player() {
		x = 30;
		y = 1;
	}

	/**
	 * This method lets the character add an item to their inventory
	 * @param a Item object
	 */
	public void get(Item a) {
		ArrayList<Item> b = new ArrayList<Item>();
		for (int i = 0; i < inventory.length; i++) {
			b.add(inventory[i]);
		}
		b.add(a);
		inventory = new Item[b.size()];
		b.toArray(inventory);
	}

	/**
	 *
	 * @param a Item object
	 */
	public void setWeapon(Item a) {
		for (int i = 0; i < inventory.length; i++) {
			if (a.name.equals(inventory[i].name)) {
				equip(inventory[i]);
			}
		}
	}

	/**
	 *
	 * @param s
	 */
	public void setWeaponByType(String s) {
		for (int i = 0; i < inventory.length; i++) {
			if (s.equals(inventory[i].type)) {
				equip(inventory[i]);
			}
		}
	}

	/**
	 *
	 * @param s
	 */
	public void setWeaponByName(String s) {
		for (int i = 0; i < inventory.length; i++) {
			if (s.equals(inventory[i].name)) {
				equip(inventory[i]);
			}
		}
	}

	/**
	 *
	 * @param a
	 */
	public void setGear(Item a) {
		for (int i = 0; i < inventory.length; i++) {
			if (a.name.equals(inventory[i].name)) {
				equip(inventory[i]);
			}
		}
		gearset = true;
	}

	/**
	 *
	 * @param s
	 */
	public void setGearByName(String s) {
		for (int i = 0; i < inventory.length; i++) {
			if (s.equals(inventory[i].name)) {
				equip(inventory[i]);
			}
		}
		gearset = true;
	}

	/**
	 *
	 * @param s
	 */
	public void setGearByType(String s) {
		for (int i = 0; i < inventory.length; i++) {
			if (s.equals(inventory[i].type)) {
				equip(inventory[i]);
			}
		}
		gearset = true;
	}

	/**
	 *
	 * @param a
	 */
	void equip(Item a) {
		if (a.weapon) {
			if (firstWeapon) {
				strmod = a.mod;
				firstWeapon = false;
			} else {
				strmod -= weapon.mod;
				strmod += a.mod;
			}
			weapon = a;
			dmg = str + strmod;
		} else if (a.gear) {
			if (gearset) {
				if (gear.dmgBoost) {
					strmod -= gear.mod;
				} else {
					defmod -= gear.mod;
				}
			}

			if (a.dmgBoost) {
				strmod += a.mod;
				dmg = str + strmod;
			} else {
				defmod += a.mod;
				dmgred = def + defmod;
			}
			gear = a;
		}
	}

	/**
	 *
	 * @param direction
	 * @param spaces
	 */
	public void move(String direction, int spaces) {
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
	 *
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
	 *
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
	 *
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
