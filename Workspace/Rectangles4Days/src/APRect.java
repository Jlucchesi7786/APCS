/**
 * It's a rectangle object.
 * @author dr.cheese
 */
public class APRect {
	private int height;
	private int width;
	
	/**
	 * Constructs a rectangle for the supplied height h and width w;
	 * @param w
	 * @param h
	 */
	
	public APRect(int w, int h) {
		width = w;
		height = h;
	}
	
	/**
	 * Draws the rectangle with the crosses for corners and only the sides.
	 * @return String rectangle outline
	 */
	public String toString() {
		String x = "";
		for (int a = 0; a < height; a++) {
			for (int i = 0; i < width; i++) {
				if (a == 0 || a == height-1) {
					if (i == 0 || i == width-1) {
						x += "+ ";
					} else {
						x += "- ";
					}
				} else {
					if (i == 0 || i == width-1) {
						x += "| ";
					} else {
						x += "  ";
					}
				}
			}
			x += "\n";
		}
		
		return x;
	}

	/**
	 * Draws the rectangle filled in.
	 * @return String filled in rectangle
	 */
	public String draw() {
		String x = "";
		for (int a = 0; a < height; a++) {
			for (int b = 0; b < width; b++) {
				x += "*  ";
			}
			x += "\n";
		}
		return x;
	}
	/**
	 * Gets the width and height of the rectangle as a string. 
	 * @return String Width and Height
	 */
	public String stats() {
		String x = "Width: " + width + "\n height: " + height;
		
		return x;
	}
	
	/**
	 * Checks if a rectangle is a scaled version of this one.
	 * @param APRect
	 * @return boolean 
	 */
	public boolean isSimilar(APRect o) {
		int w = o.getWidth();
		int h = o.getHeight();
		double x = ((double) w)/width;
		double y = ((double) h)/height;
		x %= 1;
		y %= 1;
		if (x == 0) {
			if (y == 0) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * switches the height and width of the rectangle.
	 */
	public void invert() {
		int i = width;
		width = height;
		height = i;
	}
	/**
	 * makes the rectangle grow in size by a factor;
	 * @param int scalar
	 */
	public void scale(int scalar) {
		width *= scalar;
		height *= scalar;
	}
	/**
	 * sets the height of the rectangle to a new value.
	 * @param height
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	/**
	 * sets the width of the rectangle to a new value.
	 * @param width
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	
	/**
	 * finds the length of the diagonal of the rectangle.
	 * @return double diagonal
	 */
	public double getDiagonal() {
		double d = 0;
		d = Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2) );
		return d;
	}
	/**
	 * finds the area of the rectangle.
	 * @return int area
	 */
	public int getArea() {
		int area = width * height;
		return area;
	}
	/**
	 * gets the height of the rectangle.
	 * @return int height
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * gets the width of the rectangle.
	 * @return int width
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * checks if one rectangle is the same as another.
	 * @param otherRect
	 * @return boolean
	 */
	public boolean equals(APRect otherRect) {
		
		if (otherRect.getHeight() == height) {
			if (otherRect.getWidth() == width) {
				return true;
			}
		}
		
		return false;
	}
}
