
import characters.EquipmentSlots;
import characters.Mage;
import characters.Ranger;
import characters.PrimaryAttribute;
import items.Item;
import items.armor.Armor;
import items.weapons.Weapon;

import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    Mage character = new Mage("Nemo");
    Item armor = new Armor("Ice cream", new PrimaryAttribute(0, 6, 0));
    Item weapon = new Weapon("Weapon hehe", 100, 1);
    weapon.setSlot(EquipmentSlots.Head);
    character.levelUp();
    //character.Equipments(EquipmentSlots.Head, armor);
    character.Equipments(EquipmentSlots.Weapon, weapon, character.getWeaponsList());
    //System.out.println("Armor: " + character.getSlots().get(EquipmentSlots.Head).getName());
    System.out.println("Weapon: " + character.getSlots().get(EquipmentSlots.Weapon).getName());

    System.out.println(character.display());
    character.calculateTotal();
    System.out.println(character.getCharacterDPS());
    System.out.println("Armors: " + Arrays.toString(character.getArmorList()));
    System.out.println("Weapons: " + Arrays.toString(character.getWeaponsList()));
  }
}
