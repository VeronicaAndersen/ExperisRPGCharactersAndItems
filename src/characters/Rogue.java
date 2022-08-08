package characters;

import items.armor.ArmorType;
import items.weapons.WeaponType;

/*Child class to character class. */
public class Rogue extends Character {
  private WeaponType[] weaponList = {WeaponType.Daggers, WeaponType.Swords};
  private ArmorType[] armorList = {ArmorType.Leather, ArmorType.Mail};

  /*Constructor that sets both armor and weapon list.*/
  public Rogue(String name) {
    super(name, 2, 6, 1);
    setArmorList(armorList);
    setWeaponsList(weaponList);
  }

  /*Method that increase attributes of a character by a given amount.*/
  public void levelUp() {
    levelUp(1, 4, 1);
  }

  /*Method that calculateDPS for the weapons.*/
  @Override
  public float calculateDPS(float weaponDPS) {
    return weaponDPS * (1 + ((float) totalAttributes.getDexterity() / 100));
  }

  /*Method that get & sets the list of armorlist.*/
  @Override
  public ArmorType[] getArmorList() {
    return armorList;
  }

  @Override
  public void setArmorList(ArmorType[] armorList) {
    this.armorList = armorList;
  }
}