package items.weapons;

import items.Item;
/*Child class that inherit from the class item.*/
public class Weapon extends Item  {
  private float attackSpeed;
  private int damage;
  private float dps;
  /*Constructor for Weapon.*/
  public Weapon(String weaponName, int damage, float attackSpeed, int requiredLevel, WeaponType weaponType) {
    super(weaponName);
    this.damage = damage;
    this.attackSpeed = attackSpeed;
    this.setRequiredLevel(requiredLevel);
    this.setWeaponType(weaponType);
    dps = damage * attackSpeed;
  }
/*Method that gets DPS for weapon. */
  public float getDPS() {
    return dps;
  }
}
