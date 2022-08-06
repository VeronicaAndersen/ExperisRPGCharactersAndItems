package items.errors;

public class InvalidLevelException extends Exception{
  public InvalidLevelException(String message) {
    super(message);
    System.out.println(message);
  }
}
