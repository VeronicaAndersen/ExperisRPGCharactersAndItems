import characters.Character;
import characters.EquipmentSlots;
import characters.Mage;
import items.Item;

public class Main {
  public static void main(String[] args) {
  Character charater = new Character("Nemo", 1,1,1);
  Item weapon = new Item("glass");

  charater.Equipments( EquipmentSlots.Weapon, weapon);
  System.out.println(charater.getSlots().get(EquipmentSlots.Weapon).getName());
  }
}
