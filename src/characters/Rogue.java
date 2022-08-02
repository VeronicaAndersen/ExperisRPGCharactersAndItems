package characters;

public class Rogue extends Character{
  public Rogue (String name){
    super(name, 2, 6, 1);
  }
  public void levelUp() {
    levelUp(1,4,1);
  }

}
