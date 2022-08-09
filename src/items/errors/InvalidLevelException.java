package items.errors;

/*Class that inherited from exceptions that prints out error messages.*/
public class InvalidLevelException extends Exception {
  public InvalidLevelException(String message) {
    super(message);
    System.out.println(message);
  }
}
