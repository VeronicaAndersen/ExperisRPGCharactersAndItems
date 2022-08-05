package items.weapons;

public class InvalidWeaponException extends Exception {
  public InvalidWeaponException(String message) {
    super(message);
    System.out.println(message);
  }
}
