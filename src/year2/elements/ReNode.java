package year2.elements;

public class ReNode {
  
  public int item;
  public Node next, prev;
  
  public ReNode(int item, Node next, Node prev) {
    this.item = item;
    this.next = next;
    this.prev = prev;
  }
  
  public String toString() { return "[" + this.item + "]"; }
}