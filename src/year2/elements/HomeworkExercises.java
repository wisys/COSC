package year2.elements;// Complete the following 11 exercises
/**
 * Professor: R. Escalante
 * Class:     COSC-1437
 * Semester:  Spring 2019
 * Date:      April 2nd, 2019
 * Purpose:   Sequential year2.elements.Node accessing
 *
 * @author    Johnathon Skidmore
 * @code      year2.elements.HomeworkExercises.java
 * @since     2019-04-02
 */
public class HomeworkExercises
{
  public static void main(String[] args) {
    
    // Create a list containing 7 and 14.
    Node first = new Node(7, new Node(14, null));
    
    // In-Class Exercise 1:
    // Add a node containing 20 to the end of the list.
    // Your code here:
    first.next.next = new Node(20, null);
    
    
    // In-Class Exercise 2:
    // Remove the node containing 14. Your program
    // should print 7 and 20.
    first.next = first.next.next;
    
    
    // In-Class Exercise 3:
    // Add 3 to the beginning of the list.
    //  hint:  first = new year2.elements.Node(3, ??? )
    first = new Node(3, first);
    
    
    
    // ---------------- EXERCISES ------------------
    // The list at this point contains 3, 7, and 20.
    // ---------------------------------------------
    
    // Homework Exercise 1:
    // Add 9 as the second element in the list.
    // Your list should contain 3, 9, 7, 20 aftwerwards.
    // Your code here:
    first.next = new Node(9, first.next);

    // Homework Exercise 2:
    // Remove 20 from the end of the list.
    // Your list should contain 3, 9, 7 afterwards.
    // Your code here:
    first.next.next.next = null;
    
    // Homework Exercise 3:
    // Remove the first element from the list.
    // Your list should contain 9, 7 afterwards.
    // Your code here:
    first = first.next;
    
    // Homework Exercise 4:
    // Add the year2.elements 10, 20, and 30 between 9 and 7.
    // Your list should contain 9, 10, 20, 30, 7 afterwards.
    // Your code here:
    first.next = new Node(10, new Node(20, new Node(30, first.next)));
    
    // Homework Exercise 5:
    // Without creating or removing any nodes, copy the fourth node's item (30)
    // into the second node's item (replacing 10).
    // Your list should contain 9, 30, 20, 30, 7 afterwards.
    // Your code here:
    first.next.item = first.next.next.next.item;
    
    // Homework Exercise 6:
    // Remove the last two year2.elements of the list with a single line of code.
    // Your list should contain 9, 30, 20 afterwards.
    // Your code here:
    first.next.next.next = null;
    
    // Homework Exercise 7:
    // Replace all of the year2.elements of the previous list with a list containing 1, 2, 3, and 4.
    // Your list should contain 1, 2, 3, 4 afterwards.
    // Your code here:
    first = new Node(1, new Node(2, new Node(3, new Node(4, null))));
    
    // Homework Exercise 8:
    // Remove 2 and 3 from the previous list.
    // Your list should contain 1, 4 afterwards.
    // Your code here:
    first.next = first.next.next.next;

    // Homework Exercise 9:
    // Add 0 to the beginning of the list.
    // Your list should contain 0, 1, 4 afterwards.
    // Your code here:
    first = new Node(0, first);
    
    // Homework Exercise 10:
    // Add -1 to the beginning of the list.
    // Your list should contain -1, 0, 1, 4 afterwards.
    // Your code here:
    first = new Node(-1, first);

    // Homework Exercise 11:
    // Remove all year2.elements from the list.
    // Your list should be empty afterwards.
    // Your code here:
    first = null;
    
    // --- Do not change anything below this line ---
    // Call the printList method to print the list
    printList(first);
  }
  
  // The code below prints all the year2.elements in
  // the linked list (please ignore it for now).
  public static void printList(Node n) {
    for(Node c = n; c != null; c = c.next)
      System.out.println(c.item);
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