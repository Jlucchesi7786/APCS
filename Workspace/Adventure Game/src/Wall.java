
public class Wall {
  public int length;
  public int xStart;
  public int yStart;

  public boolean horizontal;
  public boolean vertical;

  public String drawing;

  public Tile space;

  public Wall(String orientation, int length, int positionXstart, int positionYstart) {
    this.length = length;
    this.xStart = positionXstart;
    this.yStart = positionYstart;
    space = new Tile("wall");

    if (orientation.equals("horizontal")) {
      horizontalSetup();
    } else if (orientation.equals("vertical")) {
      verticalSetup();
    }
  }

  private void horizontalSetup() {
    for (int i = 0; i < length; i++) {
      drawing += space.character + " ";
    }
    horizontal = true;
    vertical = false;
  }

  private void verticalSetup() {
    horizontal = true;
    vertical = false;
  }
}
