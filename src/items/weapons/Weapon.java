package items.weapons;

import items.Item;
/*Child class that inherit from the class item.*/
public class Weapon extends Item  {
  private float dps;
  /*Constructor for Weapon.*/
  public Weapon(String weaponName, float dps, int requiredLevel, WeaponType weaponType) {
    super(weaponName);
    this.dps = dps;
    this.setRequiredLevel(requiredLevel);
    this.setWeaponType(weaponType);
  }
/*Method that gets DPS for weapon. */
  public float getDPS() {
    return dps;
  }
}
