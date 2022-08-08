package items.weapons;

import characters.EquipmentSlots;
import characters.Warrior;
import items.errors.InvalidLevelException;
import items.errors.InvalidWeaponException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {
  @Test
  void TestEquipWeapon_TooLowLevel_ShouldThrowException()  {
    Warrior warrior = new Warrior("Gizmo");
    Weapon armor = new Weapon("Common Axe", 1, 2, 2, WeaponType.Axes);

    assertThrows(InvalidLevelException.class, () -> warrior.checkLevel(armor));
  }
  @Test
  void TestEquipWeapon_WrongWeaponType_ShouldThrowException() {
    Warrior warrior = new Warrior("Gizmo");
    Weapon weapon = new Weapon("Common Bow", 1, 1, 1, WeaponType.Bows);

    assertThrows(InvalidWeaponException.class, () -> warrior.equipWeapon(EquipmentSlots.Weapon, weapon));
  }

  @Test
  void TestEquip_RightWeaponType_ShouldEquip() throws InvalidLevelException, InvalidWeaponException {
    Warrior warrior = new Warrior("Nemo");
    Weapon weapon = new Weapon("Common Axe", 1, 2, 1, WeaponType.Axes);

    warrior.equipWeapon(EquipmentSlots.Weapon, weapon);
  }
  @Test
  void TestEquip_NoWeaponEquip_ShouldReturnBaseDPS() {
    Warrior warrior = new Warrior("Nemo");
    float expected = warrior.getWeaponDPS();
    assertEquals(expected, 1*(1 + (5 / 100f)));
  }
  @Test
  void TestEquip_WeaponEquip_ShouldReturnDPS() throws InvalidWeaponException, InvalidLevelException {
    Warrior warrior = new Warrior("Nemo");
    Weapon weapon = new Weapon("Common Axe", 7, 1, 1, WeaponType.Axes);
    warrior.equipWeapon(EquipmentSlots.Weapon, weapon);
    float expected = warrior.getWeaponDPS();
    assertEquals(expected, warrior.getWeaponDPS()*(1 + (5 / 100f)));
  }
}