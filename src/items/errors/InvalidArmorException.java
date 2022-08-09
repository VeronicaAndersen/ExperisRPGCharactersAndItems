package items.errors;

/*Class that inherited from exceptions that prints out error messages.*/
public class InvalidArmorException extends Exception {
  public InvalidArmorException(String message) {
    super(message);
    System.out.println(message);
  }
}