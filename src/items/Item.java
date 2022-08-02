package items;

public class Item {

  String name;
  int levelEquip;
  String slot;

  public String getName() {
    return name;
  }

  public Item(String weapon) {
    this.name = weapon;
  }
}
