package items.errors;
/*Class that inherited from exceptions that prints out error messages.*/
public class InvalidWeaponException extends Exception {
  public InvalidWeaponException(String message) {
    super(message);
    System.out.println(message);
  }
}
