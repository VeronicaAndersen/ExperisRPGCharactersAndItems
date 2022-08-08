package items.weapons;

import characters.EquipmentSlots;
import characters.Warrior;
import items.armor.Armor;
import items.armor.ArmorType;
import items.errors.InvalidArmorException;
import items.errors.InvalidLevelException;
import items.errors.InvalidWeaponException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class WeaponTest {
  @Test
  void TestEquipWeapon_TooLowLevel_ShouldThrowException() {
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
    assertEquals(weapon, warrior.getSlots().get(EquipmentSlots.Weapon));
  }

  @Test
  void TestEquip_NoWeaponEquip_ShouldReturnBaseDPS() {
    Warrior warrior = new Warrior("Nemo");
    float expected = warrior.getWeaponDPS();
    assertEquals(1 * (1 + (5 / 100)), expected);
  }

  @Test
  void TestEquip_WeaponEquip_ShouldReturnDPS() throws InvalidWeaponException, InvalidLevelException {
    Warrior warrior = new Warrior("Nemo");
    Weapon weapon = new Weapon("Common Axe", 7, 1, 1, WeaponType.Axes);
    warrior.equipWeapon(EquipmentSlots.Weapon, weapon);
    float expected = warrior.getCharacterDPS();
    assertEquals(7 * (1 + (5 / 100f)), expected);
  }

  @Test
  void TestEquip_WeaponAndArmorEquip_ShouldReturnDPS() throws InvalidWeaponException, InvalidLevelException, InvalidArmorException {
    Warrior warrior = new Warrior("Nemo");
    Weapon weapon = new Weapon("Common Axe", 7, 1.1f, 1, WeaponType.Axes);
    Armor armor = new Armor("A Random Armor Head", 1, 1, 1, 1, ArmorType.Mail);
    warrior.equipWeapon(EquipmentSlots.Weapon, weapon);
    warrior.equipArmor(EquipmentSlots.Head, armor);
    float expected = warrior.calculateDPS(warrior.getWeaponDPS());
    assertEquals((7 * 1.1f) * (1 + ((5f + 1f) / 100f)), expected);
  }
}