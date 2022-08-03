package characters;
public class PrimaryAttribute {
  private int strength, dexterity, intelligence;
  public PrimaryAttribute(){
  }
  public PrimaryAttribute(int strength, int dexterity, int intelligence){
    this.strength = strength;
    this.dexterity = dexterity;
    this.intelligence = intelligence;
  }
  public void addToAttributes(int strength, int dexterity, int intelligence) {
    this.strength += strength;
    this.dexterity += dexterity;
    this.intelligence += intelligence;
  }
  public void addAttribute(PrimaryAttribute attributeToAdd){
    strength += attributeToAdd.getStrength();
    dexterity += attributeToAdd.getDexterity();
    intelligence += attributeToAdd.getIntelligence();
  }
//  public void setToAttributes(int strength, int dexterity, int intelligence) {
//    this.strength = strength;
//    this.dexterity = dexterity;
//    this.intelligence = intelligence;
//  }
//  public void mergeAttributes(PrimaryAttribute attributes1, PrimaryAttribute attributes2) {
//    this.strength = attributes1.getStrength() + attributes2.getStrength();
//    this.dexterity = attributes1.getDexterity() + attributes2.getDexterity();
//    this.intelligence = attributes1.getIntelligence() + attributes2.getDexterity();
//  }
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
