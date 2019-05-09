package year2.queues;

import java.util.LinkedList;

/**
 * Professor: R. Escalante
 * Class:     COSC-1437
 * Semester:  Spring 2019
 * Date:      May 2nd, 2019
 * Purpose:   Array-based queue.
 *
 * @author    Johnathon Skidmore
 * @code      year2.queues.ArrayQueue.java
 * @since     2019-04-30
 */
public class ArrayQueue {
  
  private String[] array;
  private int front = 0, back = 0, size = 0;

  public ArrayQueue() {
    this.array = new String[50];
  }

  public ArrayQueue(int capacity) {
    this.array = new String[capacity];
  }
  
  public void enqueue(String item) {
    if(this.isFull())
      throw new RuntimeException("Stack is full.");
    
    this.size++;
    this.array[back] = item;
    this.back++;
    
    if(this.back == this.array.length) this.back = 0;
  }
  
  public String dequeue() {
    if(this.isEmpty())
      throw new RuntimeException("Stack is empty.");
    
    this.size--;
    String saved = this.array[front];
    this.front++;
    
    if(this.front == this.array.length) this.front = 0;
    return saved;
  }
  
  public String peek() {
    if(this.isEmpty())
      throw new RuntimeException("Stack is empty.");
    
    return array[front];
  }
  
  public void debug() {
    // Print the indices
    for(int i = 0; i < array.length; i++)
      System.out.printf("%4d ", i);

    System.out.println();
    // Print the array
    for(int i = 0; i < array.length; i++)
      System.out.printf("%4d|", array[i]);

    System.out.println();
    // Print location of front
    for(int i = 0; i < array.length; i++)
      System.out.printf("%4s ", front == i ? "f" : "");

    System.out.println();
    // Print location of back
    for(int i = 0; i < array.length; i++)
      System.out.printf("%4s ", back == i ? "b" : "");

    System.out.println();
  }
  
  public boolean isFull() { return this.size == this.array.length; }
  public boolean isEmpty() { return this.size == 0; }

  public String toString() {

      LinkedList<String> list = new LinkedList<>();
      int current = this.front;
      while (current != this.back) {
          list.add(this.array[current]);
          current++;
      }

      return list.toString();
  }
}
  