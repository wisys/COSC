package year2.stack;

import year2.elements.StackException;

public class LLStack {

  private Node first = null;
  private int size = 0;

  public void push(int item) {
    first = new Node(item, first);
    this.size++;
  }

  public int pop() {
    if(this.isEmpty()) throw new StackException();

    int saved = first.item;
    this.size--;
    first = first.next;
    return saved;
  }

  public int peek() {
    if(this.isEmpty()) throw new StackException();

    return first.item;
  }
  public boolean isEmpty() { return first == null; }
  public int size() { return this.size; }

  public static class Node {

    public int item;
    public Node next;

    public Node(int item, Node next) {
      this.item = item;
      this.next = next;
    }

    public String toString() { return "[" + this.item + "]"; }
  }
}