package items.armor;

import characters.EquipmentSlots;
import characters.Ranger;
import characters.Warrior;
import items.errors.InvalidArmorException;
import items.errors.InvalidLevelException;
import items.errors.InvalidWeaponException;
import items.weapons.Weapon;
import items.weapons.WeaponType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArmorTest {
  /*_________________________________ TEST EQUIP ITEMS. _______________________________*/
  @Test
  void TestEquipArmor_TooLowLevel_ShouldThrowException()  {
    Ranger ranger = new Ranger("Gizmo");
    Armor armor = new Armor("Something", 1, 2, 3, 8, ArmorType.Mail);

    assertThrows(InvalidLevelException.class, () -> ranger.checkLevel(armor));
  }
  @Test
  void TestEquipArmor_WrongArmorType_ShouldThrowException() {
    Ranger ranger = new Ranger("Gizmo");
    Armor armor = new Armor("A Random Armor Head", 1, 1, 1, 1, ArmorType.Plate);

    assertThrows(InvalidArmorException.class, () -> ranger.equipArmor(EquipmentSlots.Body, armor));
  }

  @Test
  void TestEquip_RightArmorType_ShouldEquip() throws InvalidArmorException, InvalidLevelException {
    Ranger ranger = new Ranger("Gizmo");
    Armor armor = new Armor("A Random Armor Head", 1, 1, 1, 1, ArmorType.Leather);
    ranger.equipArmor(EquipmentSlots.Head, armor);
  }



}