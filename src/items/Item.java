package items;

import characters.EquipmentSlots;
import characters.PrimaryAttribute;
import items.armor.ArmorType;
import items.weapons.WeaponType;

public class Item {

  private String name;
  private WeaponType weaponType;
  private ArmorType armorType;
  private int requiredLevel;
  private EquipmentSlots slot;

  private PrimaryAttribute attributes = new PrimaryAttribute(0,0,0);

  public String getName() {
    return name;
  }


  public Item(String itemName) {
    this.name = itemName;
  }
  public Item(String itemName, int strength, int dexterity, int intelligence) {
    this.name = itemName;
    attributes.setStrength(strength);
    attributes.setDexterity(dexterity);
    attributes.setIntelligence(intelligence);

  }

  public int getRequiredLevel() {
    return requiredLevel;
  }

  public void setRequiredLevel(int requiredLevel) {
    this.requiredLevel = requiredLevel;
  }
  public void setWeaponType(WeaponType weaponType) {
    this.weaponType = weaponType;
  }
  public WeaponType getWeaponType() {
    return weaponType;
  }
  public void setArmorType(ArmorType armorType) {
    this.armorType = armorType;
  }
  public ArmorType getArmorType() {
    return armorType;
  }

  public EquipmentSlots getSlot() {
    return slot;
  }

  public void setSlot(EquipmentSlots slot) {
    this.slot = slot;
  }

  public PrimaryAttribute getAttributes() {
    return attributes;
  }
}
