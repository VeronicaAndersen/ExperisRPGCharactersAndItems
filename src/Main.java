
import characters.EquipmentSlots;
import characters.Mage;
import characters.Ranger;
import items.Item;
import items.armor.Armor;
import items.armor.ArmorType;
import items.errors.InvalidArmorException;
import items.errors.InvalidLevelException;
import items.errors.InvalidWeaponException;
import items.weapons.Weapon;
import items.weapons.WeaponType;

import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws InvalidArmorException, InvalidWeaponException, InvalidLevelException {

    Ranger rangerCharacter = new Ranger("Aladdin");

    Armor armor = new Armor("A Random Armor Body", 1, 1, 1, 1, ArmorType.Leather);
    rangerCharacter.equipArmor(EquipmentSlots.Body, armor);

    Weapon weapon = new Weapon("A Random Weapon", 1, 1, 1, WeaponType.Bows);
    rangerCharacter.equipWeapon(EquipmentSlots.Weapon, weapon);

    rangerCharacter.levelUp();
    rangerCharacter.calculateTotal();

    System.out.println(rangerCharacter.display());

  }
}
