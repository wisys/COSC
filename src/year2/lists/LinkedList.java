package year2.lists;

public class LinkedList {

  public Node first, last, current;

//  public void addFirst(int item) {
//    this.first = new year2.elements.Node(item, this.first);
//  }
//
//  public void addLast(int item) {
//    if(first == null) {
//      first = new year2.elements.Node(item, null);
//      return;
//    }
//
//    year2.elements.Node current = this.first;
//    while(current.next != null)
//      current = current.next;
//
//    current.next = new year2.elements.Node(item, null);
//  }

  public void removeLast() {
    if(this.first == null) return;
    if(this.first.next == null) this.first = this.last = null;

    Node current = this.first;
    while(current.next != this.last)
      current = current.next;

    current.next = null;
    this.last = current;
  }

  public void removeSecond() { // Consider: Empty list, one node, two nodes, multiple nodes.
    if(this.first != null && this.first.next != null) {
      this.first.next = this.first.next.next;
      if(this.first.next == null) {
        this.last = this.first;
      }
    }
  }

  public void removeFirst() {
    if(this.first != null) {
      if(this.last == this.first) {
        this.first = null;
        this.last = null;
      } else {
        this.first = this.first.next;
      }
    }
  }

  public void addFirst(int item) {

    if(this.first == null) {
      this.first = new Node(item, null);
      this.last = this.first;
    } else {
      this.first = new Node(item, this.first);
    }
  }

  public void addLast(int item) {

    if(this.first == null) {
      this.first = this.last = new Node(item, null);
//      this.last = this.first;
      return;
    }

    this.last.next = this.last = new Node(item, null);
//    this.last = this.last.next;
  }

  public void print() {
    Node current = this.first;
    while(current != null) {
      System.out.println(current.item);
      current = current.next;
    }
  }

  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.addFirst(4);
    list.addLast(55);
    list.addFirst(7);
    list.addLast(524);
    list.print();
  }

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