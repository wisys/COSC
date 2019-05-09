package year2.elements;

public class StackException extends RuntimeException {
  public StackException(String s) { super(s); }
  public StackException() { super("Stack is empty."); }
}