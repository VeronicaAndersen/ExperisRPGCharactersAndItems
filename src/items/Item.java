package items;

import characters.EquipmentSlots;

public class Item {

  private String name;
  private int requiredLevel;
  private EquipmentSlots slot;
  public String getName() {
    return name;
  }
  public Item(String itemName) {
    this.name = itemName;
  }

  public int getRequiredLevel() {
    return requiredLevel;
  }

  public void setRequiredLevel(int requiredLevel) {
    this.requiredLevel = requiredLevel;
  }

  public EquipmentSlots getSlot() {
    return slot;
  }

  public void setSlot(EquipmentSlots slot) {
    this.slot = slot;
  }

}
