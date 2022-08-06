
import characters.EquipmentSlots;
import characters.Mage;
import characters.Ranger;
import items.Item;
import items.armor.Armor;
import items.armor.ArmorType;
import items.weapons.Weapon;
import items.weapons.WeaponType;

import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    Mage mageCharacter = new Mage("Nemo");
    Ranger rangerCharacter = new Ranger("Aladdin");

    Armor armor2 = new Armor("A Random Armor Body", 1, 1, 1, 1, ArmorType.Leather);
    rangerCharacter.Equipments(EquipmentSlots.Body, armor2, rangerCharacter.getArmorList());

    armor2 = new Armor("A Random Armor Head", 1, 1, 1, 1, ArmorType.Leather);
    rangerCharacter.Equipments(EquipmentSlots.Head, armor2, rangerCharacter.getArmorList());
    armor2 = new Armor("A Random Armor Legs", 1, 1, 1, 1, ArmorType.Leather);
    rangerCharacter.Equipments(EquipmentSlots.Legs, armor2, rangerCharacter.getArmorList());

    Weapon weapon = new Weapon("A Random Weapon", 1, 1, WeaponType.Staffs);
    weapon.setSlot(EquipmentSlots.Head);
//    System.out.println(weapon.getName());

//    rangerCharacter.levelUp();

    //rangerCharacter.Equipments(EquipmentSlots.Head, weapon, character.getWeaponsList());

//    rangerCharacter.Equipments(EquipmentSlots.Weapon, weapon, character.getWeaponsList());

    //System.out.println("Weapon: " + rangerCharacter.getSlots().get(EquipmentSlots.Weapon).getName());
    rangerCharacter.calculateTotal();
    System.out.println(rangerCharacter.display());
    System.out.println(rangerCharacter.displayEquipItems());
//    System.out.println(rangerCharacter.getSlots());
//    rangerCharacter.getName();
//    System.out.println(rangerCharacter.getCharacterDPS());
//    System.out.println(rangerCharacter.displayEquipItems());

//    mageCharacter.calculateTotal();
//    System.out.println(mageCharacter.display());
//    character.calculateTotal();
//    System.out.println(character.getCharacterDPS());
//    System.out.println("\nARMOR: " + rangerCharacter.getSlots().get(EquipmentSlots.Body).getName());
//    System.out.println("Armors allowed items: " + Arrays.toString(rangerCharacter.getArmorList()));
//    System.out.println("Weapons: " + Arrays.toString(character.getWeaponsList()));
//    character.collectTotalAttributes();
  }
}
