
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
}
