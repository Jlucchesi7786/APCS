import java.util.Scanner;
/**
 * This runs the whole program using some while loops.
 * @author Dr. Cheese
 *
 */
public class Runner {
	static Room frame = new Room(30, 30, "down");
	static Chest[] Chests = frame.Chests;
	static Scanner reader = new Scanner(System.in);
	static public Player you;

	static String name = "";
	static int turn;
	static long ticks = 2000000000L;

	static boolean PlayerTurn = true;
	static boolean EnemyTurn = false;
	static boolean startup = false;
	static boolean running = false;
	
	static String action = "";
	static String[] actions = {"move", "open", "attack", "help", "help2", "inventory",
		"check inventory", "weapon", "check weapon", "gear", "check gear", "wait", "stats", "die"};

	static boolean checkInvent = false;
	static boolean inventHelp = true;
	static boolean canEquip = false;

	public static void main(String[] args) {
		startup();

		do {
			frame.update(you.x, you.y);
			frame.update(you);
			System.out.println(frame);
			//print("x: " + you.x + "\ny: " + you.y);

			if (PlayerTurn) {
				takeAction();
				EnemyTurn = true;
			}

			if (EnemyTurn) {
				PlayerTurn = true;
			}

			if (you.HP <= 0) {
				print("Your character died! Better luck next time");
				running = false;
			}
			turn++;
		} while (running);
	}

	static void takeAction() {
		if (turn == 0) {
			print("What would you like to do? (give commands in lowercase only) (example: move, attack, open)");
		} else {
			print("What would you like to do now?");
		}

		action = reader.nextLine();
		if (action.equals("")) {
			action = reader.nextLine();
		}
		
		catchActionException();

		while (notAnAction()) {
			if (action.equals("help")) {
				help();
			} else if (action.equals("help2")) {
				opening();
			} else if (action.equals("stats")) {
				stats();
			} else if (action.equals("check inventory") || action.equals("inventory")) {
				inventory();
				checkInvent = true;
				canEquip = true;
			} else if (action.equals("check weapon") || action.equals("weapon")) {
				print("you currently have a " + you.weapon.name + " equipped as your weapon.");
				checkInvent = true;
			} else if (action.equals("check gear") || action.equals("gear")) {
				if (you.gearset) {
					print("you currently have a " + you.gear.name + " equipped in your gear slot.");
				} else {
					print("you currently have no gear equipped.");
				}
				checkInvent = true;
			}
			
			if (!checkInvent) {
				print("What would you like to do now?");
				action = reader.nextLine();
			}
			
			while (checkInvent) {
				if (canEquip & inventHelp) {
					print("What would you like to do now? (you can equip other items in this menu. Enter equip to do so)");
					inventHelp = false;
				} else {
					print("What would you like to do now?");
				}
				action = reader.nextLine();
				if (canEquip) {
					if (action.equals("equip")) {
						boolean equipping = true;
						print("Would you like to equip a weapon or a gear item?");
						action = reader.nextLine();

						if (action.equals("weapon")) {
							print("Enter the name of the weapon you'd like to equip, including any bonus or Regular if there are none.");
							action = reader.nextLine();
							you.setWeaponByName(action);
							equipping = false;
							print("You equipped a " + you.weapon.name);
						} else if (action.equals("gear")) {
							equipping = false;
							print("Enter the name of the gear you'd like to equip, including any bonus or Regular if there are none.");
							action = reader.nextLine();
							you.setGearByName(action);
							print("You equipped a " + you.gear.name);
						}
						if (!equipping) {
							print("What would you like to do now?");
							action = reader.nextLine();
						}
					}
				}
				checkInvent = false;
			}
			
			catchActionException();
		}

		if (action.equals("move")) {
			move();
		} else if (action.equals("wait")) {
			print(name + " waited");
		} else if (action.equals("open")) {
			open();
		} else if (action.equals("die")) {
			you.HP = 0;
		}
		line();

		for (long i = 0; i < ticks; i++) {}
	}
	
	static boolean notAnAction() {
		boolean notAnAction = false;
		if (!action.equals("move") && !action.equals("wait") && !action.equals("open") &&
				!action.equals("die") && !action.equals("attack")) {
			notAnAction = true;
		}
		return notAnAction;
	}
	
	static void catchActionException() {
		boolean unrecognizedAction = true;
		do {
			for (int i = 0; i < actions.length; i++) {
				if (action.equals(actions[i])) {
					unrecognizedAction = false;
				}
			}
			
			if (unrecognizedAction) {
				print("That is not a recognized action. Please retype, or try something else.");
				action = reader.nextLine();
			}
		} while (unrecognizedAction);
	}
	
	static void startup() {
		if (startup == true) {
			print("Welcome to Jackson's Adventure Game! What would you like the character's name to be?");
			name = reader.nextLine();
			print("What race would you like to be? Your choices are human, orc, or goblin.");
			String race = reader.nextLine();
			you = new Player(race);
			while (you.HP <= 0) {
				print("That is not an answer. What race would you like to be?");
				race = reader.nextLine();
				you = new Player(race);

			}

			line();
			opening();
			stats();

			do {
				print("Are you ready to proceed?");
			} while (!reader.nextLine().equals("yes"));

			startup = false;
			running = true;
			line();
		} else {
			name = "J";
			you = new Player("goblin");
			running = true;
		}
	}

