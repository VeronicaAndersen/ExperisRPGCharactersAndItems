package characters;

import items.Item;
import items.armor.ArmorType;
import items.errors.InvalidArmorException;
import items.errors.InvalidLevelException;
import items.errors.InvalidWeaponException;
import items.weapons.Weapon;
import items.weapons.WeaponType;

import java.util.HashMap;

public abstract class Character {
  /*Creating private variables.*/
  private final String name;
  private int level = 1;
  private ArmorType[] armorList = {};
  private WeaponType[] weaponsList = {};

  protected abstract float calculateDPS(float weaponDPS);

  /*Creates a constructor that gets inherited by Mage, Ranger, Rough & Warrior.*/
  public Character(String name, int strength, int dexterity, int intelligence) {
    this.name = name;
    baseAttributes.addToAttributes(strength, dexterity, intelligence);
  }

  /*Method that increase level and increase baseAttributes.*/
  public void levelUp(int strengthIncrease, int dexterityIncrease, int intelligenceIncrease) {
    baseAttributes.addToAttributes(strengthIncrease, dexterityIncrease, intelligenceIncrease);
    level += 1;
  }

  /*Methods that gets & sets arrays , one for armor type & one for weapon type.*/
  public ArmorType[] getArmorList() {
    return armorList;
  }

  public void setArmorList(ArmorType[] armorList) {
    this.armorList = armorList;
  }

  public WeaponType[] getWeaponsList() {
    return weaponsList;
  }

  public void setWeaponsList(WeaponType[] weaponsList) {
    this.weaponsList = weaponsList;
  }

  /*Creates new attributes from PrimaryAttribute */
  PrimaryAttribute baseAttributes = new PrimaryAttribute();     //Base primary attributes of the character
  PrimaryAttribute itemAttributes = new PrimaryAttribute();     //Item primary attributes of the character
  PrimaryAttribute totalAttributes = new PrimaryAttribute();     //Total primary attributes of the character

  /*Method that adds all attributes from the items to totalAttributes.*/
  private void collectTotalAttributes() {
    itemAttributes.setToAttributes(0, 0, 0);
    slots.forEach((slot, item) -> itemAttributes.addToAttributes(item.getAttributes().getStrength(), item.getAttributes().getDexterity(), item.getAttributes().getIntelligence()));
    totalAttributes.mergeAttributes(itemAttributes, baseAttributes);
  }

  /*Method that sets baseAttributes to totalAttributes.*/
  public void calculateTotal() {
    totalAttributes = baseAttributes;
    baseAttributes.addToAttributes(itemAttributes.getStrength(), itemAttributes.getDexterity(), itemAttributes.getIntelligence());
  }

  /*Creates a hashmap for the equipments slots.*/
  HashMap<EquipmentSlots, Item> slots = new HashMap<>();

  /*Creates method for hashmap that returns slots.*/
  HashMap<EquipmentSlots, Item> getSlots() {
    return slots;
  }

  /*Check if the character is allowed to equip by armor types.*/
  public void equipArmor(EquipmentSlots slot, Item item) throws InvalidArmorException, InvalidLevelException {
    checkLevel(item);
    ArmorType[] armorTypes = getArmorList();
    for (ArmorType armorType : armorTypes) {
      if (armorType.equals(item.getArmorType())) { // Check if the item is an allowed type.
        slots.put(slot, item); // Adds the item to the list.
        collectTotalAttributes();
        break;
      }
    }
    /*Throws error messages if the item is not allowed for the character. */
    if (slots.get(slot) != item) {
      throw new InvalidArmorException("This type of armor cannot be equipped to this character.");
    }
  }

  /*Check if the character is allowed to equip by weapon types.*/
  public void equipWeapon(EquipmentSlots slot, Item item) throws InvalidWeaponException, InvalidLevelException {
    checkLevel(item);
    WeaponType[] weaponTypes = getWeaponsList();
    if (item.getClass().equals(Weapon.class)) {
      for (WeaponType weaponType : weaponTypes) {
        if (weaponType.equals(item.getWeaponType())) { // Check if the item is an allowed type.
          slots.put(slot, item); // Adds the item to the list.
          collectTotalAttributes();
          break;
        }
      }
      /*Throws error messages if the item is not allowed for the character. */
      if (slots.get(slot) != item) {
        throw new InvalidWeaponException("This type of weapon cannot be equipped to this character.");
      }
    }
  }

  /*Method that checks level*/
  public boolean checkLevel(Item item) throws InvalidLevelException {
    if (item.getRequiredLevel() > level) {
      throw new InvalidLevelException("Can´t be equipped to this character regarding level requirement.");
    } else {
      return true;
    }
  }

  /*Displaying the required stats & return it as a string.*/
  public String display() {
    /*Creating a stringBuilder for the required stats.*/
    StringBuilder displayStats = new StringBuilder();
    displayStats.append("Character Name: " + getName());
    displayStats.append("\nCharacter Level: " + getLevel());
    displayStats.append("\nStrength: " + totalAttributes.getStrength());
    displayStats.append("\nDexterity: " + totalAttributes.getDexterity());
    displayStats.append("\nIntelligence: " + totalAttributes.getIntelligence());
    displayStats.append("\nDamage: " + getCharacterDPS());
    return displayStats.toString();
  }

  /*Displaying equipped items.*/
  public String displayEquipItems() {
    StringBuilder displayEquip = new StringBuilder();
    displayEquip.append("Head: " + (getSlots().get(EquipmentSlots.Head) == null ? "Empty" : getSlots().get(EquipmentSlots.Head).getName()));
    displayEquip.append("\nBody: " + (getSlots().get(EquipmentSlots.Body) == null ? "Empty" : getSlots().get(EquipmentSlots.Body).getName()));
    displayEquip.append("\nLegs: " + (getSlots().get(EquipmentSlots.Legs) == null ? "Empty" : getSlots().get(EquipmentSlots.Legs).getName()));
    displayEquip.append("\nWeapon: " + (getSlots().get(EquipmentSlots.Weapon) == null ? "Empty" : getSlots().get(EquipmentSlots.Weapon).getName()));
    return displayEquip.toString();
  }

  /*Check if weapon is null than it will return 1 otherwise it will return the DPS for the weapon.*/
  public float getWeaponDPS() {
    Weapon weapon = (Weapon) slots.get(EquipmentSlots.Weapon);
    if (weapon == null) return calculateDPS(1);
    return weapon.getDPS();
  }

  /*Creates a method that return a method that get weaponsDPS.*/
  public float getCharacterDPS() {
    return calculateDPS(getWeaponDPS());
  }

  public int getLevel() {
    calculateTotal();
    return level;
  }

  public String getName() {
    return name;
  }

}
