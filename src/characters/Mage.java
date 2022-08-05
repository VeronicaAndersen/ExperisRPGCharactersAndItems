package characters;

import items.armor.ArmorType;
import items.weapons.WeaponType;

public class Mage extends Character {


  @Override
  public ArmorType[] getArmorList() {
    return armorList;
  }

  @Override
  public void setArmorList(ArmorType[] armorList) {
    this.armorList = armorList;
  }

  private WeaponType[] weaponList = {WeaponType.Staffs, WeaponType.Wands};
  private ArmorType[] armorList = {ArmorType.Cloth};
  public Mage(String name) {
    super(name, 1, 1, 8);
    setArmorList(armorList);
    setWeaponsList(weaponList);
  }

  public void levelUp() {
    levelUp(1, 1, 5);
  }



  @Override
  public float calculateDPS(float weaponDPS) {
    return weaponDPS * (1 + ((float) totalAttributes.getIntelligence() / 100));
  }


}
