package characters;

import items.Item;
import items.armor.Armor;
import items.armor.ArmorType;
import items.weapons.Weapon;
import items.weapons.WeaponType;
import java.util.HashMap;

public abstract class Character {
  private String name;
  private int level = 1;

  private ArmorType[] armorList = {};
  private WeaponType[] weaponsList = {};

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

  PrimaryAttribute baseAttributes = new PrimaryAttribute();     //Attributes of the character
  PrimaryAttribute totalAttributes = new PrimaryAttribute();     //Attributes of the character

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

  HashMap<EquipmentSlots, Item> slots = new HashMap<EquipmentSlots, Item>();

  public void Equipments(EquipmentSlots slot, Item item) {
    slots.put(slot, item);
    slots.get(slot);
  }

  public HashMap<EquipmentSlots, Item> getSlots() {
    return slots;
  }
  StringBuilder displayAll = new StringBuilder();
  public String display() {
    displayAll.append("CharacterName: " + name + " ");
    displayAll.append("CharacterLevel: " + level + " ");
    displayAll.append("Strength: " + baseAttributes.getStrength() + " ");
    displayAll.append("Dexterity: " + baseAttributes.getDexterity() + " ");
    displayAll.append("Intelligence: " + baseAttributes.getIntelligence() + " ");
    return displayAll.toString();
  }


  public float getWeaponDPS() {
    Weapon weapon = (Weapon) slots.get(EquipmentSlots.Weapon);
    if (weapon == null) return 0;
    return weapon.getDPS();
  }

  protected abstract float calculateDPS(float weaponDPS);

  public float getCharacterDPS() {
    return calculateDPS(getWeaponDPS());
  }
}
