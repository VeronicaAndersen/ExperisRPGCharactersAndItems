package characters;

public class CharacterAttribute {
  private int strength, dexterity, intelligence;
  public CharacterAttribute(){
  }

  public void addToAttributes(int strength, int dexterity, int intelligence) {
    this.strength += strength;
    this.dexterity += dexterity;
    this.intelligence += intelligence;
  }

  public void setToAttributes(int strength, int dexterity, int intelligence) {
    this.strength = strength;
    this.dexterity = dexterity;
    this.intelligence = intelligence;
  }

  public void mergeAttributes(CharacterAttribute attributes1, CharacterAttribute attributes2) {
    this.strength = attributes1.getStrength() + attributes2.getStrength();
    this.dexterity = attributes1.getDexterity() + attributes2.getDexterity();
    this.intelligence = attributes1.getIntelligence() + attributes2.getDexterity();
  }



  public int getStrength() {
    return strength;
  }

  public void setStrength(int strength) {
    strength = strength;
  }

  public int getDexterity() {
    return dexterity;
  }

  public void setDexterity(int dexterity) {
    dexterity = dexterity;
  }

  public int getIntelligence() {
    return intelligence;
  }

  public void setIntelligence(int intelligence) {
    intelligence = intelligence;
  }
}
