package characters;

public class Rogue extends Character{
  public Rogue (String name){
    super(name, 2, 6, 1);
  }
  public void levelUp() {
    levelUp(1,4,1);
  }
  @Override
  public float calculateDPS(float weaponDPS) {
    return weaponDPS * (1 + totalAttributes.getDexterity()/100);
  }
}
