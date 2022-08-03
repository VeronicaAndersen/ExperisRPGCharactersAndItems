package characters;

public class Mage extends Character {
  public Mage (String name){
    super(name, 1, 8, 1);
  }
  public void levelUp() {
    levelUp(1,1,5);
  }
  @Override
  public float calculateDPS(float weaponDPS) {
System.out.println(totalAttributes.getIntelligence());
    return weaponDPS * (1 + (float)totalAttributes.getIntelligence()/100);

  }
}
