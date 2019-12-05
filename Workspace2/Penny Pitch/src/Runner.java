import java.util.*;

public class Runner {
	static Square[] row1 = {new Square(1), new Square(1), new Square(1), new Square(1),
		new Square(1)};
	static Square[] row2 = {new Square(1), new Square(2), new Square(2), new Square(2),
		 new Square(1)};
	static Square[] row3 = {new Square(1),  new Square(2), new Square(3), new Square(2),
		 new Square(1)};
	static Square[] row4 = {new Square(1), new Square(2), new Square(2), new Square(2),
		 new Square(1)};
	static Square[] row5 = {new Square(1), new Square(1), new Square(1), new Square(1),
		new Square(1)};
	static Square[][] grid = {row1, row2, row3, row4, row5};
	
	static int penny = 0;
	static boolean running = true;
	static Scanner reader = new Scanner(System.in);
	
	static int score = 0;
	
	public static void main(String[] args) {
		do {
			for (penny = 0; penny < 5; penny++) {
				showGrid();
				waitForPlayer();
				throwPenny();
			}
			endGame();
		} while(running);
		System.out.println("Thanks for playing!");
	}
	
	private static void throwPenny() {
		int x = (int) (Math.random()*5);
		int y = (int) (Math.random()*5);
		System.out.println("Position: (" + x + ", " + y + ")");
		grid[y][x].setState(true);
		score += grid[y][x].getScore();
		System.out.println("Current score: " + score);
	}
	
	private static void showGrid() {
		String s = "\n";
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j].getState() == false) {
					s += "" + grid[i][j].getScore() + "   ";
				} else {
					s += "P   ";
				}
			}
			s += "\n\n";
		}
		System.out.println(s);
	}
	
	private static void waitForPlayer() {
		System.out.println("Press enter to continue.");
		String s = reader.nextLine();
	}
	
	private static void endGame() {
		showGrid();
		System.out.println("This game has finished. You had a score of " + score +
	". If you would like to play again, " + "please enter \"yes\".");
		String s = reader.nextLine();
		if (!s.equals("yes")) {
			running = false;
		} else {
			score = 0;
		}
	}
}
