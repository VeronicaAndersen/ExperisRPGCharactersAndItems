package characters;

import items.Item;

import java.util.HashMap;

public class Character {
    String name;
    int level = 1;
    PrimaryAttribute baseAttributes = new PrimaryAttribute();     //Attributes of the character
    public Character(String name, int strength, int intelligence, int dexterity ) {
        this.name = name;
        baseAttributes.addToAttributes(strength, dexterity, intelligence);
    }
    public void levelUp(int strengthIncrease, int dexterityIncrease, int intelligenceIncrease) {
        baseAttributes.addToAttributes(strengthIncrease, dexterityIncrease, intelligenceIncrease);
        level += 1;
    }


    HashMap<EquipmentSlots, Item> slots = new HashMap<EquipmentSlots, Item>();
    public void Equipments(EquipmentSlots slot, Item item) {
        slots.put(slot, item);
        slots.get(slot);
    }

    public HashMap<EquipmentSlots, Item> getSlots(){
        return slots;
    }
}
