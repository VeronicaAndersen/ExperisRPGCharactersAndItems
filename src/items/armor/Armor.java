package items.armor;

import characters.EquipmentSlots;
import characters.PrimaryAttribute;
import items.Item;

import java.util.HashMap;

public class Armor extends Item{
  public Armor(String armorName, PrimaryAttribute primaryAttribute) {
    super(armorName);
    this.primaryAttribute = primaryAttribute;
//    primaryAttribute.addToAttributes(5, 5, 5 );
  }
  public PrimaryAttribute primaryAttribute = new PrimaryAttribute();
}
