package characters;

public class Mage extends Character {
  public Mage (String name){
    super(name, 1, 1, 8);
  }
  public void levelUp() {
    levelUp(1,1,5);
  }


}
