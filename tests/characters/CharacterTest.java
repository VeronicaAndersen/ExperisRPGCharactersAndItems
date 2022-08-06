package characters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {
  @Test
  void TestLevelUp_Mage_ShouldIncreaseLevel() {
    Mage character = new Mage("Aladdin");
    character.levelUp();
    character.getLevel();

    assertEquals(2, character.getLevel());
  }

}