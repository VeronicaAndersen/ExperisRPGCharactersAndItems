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
  /*_________________________________ TEST LEVEL UP & ATTRIBUTES. _______________________________*/
  @Test
  void TestLevelUp_Mage_ShouldIncreaseAttributes() {
    Mage mageCharacter = new Mage("Aladdin");
    mageCharacter.levelUp();
    PrimaryAttribute attributes = new PrimaryAttribute();
    attributes.addToAttributes(2,2,13);

    assertEquals(2, mageCharacter.getLevel());
    assertEquals(attributes.getStrength(), mageCharacter.baseAttributes.getStrength());
    assertEquals(attributes.getDexterity(), mageCharacter.baseAttributes.getDexterity());
    assertEquals(attributes.getIntelligence(), mageCharacter.baseAttributes.getIntelligence());
  }
  @Test
  void TestLevelUp_Ranger_ShouldIncreaseAttributes() {
    Ranger rangeCharacter = new Ranger("Aladdin");
    rangeCharacter.levelUp();
    PrimaryAttribute attributes = new PrimaryAttribute();
    attributes.addToAttributes(2,12,2);

    assertEquals(2, rangeCharacter.getLevel());
    assertEquals(attributes.getStrength(), rangeCharacter.baseAttributes.getStrength());
    assertEquals(attributes.getDexterity(), rangeCharacter.baseAttributes.getDexterity());
    assertEquals(attributes.getIntelligence(), rangeCharacter.baseAttributes.getIntelligence());
  }
  @Test
  void TestLevelUp_Rogue_ShouldIncreaseAttributes() {
    Rogue rogueCharacter = new Rogue("Aladdin");
    rogueCharacter.levelUp();
    PrimaryAttribute attributes = new PrimaryAttribute();
    attributes.addToAttributes(3,10,2);

    assertEquals(2, rogueCharacter.getLevel());
    assertEquals(attributes.getStrength(), rogueCharacter.baseAttributes.getStrength());
    assertEquals(attributes.getDexterity(), rogueCharacter.baseAttributes.getDexterity());
    assertEquals(attributes.getIntelligence(), rogueCharacter.baseAttributes.getIntelligence());
  }
  @Test
  void TestLevelUp_Warrior_ShouldIncreaseAttributes() {
    Warrior warriorCharacter = new Warrior("Aladdin");
    warriorCharacter.levelUp();
    PrimaryAttribute attributes = new PrimaryAttribute();
    attributes.addToAttributes(8,4,2);

    assertEquals(2, warriorCharacter.getLevel());
    assertEquals(attributes.getStrength(), warriorCharacter.baseAttributes.getStrength());
    assertEquals(attributes.getDexterity(), warriorCharacter.baseAttributes.getDexterity());
    assertEquals(attributes.getIntelligence(), warriorCharacter.baseAttributes.getIntelligence());
  }

}