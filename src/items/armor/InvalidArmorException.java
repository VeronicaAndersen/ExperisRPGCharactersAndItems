package items.armor;

public class InvalidArmorException extends Exception {
  public InvalidArmorException(String message) {
    super(message);
    System.out.println(message);
  }
}