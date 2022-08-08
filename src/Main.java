
import characters.EquipmentSlots;
import characters.Mage;
import characters.Ranger;
import characters.Warrior;
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

    Warrior rangerCharacter = new Warrior("Aladdin");

    Armor armor = new Armor("A Random Armor Body", 5, 1, 1, 1, ArmorType.Mail);
    rangerCharacter.equipArmor(EquipmentSlots.Body, armor);

    Weapon weapon = new Weapon("Common Hammer", 7, 1, 1, WeaponType.Hammers);
    rangerCharacter.equipWeapon(EquipmentSlots.Weapon, weapon);
//    weapon = new Weapon("Common Axe", 7, 1, 1, WeaponType.Axes);
//    rangerCharacter.equipWeapon(EquipmentSlots.Weapon, weapon);

    //rangerCharacter.levelUp();
    rangerCharacter.calculateTotal();

    System.out.println(rangerCharacter.display());
    System.out.println("\n" + rangerCharacter.displayEquipItems());

  }
}
