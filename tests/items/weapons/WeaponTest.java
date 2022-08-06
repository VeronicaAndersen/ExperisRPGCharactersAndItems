package items.weapons;

import characters.EquipmentSlots;
import characters.Ranger;
import characters.Warrior;
import items.armor.Armor;
import items.armor.ArmorType;
import items.errors.InvalidArmorException;
import items.errors.InvalidLevelException;
import items.errors.InvalidWeaponException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {
  @Test
  void TestEquipWeapon_TooLowLevel_ShouldThrowException()  {
    Ranger ranger = new Ranger("Gizmo");
    Weapon armor = new Weapon("Something", 1, 2, 10, WeaponType.Wands);

    assertThrows(InvalidLevelException.class, () -> ranger.checkLevel(armor));
  }
  @Test
  void TestEquipWeapon_WrongWeaponType_ShouldThrowException() {
    Ranger ranger = new Ranger("Gizmo");
    Weapon weapon = new Weapon("A Random Weapon", 1, 1, 1, WeaponType.Hammers);

    assertThrows(InvalidWeaponException.class, () -> ranger.equipWeapon(EquipmentSlots.Weapon, weapon));
  }

  @Test
  void TestEquip_RightWeaponType_ShouldEquip() throws InvalidLevelException, InvalidWeaponException {
    Weapon weapon = new Weapon("Something", 1, 2, 1, WeaponType.Axes);
    Warrior warrior = new Warrior("Bob");

    warrior.equipWeapon(EquipmentSlots.Weapon, weapon);
  }
}