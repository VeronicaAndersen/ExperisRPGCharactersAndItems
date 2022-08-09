package characters;

public class PrimaryAttribute {
  private int strength = 0, dexterity = 0, intelligence = 0; //Sets primary attribute to 0 from start.

  public PrimaryAttribute() {
  }

  /*Method that adds the attributes.*/
  public void addToAttributes(int strength, int dexterity, int intelligence) {
    this.strength += strength;
    this.dexterity += dexterity;
    this.intelligence += intelligence;
  }

  /*Method that sets the attributes.*/
  public void setToAttributes(int strength, int dexterity, int intelligence) {
    this.strength = strength;
    this.dexterity = dexterity;
    this.intelligence = intelligence;
  }

  /*Method that merge attributes together.*/
  public void mergeAttributes(PrimaryAttribute attributes1, PrimaryAttribute attributes2) {
    this.strength = attributes1.getStrength() + attributes2.getStrength();
    this.dexterity = attributes1.getDexterity() + attributes2.getDexterity();
    this.intelligence = attributes1.getIntelligence() + attributes2.getDexterity();
  }

  /*Getter & setter for the attributes.*/
  public int getStrength() {
    return strength;
  }

  public void setStrength(int strength) {
    this.strength = strength;
  }

  public int getDexterity() {
    return dexterity;
  }

  public void setDexterity(int dexterity) {
    this.dexterity = dexterity;
  }

  public int getIntelligence() {
    return intelligence;
  }

  public void setIntelligence(int intelligence) {
    this.intelligence = intelligence;
  }
}
