package items;

import characters.EquipmentSlots;
import characters.PrimaryAttribute;
import items.armor.ArmorType;
import items.weapons.WeaponType;

/*This class include things for both armor and weapons.*/
public abstract class Item {

  private String name;
  private WeaponType weaponType;
  private ArmorType armorType;
  private int requiredLevel;
  private EquipmentSlots slot;
  private PrimaryAttribute attributes = new PrimaryAttribute();

  /*Constructor that get the name that being used in weapon.*/
  public Item(String itemName) {
    this.name = itemName;
  }

  /*Constructor that get the name and attributes that being used in armor.*/
  public Item(String itemName, int strength, int dexterity, int intelligence) {
    this.name = itemName;
    attributes.setStrength(strength);
    attributes.setDexterity(dexterity);
    attributes.setIntelligence(intelligence);
  }
/*Method that gets the name of the item. */
    public String getName() {
    return name;
  }
  /*Method that gets the required level.*/
  public int getRequiredLevel() {
    return requiredLevel;
  }

  /*Method that sets the required level.*/
  public void setRequiredLevel(int requiredLevel) {
    this.requiredLevel = requiredLevel;
  }

  /*Method that sets the weapon type.*/
  public void setWeaponType(WeaponType weaponType) {
    this.weaponType = weaponType;
  }

  /*Method that gets the weapon type.*/
  public WeaponType getWeaponType() {
    return weaponType;
  }

  /*Method that sets the armor type.*/
  public void setArmorType(ArmorType armorType) {
    this.armorType = armorType;
  }

  /*Method that gets the armor type.*/
  public ArmorType getArmorType() {
    return armorType;
  }

  /*Method that gets the slot. */
  public EquipmentSlots getSlot() {
    return slot;
  }

  /*Method that sets the slot. */
  public void setSlot(EquipmentSlots slot) {
    this.slot = slot;
  }

  /*Method that gets the attributes. */
  public PrimaryAttribute getAttributes() {
    return attributes;
  }
}
