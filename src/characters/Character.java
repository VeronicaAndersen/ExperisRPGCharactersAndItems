package characters;

import items.Item;
import items.armor.Armor;
import items.armor.ArmorType;
import items.armor.InvalidArmorException;
import items.weapons.InvalidWeaponException;
import items.weapons.Weapon;
import items.weapons.WeaponType;

import java.util.Arrays;
import java.util.HashMap;

public abstract class Character {
  private String name;
  private int level = 1;
  private ArmorType[] armorList = {};
  private WeaponType[] weaponsList = {};

  private String weaponType;
  private String armorType;

  public String getName() {
    return name;
  }

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

  PrimaryAttribute baseAttributes = new PrimaryAttribute();     //Base primary attributes of the character
  PrimaryAttribute itemAttributes = new PrimaryAttribute();     //Item primary attributes of the character
  PrimaryAttribute totalAttributes = new PrimaryAttribute();     //Total primary attributes of the character

  public void collectTotalAttributes() {
    itemAttributes.setToAttributes(0, 0, 0);

    slots.forEach((slot, item) -> itemAttributes.addToAttributes(item.getAttributes().getStrength(), item.getAttributes().getDexterity(), item.getAttributes().getIntelligence()));
    totalAttributes.mergeAttributes(itemAttributes, baseAttributes);
    System.out.println(totalAttributes.getStrength());
  }

  public Character(String name, int strength, int dexterity, int intelligence) {
    this.name = name;
    baseAttributes.addToAttributes(strength, dexterity, intelligence);
  }

  public void levelUp(int strengthIncrease, int dexterityIncrease, int intelligenceIncrease) {
    baseAttributes.addToAttributes(strengthIncrease, dexterityIncrease, intelligenceIncrease);
    level += 1;
  }

  public void calculateTotal() {
    totalAttributes = baseAttributes;
    slots.forEach((slot, item) -> {
      if (item instanceof Armor)
        baseAttributes.addAttribute(((Armor) item).primaryAttribute);
    });
  }

  HashMap<EquipmentSlots, Item> slots = new HashMap<>();

  /*Check if the character is allowed to equip by the requiredLevel and weapon types and same for armor..*/
  public <T> void Equipments(EquipmentSlots slot, Item item, T[] types) {
    if (item.getClass().equals(Weapon.class)) {
      for (int i = 0; i < getWeaponsList().length; i++) {
        try {
          if (getWeaponsList()[i].equals(item.getWeaponType()) && level >= item.getRequiredLevel()) {
            slots.put(slot, item);
            collectTotalAttributes();
            System.out.println("Ok weapon");
            break;
          } else {
            throw new InvalidWeaponException("This weapon is not ok.");
          }
        } catch (InvalidWeaponException invalidWeaponException) {
          break;
        }
      }
    }
    if (item.getClass().equals(Armor.class)) {
      for (int i = 0; i < getArmorList().length; i++) {
        try {
          if (getArmorList()[i].equals(item.getArmorType()) && level >= item.getRequiredLevel()) {
            slots.put(slot, item);
            collectTotalAttributes();
            System.out.println("Ok armor");
            break;
          } else {
            throw new InvalidArmorException("This armor is not ok.");
          }
        } catch (InvalidArmorException invalidWeaponException) {
          break;
        }
      }
    }
  }

  public HashMap<EquipmentSlots, Item> getSlots() {
    return slots;
  }

  /*Creating a stringBuilder for the required stats.*/
  StringBuilder displayAll = new StringBuilder();

  public String display() {
    displayAll.append("CharacterName: " + name + " ");
    displayAll.append("CharacterLevel: " + level + " ");
    displayAll.append("Strength: " + baseAttributes.getStrength() + " ");
    displayAll.append("Dexterity: " + baseAttributes.getDexterity() + " ");
    displayAll.append("Intelligence: " + baseAttributes.getIntelligence() + " ");
    return displayAll.toString();
  }

  /*Check if weapon is null than it will return 0 otherwise it will return the DPS for the weapon.*/
  public float getWeaponDPS() {
    Weapon weapon = (Weapon) slots.get(EquipmentSlots.Weapon);
    if (weapon == null) return 0;
    return weapon.getDPS();
  }

  /**/
  protected abstract float calculateDPS(float weaponDPS);

  public float getCharacterDPS() {
    return calculateDPS(getWeaponDPS());
  }
}
