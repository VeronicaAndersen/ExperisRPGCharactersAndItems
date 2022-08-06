
import characters.EquipmentSlots;
import characters.Mage;
import characters.Ranger;
import items.armor.Armor;
import items.armor.ArmorType;
import items.weapons.Weapon;
import items.weapons.WeaponType;

public class Main {
  public static void main(String[] args) {
    Mage mageCharacter = new Mage("Nemo");
    Ranger rangerCharacter = new Ranger("Aladdin");
//    Armor armor = new Armor("A Random Armor", 1, 1, 1, 1, ArmorType.Cloth);
//    mageCharacter.Equipments(EquipmentSlots.Head, armor, mageCharacter.getArmorList());
    Armor armor2 = new Armor("A Random Name", 1, 1, 1, 1, ArmorType.Leather);
    rangerCharacter.Equipments(EquipmentSlots.Body, armor2, rangerCharacter.getArmorList());
//    Weapon weapon = new Weapon("A Random Weapon", 1, 1, WeaponType.Staffs);
//    weapon.setSlot(EquipmentSlots.Head);
//    System.out.println(weapon.getName());

    rangerCharacter.levelUp();
//    character.levelUp();

    //character.Equipments(EquipmentSlots.Head, weapon, character.getWeaponsList());

//    character.Equipments(EquipmentSlots.Weapon, weapon, character.getWeaponsList());
    //System.out.println("Armor: " + character.getSlots().get(EquipmentSlots.Head).getName());
    //System.out.println("Weapon: " + character.getSlots().get(EquipmentSlots.Weapon).getName());
    rangerCharacter.calculateTotal();
    System.out.println(rangerCharacter.display());
    rangerCharacter.getName();
    System.out.println(rangerCharacter.getCharacterDPS());
//    mageCharacter.calculateTotal();
//    System.out.println(mageCharacter.display());
//    character.calculateTotal();
//    System.out.println(character.getCharacterDPS());
//    System.out.println("Armors: " + Arrays.toString(character.getArmorList()));
//    System.out.println("Weapons: " + Arrays.toString(character.getWeaponsList()));
//    character.collectTotalAttributes();
  }
}
