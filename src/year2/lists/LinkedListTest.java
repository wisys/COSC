package year2.lists;

import org.junit.*;
import static org.junit.Assert.*;

public class LinkedListTest {

  LinkedList list = new LinkedList();

  @Before
  public void setup() {
    list.addLast(1);
    list.addLast(2);
    list.addLast(3);
  }

  @Test
  public void testRemoveFirstOnAThreeNodeList() {
    list.removeFirst();
    // Now, 2 should be the first node and 3 should
    // be the last node.
    assertEquals(list.first.item, 2);
    assertEquals(list.last.item, 3);
  }

  @Test
  public void testRemoveFirstOnAOneNodeList() {
    list.removeFirst();
    list.removeFirst();
    // At this point, list only has one element.
    list.removeFirst();
    // Now, first and last should be null
    assertEquals(list.first, null);
    assertEquals(list.last, null);
  }

  @Test
  public void testRemoveSecondOnAThreeNodeList() {
    list.removeSecond();
    // At this point, 1 should be the first node
    // and 3 should be the last node.
    assertEquals(list.first.item, 1);
    assertEquals(list.first.next.item, 3);
    assertEquals(list.last.item, 3);
  }

  @Test
  public void testRemoveSecondOnAOneNodeList() {
    list.removeFirst();
    list.removeFirst();
    // Now, we have only one node
    list.removeSecond(); // Should do nothing
    assertEquals(list.first.item, 3);
    assertEquals(list.last.item, 3);
  }

  @Test
  public void testRemoveSecondOnATwoNodeList() {
    list.removeFirst();
    // Now, we have two nodes
    list.removeSecond(); // Should remove the last one
    assertEquals(list.first.item, 2);
    assertEquals(list.last.item, 2);
  }

  @Test

  public void testRemoveLast() {
    list.removeLast();
    assertEquals(list.first.item, 1);

  }
}