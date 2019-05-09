package year2.elements;

/**
 * Professor: R. Escalante
 * Class:     COSC-1437
 * Semester:  Spring 2019
 * Date:      May 2nd, 2019
 * Purpose:   year2.elements.Node object.
 *
 * @author    Johnathon Skidmore
 * @code      year2.elements.Node.java
 * @since     2019-04-30
 */
public class Node {
  
  public String item;
  public Node next;
  
  public Node(String item, Node next) {
    this.item = item;
    this.next = next;
  }
  
  public String toString() { return "[" + this.item + "]"; }
}