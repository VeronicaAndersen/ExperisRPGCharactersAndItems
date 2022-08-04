package characters;

import items.armor.ArmorType;
import items.weapons.WeaponType;

import java.util.ArrayList;

public class Rogue extends Character{
  private WeaponType[] weaponList = {WeaponType.Daggers, WeaponType.Swords};
  private ArmorType[] armorList = {ArmorType.Leather, ArmorType.Mail};

  public Rogue (String name){
    super(name, 2, 6, 1);
    setArmorList(armorList);
    setWeaponsList(weaponList);
  }
  public void levelUp() {
    levelUp(1,4,1);
  }
  @Override
  public float calculateDPS(float weaponDPS) {
    return weaponDPS * (1 + (float)totalAttributes.getDexterity()/100);
  }
}
