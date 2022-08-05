package items.weapons;

import items.Item;

public class Weapon extends Item  {
  private float dps;
  public Weapon(String weaponName, float dps, int requiredLevel) {
    super(weaponName);
    this.dps = dps;
    this.setRequiredLevel(requiredLevel);
  }
  public float getDPS() {
    return dps;
  }
}
