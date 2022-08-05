package items.armor;

import characters.EquipmentSlots;
import characters.PrimaryAttribute;
import items.Item;

import java.util.HashMap;

public class Armor extends Item{

  public Armor(String armorName, int strength,  int dexterity, int intelligence, int requiredLevel, ArmorType armorType) {
    super(armorName, strength, dexterity, intelligence);
    this.setRequiredLevel(requiredLevel);
    this.setArmorType(armorType);
  }
  public PrimaryAttribute primaryAttribute = new PrimaryAttribute();
}
