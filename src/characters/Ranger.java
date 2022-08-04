package characters;

import items.armor.Armor;
import items.armor.ArmorType;
import items.weapons.Weapon;
import items.weapons.WeaponType;

public class Ranger extends Character{
  private WeaponType[] weaponList = {WeaponType.Bows};
  private ArmorType[] armorList = {ArmorType.Leather, ArmorType.Mail};
  public Ranger (String name){
    super(name, 1, 7, 1);
    setArmorList(armorList);
    setWeaponsList(weaponList);
  }

  public void levelUp() {
    levelUp(1,5,1);
  }
  @Override
  public float calculateDPS(float weaponDPS) {
    return weaponDPS * (1 + ((float)totalAttributes.getDexterity()/100));
  }
}
