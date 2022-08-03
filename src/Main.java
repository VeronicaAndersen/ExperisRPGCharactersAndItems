
import characters.EquipmentSlots;
import characters.Mage;
import characters.PrimaryAttribute;
import items.Item;
import items.armor.Armor;
import items.weapons.Weapon;

public class Main {
  public static void main(String[] args) {
  Mage character = new Mage("Nemo");
  Item armor = new Armor("Ice cream", new PrimaryAttribute(5,2,8));
  Item weapon = new Weapon("Weapon hehe", 100);

  character.Equipments( EquipmentSlots.Head, armor);
  character.Equipments( EquipmentSlots.Weapon, weapon);
  System.out.println("Name: " + character.getName());
  System.out.println("Armor: " + character.getSlots().get(EquipmentSlots.Head).getName());
  System.out.println("Weapon: " + character.getSlots().get(EquipmentSlots.Weapon).getName());
  System.out.println(character.Display());
  character.calculateTotal();
  System.out.println(character.Display());
  System.out.println(character.getCharacterDPS());
  }
}
