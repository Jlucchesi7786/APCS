import java.util.*;

/**
 * This class holds a bunch of the information about the character
 * @author Dr. Cheese
 */
public class Player {
	public Position pos;

	private Scanner reader = new Scanner(System.in); //lets the player set a new race if the old one doesn't work
	public Tile space = new Tile("player");
	public Tile[][] map = {};

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
		pos = new Position(30, 1);

		legalRaceCheck(race); // checks if the race the player wants to be is defined
		raceSet(); // once the race is considered legal, the constructor sets up the base stats

		equip(inventory[0]); // equips the starting weapon
	}

	/**
	 * This constructor sets up the player at an x and y position without initializing their inventory.
	 */
	Player() {
		this("goblin");
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
	 * This method sets the character's equipped gear using the name of the gear.
	 * @param name String
	 */
	public void setGearByName(String name) {
		for (int i = 0; i < inventory.length; i++) { // checks the entire inventory
			if (name.equals(inventory[i].name)) { // checks for a matching name in the inventory
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
		Position newPos = new Position(0,0);
		if (direction.equals("up")) {
			newPos = new Position(pos.x, pos.y-spaces);
		} else if (direction.equals("right")) {
			newPos = new Position(pos.x+spaces, pos.y);
		} else if (direction.equals("down")) {
			newPos = new Position(pos.x, pos.y+spaces);
		} else if (direction.equals("left")) {
			newPos = new Position(pos.x-spaces, pos.y);
		}
		
		if (legalMoveCheck(direction) == true) {
			pos = newPos;
		}
	}
	
	public void getMap(Tile[][] map) {
		this.map = map;
	}
	
	private boolean legalMoveCheck(String direction) {
		String tileType = "";
		if (direction.equals("up")) {
			tileType = map[pos.y-1][pos.x].type;
		} else if (direction.equals("right")) {
			tileType = map[pos.y][pos.x+1].type;
		} else if (direction.equals("down")) {
			tileType = map[pos.y+1][pos.x].type;
		} else if (direction.equals("left")) {
			tileType = map[pos.y][pos.x-1].type;
		}
		
		if (tileType.equals("empty") || tileType.equals("horizontal door") || tileType.equals("vertical door")) {
			return true;
		}
		return false;
	}

	/**
	 * This method checks if the race the player wants to be has defined stats in the system. If not, the player has to enter a new race until it is one that's defined.
	 * @param race
	 */
	private void legalRaceCheck(String race) {
		boolean legal = false; // used for the while loop so it can check if the race is legal
		do {
			for (int i = 0; i < races.length; i++) { // checks the entire races[] array
				if (race.equals(races[i])) { // if there is a matching string
					legal = true; // it's legal
					this.race = race; //then sets the race
				}
			}
			if (!legal) { // if it's not legal
				System.out.println("That is not an answer. What race would you like to be?"); // asks for a new input
				race = reader.nextLine(); // sets the new race String
			}
		} while (!legal); // keeps repeating until there's a legal race
	}

	/**
	 * This method sets the player's base stats based on their race.
	 */
	private void raceSet() { // sets HP, str, def, and spd
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
		if (gearset && !gear.dmgBoost) { // if the player has set gear and it increases dmg
			s += "Your stats: \n  Strength: " + dmg + " (base: " + str + " + " + weapon.name + " + " + gear.name
					+")\n  Defense: " + def + "\n  HP: " + HP + "\n  Movement Speed: " + spd;
		} else if (gearset) { // if the player has set gear, but it increases defense
s += "Your stats: \n  Strength: " + dmg + " (base: " + str + " + " + weapon.name + ")\n  Defense: "
		+ dmgred + " (base: " + def + " + " + gear.name + ")\n  HP: " + HP + "\n  Movement Speed: " + spd;
	} else { // if the player has no gear set
			s += "Your stats: \n  Strength: " + dmg + " (base: " + str + " + " + weapon.name + ")\n  Defense: "
					+ def + "\n  HP: " + HP + "\n  Movement Speed: " + spd;
		}
		return s;
	}
}
