package characters;

public class Ranger extends Character{
  public Ranger (String name){
    super(name, 1, 7, 1);
  }
  public void levelUp() {
    levelUp(1,5,1);
  }

}
