
public class Tile {
  public String character;
  public String type;

  public Position pos;

  private String[] types = {"horizontal door", "vertical door", "monster", "closed chest",
		  "open chest", "player", "wall", "empty"};
  private String[] characters = {"-", "|", "X", "H", "O", "@", "#", " "};

  public Tile(String type, Position position) {
    
    this.type = type;
    charSet();
  }

  public void update(String type) {
    this.type = type;
    charSet();
  }

  private void charSet() {
    for (int i = 0; i < types.length; i++) {
      if (type.equals(types[i])) {
        character = characters[i];
      }
    }
  }
}
