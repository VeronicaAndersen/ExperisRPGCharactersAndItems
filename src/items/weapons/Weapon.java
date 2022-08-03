package items.weapons;

import items.Item;

public class Weapon extends Item  {
  private float dps;
  public Weapon(String weaponName, float dps) {
    super(weaponName);
    this.dps = dps;
  }
  public float getDPS() {
    return dps;
  }
}
