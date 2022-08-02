package characters;

public class Warrior extends Character {
  public Warrior (String name){
    super(name, 5, 2, 1);
  }
  public void levelUp() {
    levelUp(3,2,1);
  }

}
