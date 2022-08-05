package items.weapons;

import items.Item;

public class Weapon extends Item  {
  private float dps;
  public Weapon(String weaponName, float dps, int requiredLevel, WeaponType weaponType) {
    super(weaponName);
    this.dps = dps;
    this.setRequiredLevel(requiredLevel);
    this.setWeaponType(weaponType);
  }

  public float getDPS() {
    return dps;
  }
}
