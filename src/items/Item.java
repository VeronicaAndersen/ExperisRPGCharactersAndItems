package items;

public class Item {

  private String name;
  private int requiredLevel;
  private String slot;
  public String getName() {
    return name;
  }
  public Item(String itemName) {
    this.name = itemName;
  }
}
