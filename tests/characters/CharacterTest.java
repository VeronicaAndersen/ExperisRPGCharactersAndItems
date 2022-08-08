package characters;

import items.armor.Armor;
import items.armor.ArmorType;
import items.errors.InvalidArmorException;
import items.errors.InvalidLevelException;
import items.errors.InvalidWeaponException;
import items.weapons.Weapon;
import items.weapons.WeaponType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {
  /*_________________________________ TEST LEVEL 1. _______________________________*/
  @Test
  void TestLevel_Mage_ShouldBeLevelOne() {
    Mage mageCharacter = new Mage("Aladdin");

    assertEquals(1, mageCharacter.getLevel());
  }


  /*_________________________________ TEST BASE ATTRIBUTES. _______________________________*/
  @Test
  void TestLevelUp_Mage_ShouldShowBaseAttributes() {
    Mage mageCharacter = new Mage("Aladdin");

    assertEquals(1, mageCharacter.baseAttributes.getStrength());
    assertEquals(1, mageCharacter.baseAttributes.getDexterity());
    assertEquals(8, mageCharacter.baseAttributes.getIntelligence());
  }

  @Test
  void TestLevelUp_Ranger_ShouldShowBaseAttributes() {
    Ranger rangeCharacter = new Ranger("Aladdin");

    assertEquals(1, rangeCharacter.baseAttributes.getStrength());
    assertEquals(7, rangeCharacter.baseAttributes.getDexterity());
    assertEquals(1, rangeCharacter.baseAttributes.getIntelligence());
  }

  @Test
  void TestLevelUp_Rogue_ShouldShowBaseAttributes() {
    Rogue rogueCharacter = new Rogue("Aladdin");

    assertEquals(2, rogueCharacter.baseAttributes.getStrength());
    assertEquals(6, rogueCharacter.baseAttributes.getDexterity());
    assertEquals(1, rogueCharacter.baseAttributes.getIntelligence());
  }

  @Test
  void TestLevelUp_Warrior_ShouldShowBaseAttributes() {
    Warrior warriorCharacter = new Warrior("Aladdin");

    assertEquals(5, warriorCharacter.baseAttributes.getStrength());
    assertEquals(2, warriorCharacter.baseAttributes.getDexterity());
    assertEquals(1, warriorCharacter.baseAttributes.getIntelligence());
  }


  /*_________________________________ TEST LEVEL UP & ATTRIBUTES. _______________________________*/


  @Test
  void TestLevelUp_Mage_ShouldIncreaseLevelAndAttributes() {
    Mage mageCharacter = new Mage("Aladdin");
    mageCharacter.levelUp();

    assertEquals(2, mageCharacter.getLevel());
    assertEquals(2, mageCharacter.totalAttributes.getStrength());
    assertEquals(2, mageCharacter.totalAttributes.getDexterity());
    assertEquals(13, mageCharacter.totalAttributes.getIntelligence());
  }

  @Test
  void TestLevelUp_Ranger_ShouldIncreaseLevelAndAttributes() {
    Ranger rangeCharacter = new Ranger("Aladdin");
    rangeCharacter.levelUp();

    assertEquals(2, rangeCharacter.getLevel());
    assertEquals(2, rangeCharacter.totalAttributes.getStrength());
    assertEquals(12, rangeCharacter.totalAttributes.getDexterity());
    assertEquals(2, rangeCharacter.totalAttributes.getIntelligence());
  }

  @Test
  void TestLevelUp_Rogue_ShouldIncreaseLevelAndAttributes() {
    Rogue rogueCharacter = new Rogue("Aladdin");
    rogueCharacter.levelUp();

    assertEquals(2, rogueCharacter.getLevel());
    assertEquals(3, rogueCharacter.totalAttributes.getStrength());
    assertEquals(10, rogueCharacter.totalAttributes.getDexterity());
    assertEquals(2, rogueCharacter.totalAttributes.getIntelligence());
  }

  @Test
  void TestLevelUp_Warrior_ShouldIncreaseLevelAndAttributes() {
    Warrior warriorCharacter = new Warrior("Aladdin");
    warriorCharacter.levelUp();

    assertEquals(2, warriorCharacter.getLevel());
    assertEquals(8, warriorCharacter.totalAttributes.getStrength());
    assertEquals(4, warriorCharacter.totalAttributes.getDexterity());
    assertEquals(2, warriorCharacter.totalAttributes.getIntelligence());
  }

}