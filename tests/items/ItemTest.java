package items;

import characters.EquipmentSlots;
import characters.Ranger;
import characters.Warrior;
import items.armor.Armor;
import items.armor.ArmorType;
import items.errors.InvalidArmorException;
import items.errors.InvalidLevelException;
import items.errors.InvalidWeaponException;
import items.weapons.Weapon;
import items.weapons.WeaponType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
  /*_________________________________ TEST EQUIP ITEMS ARMOR. _______________________________*/
  @Test
  void TestEquipArmor_TooLowLevel_ShouldThrowException() {
    Warrior warrior = new Warrior("Gizmo");
    Armor armor = new Armor("Ballistic Protection", 1, 2, 3, 2, ArmorType.Plate);

    assertThrows(InvalidLevelException.class, () -> warrior.checkLevel(armor));
  }

  @Test
  void TestEquipArmor_OkLevel_ShouldEquip() throws InvalidArmorException, InvalidLevelException {
    Warrior warrior = new Warrior("Gizmo");
    Armor armor = new Armor("Ballistic Protection", 1, 2, 3, 1, ArmorType.Mail);

    warrior.equipArmor(EquipmentSlots.Head, armor);
    assertEquals(armor, warrior.getSlots().get(EquipmentSlots.Head));
  }

  @Test
  void TestEquipArmor_WrongArmorType_ShouldThrowException() {
    Warrior warrior = new Warrior("Gizmo");
    Armor armor = new Armor("Common Cloth", 1, 2, 3, 1, ArmorType.Cloth);

    assertThrows(InvalidArmorException.class, () -> warrior.equipArmor(EquipmentSlots.Body, armor));
  }

  @Test
  void TestEquip_RightArmorType_ShouldEquip() throws InvalidArmorException, InvalidLevelException {
    Ranger ranger = new Ranger("Gizmo");
    Armor armor = new Armor("A Random Armor Head", 1, 1, 1, 1, ArmorType.Leather);
    ranger.equipArmor(EquipmentSlots.Head, armor);
  }

  /*_________________________________ TEST EQUIP ITEMS WEAPON. _______________________________*/
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

  /*_________________________________ TEST EQUIP ITEMS ARMOR & WEAPON. _______________________________*/
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