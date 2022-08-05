
import characters.EquipmentSlots;
import characters.Mage;
import characters.Ranger;
import characters.PrimaryAttribute;
import items.Item;
import items.armor.Armor;
import items.armor.ArmorType;
import items.weapons.Weapon;
import items.weapons.WeaponType;

import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    Mage character = new Mage("Nemo");
    Armor armor = new Armor("A Random Name", 6, 6, 0, 0, ArmorType.Leather);
    Armor armor2 = new Armor("A Random Name", 7, 6, 0, 0, ArmorType.Cloth);
    Weapon weapon = new Weapon("A Random Name", 100, 1, WeaponType.Staffs);
    //weapon.setSlot(EquipmentSlots.Head);

    character.levelUp();

    //character.Equipments(EquipmentSlots.Head, weapon, character.getWeaponsList());
    character.Equipments(EquipmentSlots.Head, armor, character.getArmorList());
    character.Equipments(EquipmentSlots.Body, armor2, character.getArmorList());
    character.Equipments(EquipmentSlots.Body, weapon, character.getWeaponsList());
    //System.out.println("Armor: " + character.getSlots().get(EquipmentSlots.Head).getName());
    //System.out.println("Weapon: " + character.getSlots().get(EquipmentSlots.Weapon).getName());

    System.out.println(character.display());
    character.calculateTotal();
    //System.out.println(character.getCharacterDPS());
//    System.out.println("Armors: " + Arrays.toString(character.getArmorList()));
//    System.out.println("Weapons: " + Arrays.toString(character.getWeaponsList()));
    character.collectTotalAttributes();
  }
}
