package items.weapons;

import items.Item;
/*Child class that inherit from the class item.*/
public class Weapon extends Item  {

  private final float damage;
  private final float attackSpeed;
  private float dps;
  /*Constructor for Weapon.*/
  public Weapon(String weaponName, float damage, float attackSpeed, int requiredLevel, WeaponType weaponType) {
    super(weaponName);
    this.attackSpeed = attackSpeed;
    this.damage = damage;
    this.setRequiredLevel(requiredLevel);
    this.setWeaponType(weaponType);
    this.dps = damage * attackSpeed;
  }
/*Method that gets DPS for weapon. */
  public float getDPS() {
    return dps;
  }
}
