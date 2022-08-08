package characters;

import items.armor.ArmorType;
import items.weapons.WeaponType;

/*Child class to character class. */
public class Warrior extends Character {
  private WeaponType[] weaponList = {WeaponType.Axes, WeaponType.Hammers, WeaponType.Swords};
  private ArmorType[] armorList = {ArmorType.Mail, ArmorType.Plate};

  /*Constructor that sets both armor and weapon list.*/
  public Warrior(String name) {
    super(name, 5, 2, 1);
    setArmorList(armorList);
    setWeaponsList(weaponList);
  }

  public void levelUp() {
    levelUp(3, 2, 1);
  }

  /*Method that calculateDPS for the weapons.*/
  @Override
  public float calculateDPS(float weaponDPS) {
    return weaponDPS * (1 + ((float) totalAttributes.getStrength() / 100));
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