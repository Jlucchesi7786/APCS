
public class Position {
  public int x;
  public int y;

  public Position(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public void updateX(int newX) {
    this.x = newX;
  }

  public void updateY(int newY) {
    this.y = newY;
  }

  public void updatePosition(int newX, int newY) {
    this.x = newX;
    this.y = newY;
  }
  
  public void flipPosition() {
	  int a = this.x;
	  this.x = this.y;
	  this.y = a;
  }
  
  public boolean equals(Position other) {
	  if (this.x == other.x && this.y == other.y) {
		  return true;
	  }
	  return false;
  }
  
  public String toString() {
	  return "x: " + this.x + "   y: " + this.y;
  }
  
  public int getX() {
	  return x;
  }
  
  public int getY() {
	  return y;
  }
}
