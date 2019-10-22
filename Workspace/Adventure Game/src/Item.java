
public class Item {
	public String type;
	int baseMod;
	int itemMod;
	public int mod;
	String name;

	public boolean weapon;
	public boolean gear;
	public boolean shield;
	public boolean dmgBoost;

	String[] types = {"Longsword", "Iron Shield", "Shortsword", "Amulet of Strength"};

	Item(String type, int itemMod) {
		this.type = type;
		this.itemMod = itemMod;
		typeCheck();
		mod = baseMod + itemMod;
		setName();
	}

	Item() {
		int rand = (int) Math.ceil(Math.random()*types.length)-1;
		type = types[rand];
		itemMod = (int) Math.ceil(Math.random()*10);
		typeCheck();
		mod = baseMod + itemMod;
		setName();
	}

	void setName() {
		if (itemMod != 0) {
			name = "+" + itemMod + " " + type;
		} else {
			name = "Regular " + type;
		}
	}

	void typeCheck() {
		if (type.equals("Longsword")) {
			baseMod = 4;
			weapon = true;
			gear = false;
			shield = false;
			
			dmgBoost = true;
		} else if (type.equals("Shortsword")) {
			baseMod = 2;
			weapon = true;
			gear = false;
			shield = false;
			
			dmgBoost = true;
		}

		if (type.equals("Amulet of Strength")) {
			baseMod = 0;
			weapon = false;
			gear = true;
			shield = false;
			
			dmgBoost = true;
		} else if (type.equals("Iron Shield")) {
			baseMod = 2;
			weapon = false;
			gear = true;
			shield = true;
			
			dmgBoost = false;
		}
	}

	Item generate() {
		Item a;
		int rand = (int) Math.ceil(Math.random()*types.length)-1;
		String t = types[rand];
		rand = (int) Math.ceil(Math.random()*10);
		a = new Item(t, rand);
		return a;
	}

	public String toString() {		
		return (type + ", +" + itemMod + "\n - It has a base mod of +" + baseMod + "\n - Combined with the +" + itemMod + ", it has a total mod of +" + mod);
	}

	public int getBaseMod() {
		return baseMod;
	}

	public int getItemMod() {
		return itemMod;
	}

	public void setItemMod(int itemMod) {
		this.itemMod = itemMod;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
