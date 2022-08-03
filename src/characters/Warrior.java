package characters;

public class Warrior extends Character {
  public Warrior (String name){
    super(name, 5, 2, 1);
  }
  public void levelUp() {
    levelUp(3,2,1);
  }
  @Override
  public float calculateDPS(float weaponDPS) {
    return weaponDPS * (1 + totalAttributes.getStrength()/100);
  }
}
