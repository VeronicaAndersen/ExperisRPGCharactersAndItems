package characters;

import items.Item;
import items.armor.Armor;
import items.weapons.Weapon;
import java.util.HashMap;
public abstract class Character {
  private String name;
  private int level = 1;
  public String getName() {
    return name;
  }
  PrimaryAttribute baseAttributes = new PrimaryAttribute();     //Attributes of the character
  PrimaryAttribute totalAttributes = new PrimaryAttribute();     //Attributes of the character
  public Character(String name, int strength, int intelligence, int dexterity) {
    this.name = name;
    baseAttributes.addToAttributes(strength, dexterity, intelligence);
  }
  public void levelUp(int strengthIncrease, int dexterityIncrease, int intelligenceIncrease) {
    baseAttributes.addToAttributes(strengthIncrease, dexterityIncrease, intelligenceIncrease);
    level += 1;
  }
  public void calculateTotal(){
    totalAttributes = baseAttributes;
    slots.forEach((slot, item) -> {
      if (item instanceof Armor)
        baseAttributes.addAttribute(((Armor) item).primaryAttribute);
    });
    System.out.println(totalAttributes.getStrength());
  }
  HashMap<EquipmentSlots, Item> slots = new HashMap<EquipmentSlots, Item>();
  public void Equipments(EquipmentSlots slot, Item item) {
    slots.put(slot, item);
    slots.get(slot);
  }
  public HashMap<EquipmentSlots, Item> getSlots() {
    return slots;
  }
  public String Display(){
    String display = name+ " "+ level + " " + baseAttributes.getStrength() + " " + baseAttributes.getDexterity() + " " + baseAttributes.getIntelligence();
    return display;
  }
  public float getWeaponDPS(){
    Weapon weapon = (Weapon)slots.get(EquipmentSlots.Weapon);
    if(weapon == null)return 0;
    return weapon.getDPS();
  }
  protected abstract float calculateDPS(float weaponDPS);

  public float getCharacterDPS(){
    return calculateDPS(getWeaponDPS());
  }
}
