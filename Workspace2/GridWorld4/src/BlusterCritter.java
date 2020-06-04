import info.gridworld.actor.*;

import java.awt.Color;
import java.util.*;

public class BlusterCritter extends Critter {
	private int c;
	private int colorval;
	
	public BlusterCritter(int courageLevel) {
		this.c = courageLevel;
		colorval = 255;
		this.setColor(Color.WHITE);
		
	}
	
	public void processActors(ArrayList<Actor> actors) {
		if (actors.size() < c) {
			if (colorval < 255) {
				colorval += 5;
			}
		} else {
			if (colorval > 0) {
				colorval -= 5;
			}
		}
		Color c = new Color(colorval, colorval, colorval);
		this.setColor(c);
	}
}