	static void stats() {
		line();
		System.out.println(you);
	}

	static void help() {
		String s = "";
		s += "The list of commands is as follows: \n";
		s += " - \'command\' (description) \n";
		s += " - \'move\' (lets your character move a space in one direction that you specify) \n";
		s += " - \'attack\' (makes your character attack one of the tiles next to him/her) \n";
		s += " - \'open\' (opens a chest that is next to your character) \n";
		s += " - \'stats\' (lets you see your character's stats) \n";
		s += " - \'wait\' (skips straight to the enemies' turn) \n";
		s += " - \'inventory\' or \'check inventory\' (lets you check your inventory and equip items. You can only equip"
				+ "\n     one item at a time) \n";
		s += " - \'weapon\' or \'check weapon\' (lets you check what your currently equipped weapon is) \n";
		s += " - \'gear\' or \'gear\' (lets you check what your currently equipped gear is) \n";
		s += "Make sure you give all your commands in lowercase! Enter help2 to see a list of all of the symbols and \n";
		s += "what they mean.";
		print(s);
	}

	static void opening() {
		String s = "";
		if (startup) {
			s += "Welcome, " + name + ". In this game, you are an adventurer who has delved into a dungeon. The symbols in this";
			s += " game \nrepresent a number of things. Here's a list: \n";
		} else {
			s += "Here is a list of all of the symbols you'll see on your journey: \n";
		}
		s += " - the \"#\"s represent the walls of the dungeon. \n";
		s += " - the \"|\" and \"-\" represent unlocked doors, while a \"+\" represents a locked door. \n";
		s += " - the \"@\" symbol is your character. \n";
		s += " - any \"X\" symbols represent monsters that roam the dungeon. \n";
		s += " - the \"H\" character represents a closed chest, while the \"O\" character represents an open chest.";
		if (startup) {
			s += " \nYou can enter help2 at any time to see this message again.";
		}
		print(s);
	}

	static void inventory() {
		String s = "In your inventory, you have:";
		for (int i = 0; i < you.inventory.length; i++) {
			s += "\n - a " + you.inventory[i].name;
		}
		/*s += "\nYou currently have equipped a " + you.weapon.name + " as your weapon and a \n" + you.weapon.name + 
				" equipped in your gear slot";*/
		if (you.gearset) {
			s += "\nCurrently Equipped: \n - Weapon: " + you.weapon.name + "\n - Gear Slot: " + you.gear.name;
		} else {
			s += "\nCurrently Equipped: \n - Weapon: " + you.weapon.name + "\n - Gear Slot: None";
		}
		s += "\n";
		print(s);
	}

	static void open() {
		for (int i = 0; i < Chests.length ; i++) {
			if ((Chests[i].x - you.x == -1) && (Chests[i].y == you.y)) {
				Chests[i].open();
			} else if ((Chests[i].x - you.x == 1) && (Chests[i].y == you.y)) {
				Chests[i].open();
			} else if ((Chests[i].y - you.y == -1) && (Chests[i].x == you.x)) {
				Chests[i].open();
			} else if ((Chests[i].y - you.y == 1) && (Chests[i].x == you.x)) {
				Chests[i].open();
			}

			if (Chests[i].open) {
				you.get(Chests[i].contents);
				print("you got a " + Chests[i].contents.name + "!");
				line();
			}
		}
	}

	static void move() {
		print("Which direction would you like to move? (up, down, left, or right)");
		String action = reader.nextLine();

		if (you.spd == 1) {
			you.move(action, 1);
			while (!you.moved) {
				print("Which direction would you like to move?");
				action = reader.nextLine();
				you.move(action, 1);
			}
			print(name + " moved " + action);
		} else {
			int spaces = 0;

			do {
				print("How many spaces would you like to move?");
				spaces = reader.nextInt();

				if (spaces > you.spd) {
					print("you can't move faster than your speed will allow.");
					line();
				} else if (spaces == 0) {
					print("you can't move 0 spaces.");
					line();
				} else if (spaces < 0) {
					print("you can't move negative spaces.");
					line();
				}
			} while ((spaces < 0) || (spaces == 0) || (spaces>you.spd));

			you.move(action, spaces);
			while (!you.moved) {
				action = "";
				print("Which direction would you like to move?");
				action = reader.nextLine();
				if (action.equals("")) {
					action = reader.nextLine();
				}
				do {
					print("How many spaces would you like to move?");
					spaces = reader.nextInt();

					if (spaces > you.spd) {
						print("you can't move faster than your speed will allow.");
						line();
					} else if (spaces == 0) {
						print("you can't move 0 spaces.");
						line();
					} else if (spaces < 0) {
						print("you can't move negative spaces.");
						line();
					}
				} while ((spaces < 0) || (spaces == 0) || (spaces>you.spd));

				you.move(action, spaces);
			}

			if (spaces != 1) {
				print(name + " moved " + action + " " + spaces + " spaces");
			} else {
				print(name + " moved " + action + " " + spaces + " space");
			}
		}
	}

	static void line() {
		System.out.println();
	}

	static void print(String s) {
		System.out.println(s);
	}
}
