package year2.queues;

import year2.elements.Node;

import java.util.LinkedList;

/**
 * Professor: R. Escalante
 * Class:     COSC-1437
 * Semester:  Spring 2019
 * Date:      May 2nd, 2019
 * Purpose:   year2.lists.LinkedList-based queue.
 *
 * @author    Johnathon Skidmore
 * @code      year2.queues.LLQueue.java
 * @since     2019-04-30
 */
public class LLQueue {
  private Node first = null, last = null;
  private int size = 0;
  
  public void enqueue(String item) { // addLast
    if(isEmpty()) first = last = new Node(item, null); else {
      last.next = new Node(item, null);
      last = last.next;
    }
    
    size++;
  } 
  
  public String dequeue() { // removeFirst
    if(isEmpty()) 
      throw new RuntimeException("Queue is empty");

    String saved = first.item;
    first = first.next;
    if(this.first == null)
      this.last = null;
    size--;
    return saved;
  }
  
  public String peek() {
    if(isEmpty()) {
      throw new RuntimeException("Queue is empty");
    }
    
    return first.item;
  }
  
  public boolean isEmpty() { return first == null; }
  public int size() { return size; }

  public String toString() {

    LinkedList<String> list = new LinkedList<>();
    Node current = this.first;
    while (current != null) {
      list.add(current.item);
      current = current.next;
    }

    return list.toString();
  }
}