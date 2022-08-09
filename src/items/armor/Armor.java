package items.armor;

import items.Item;

/*Child class that inherit from the class item.*/
public class Armor extends Item {
  /*Constructor for Armor.*/
  public Armor(String armorName, int strength, int dexterity, int intelligence, int requiredLevel, ArmorType armorType) {
    super(armorName, strength, dexterity, intelligence);
    this.setRequiredLevel(requiredLevel);
    this.setArmorType(armorType);
  }
}
