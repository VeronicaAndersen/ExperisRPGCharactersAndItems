package items.armor;

import characters.EquipmentSlots;
import characters.Ranger;
import characters.Warrior;
import items.errors.InvalidArmorException;
import items.errors.InvalidLevelException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArmorTest {
  /*_________________________________ TEST EQUIP ITEMS. _______________________________*/
  @Test
  void TestEquipArmor_TooLowLevel_ShouldThrowException()  {
    Warrior warrior = new Warrior("Gizmo");
    Armor armor = new Armor("Ballistic Protection", 1, 2, 3, 2, ArmorType.Plate);

    assertThrows(InvalidLevelException.class, () -> warrior.checkLevel(armor));
  }
  @Test
  void TestEquipArmor_OkLevel_ShouldEquip() throws InvalidArmorException, InvalidLevelException {
    Warrior warrior = new Warrior("Gizmo");
    Armor armor = new Armor("Ballistic Protection", 1, 2, 3, 1, ArmorType.Mail);

    warrior.equipArmor(EquipmentSlots.Head, armor);
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



}