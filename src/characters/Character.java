package characters;

import items.Item;
import items.armor.Armor;
import items.armor.ArmorType;
import items.errors.InvalidArmorException;
import items.errors.InvalidWeaponException;
import items.weapons.Weapon;
import items.weapons.WeaponType;

import java.util.HashMap;

public abstract class Character {
  /*Creating private variables.*/
  private String name;
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
  public void collectTotalAttributes() {
    itemAttributes.setToAttributes(0, 0, 0);
    slots.forEach((slot, item) -> itemAttributes.addToAttributes(item.getAttributes().getStrength(), item.getAttributes().getDexterity(), item.getAttributes().getIntelligence()));
    totalAttributes.mergeAttributes(itemAttributes, baseAttributes);
  }

  /*Method that sets baseAttributes to totalAttributes.*/
  public void calculateTotal() {
    totalAttributes = baseAttributes; /**OKLART????????**/
    baseAttributes.addToAttributes(itemAttributes.getStrength(), itemAttributes.getDexterity(), itemAttributes.getIntelligence());
  }

  /*Creates a hashmap for the equipmentslots.*/
  HashMap<EquipmentSlots, Item> slots = new HashMap<>();

  /*Creates method for hashmap that returns slots.*/
  public HashMap<EquipmentSlots, Item> getSlots() {
    return slots;
  }

  /*Check if the character is allowed to equip by the requiredLevel and weapon types and same for armor.*/
  public <T> void Equipments(EquipmentSlots slot, Item item, T[] types) {
    if (item.getClass().equals(Weapon.class)) { //Check if the item is a weapon.
      for (int i = 0; i < getWeaponsList().length; i++) { //Iterates through the list.
        try {
          if (getWeaponsList()[i].equals(item.getWeaponType()) && level >= item.getRequiredLevel()) { // Check if the item is allowed regarding the level & allowed type.
            slots.put(slot, item); // Adds the item to the list.
            //collectTotalAttributes();
            System.out.println("This weapon is allowed");
            break;
          } else {
            throw new InvalidWeaponException("This weapon is not allowed depending on your level or type of weapon.");
          }
        } catch (InvalidWeaponException invalidWeaponException) {
          break;
        }
      }
    }
    if (item.getClass().equals(Armor.class)) { //Check if the item is an armor.
      for (int i = 0; i < getArmorList().length; i++) { //Iterates through the list.
        try {
          if (getArmorList()[i].equals(item.getArmorType()) && level >= item.getRequiredLevel()) { // Check if the item is allowed regarding the level & allowed type.
            slots.put(slot, item); // Adds the item to the list.
            collectTotalAttributes(); // Add the attributes to the total.
            System.out.println("This armor is allowed");
            break;
          } else {
            throw new InvalidArmorException("This armor is not allowed depending on your level or type of armor.");
          }
        } catch (InvalidArmorException invalidWeaponException) {
          break;
        }
      }
    }
  }

  /*Creating a stringBuilder for the required stats.*/
  StringBuilder displayStats = new StringBuilder();

  /*Displaying the required stats & return it as a string.*/
  public String display() {
    displayStats.append("Character Name: " + getName());
    displayStats.append("\nCharacter Level: " + getLevel());
    displayStats.append("\nStrength: " + baseAttributes.getStrength());
    displayStats.append("\nDexterity: " + baseAttributes.getDexterity());
    displayStats.append("\nIntelligence: " + baseAttributes.getIntelligence());
    displayStats.append("\nDamage: "+ getCharacterDPS());
    return displayStats.toString();
  }

  /*Check if weapon is null than it will return 1 otherwise it will return the DPS for the weapon.*/
  public float getWeaponDPS() {
    Weapon weapon = (Weapon) slots.get(EquipmentSlots.Weapon);
    if (weapon == null) return 1;
    return weapon.getDPS();
  }

  /*Creates a method that return a method that get weaponsDPS.*/
  public float getCharacterDPS() {
    return calculateDPS(getWeaponDPS());
  }

  public int getLevel(){
    System.out.println(level);
    return level;
  }
  public String getName(){
    System.out.println(name);
    return name;
  }

}
