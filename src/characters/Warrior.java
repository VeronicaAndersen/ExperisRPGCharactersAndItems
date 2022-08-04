package characters;

import items.armor.ArmorType;
import items.weapons.WeaponType;

public class Warrior extends Character {
  private WeaponType[] weaponList = {WeaponType.Axes, WeaponType.Hammers, WeaponType.Swords};
  private ArmorType[] armorList = {ArmorType.Mail, ArmorType.Plate};
  public Warrior (String name){
    super(name, 5, 2, 1);
    setArmorList(armorList);
    setWeaponsList(weaponList);
  }
  public void levelUp() {
    levelUp(3,2,1);
  }
  @Override
  public float calculateDPS(float weaponDPS) {
    return weaponDPS * (1 + ((float)totalAttributes.getStrength()/100));
  }
}
