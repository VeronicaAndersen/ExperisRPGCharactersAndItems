package characters;

import items.Item;
import items.armor.Armor;
import items.armor.ArmorType;
import items.armor.InvalidArmorException;
import items.weapons.InvalidWeaponException;
import items.weapons.Weapon;
import items.weapons.WeaponType;

public class Mage extends Character {
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

  /*public void Equipments(Weapon weapon)  {
    if(level >= weapon.getRequiredLevel()){

    }
  }
  public void Equipments(Armor armor) {
    if(level >= armor.getRequiredLevel()){

    }
  }*/
}
