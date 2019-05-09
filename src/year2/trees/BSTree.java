package year2.trees;

/**
 * Professor: R. Escalante
 * Class:     COSC-1437
 * Semester:  Spring 2019
 * Date:      May 8nd, 2019
 * Purpose:   Binary search tree (linear, not log) with node-specific implemented methods.
 *
 * @author    Johnathon Skidmore
 * @code      year2.trees.BSTree.java
 * @since     2019-05-6
 */
public class BSTree {
  public BTNode root;
  public int size = 0;
  
  // printing methods
  public void preorder() { this.root.preorder(); }
  public void inorder() { this.root.inorder(); }
  public void postorder() { this.root.postorder(); }

  // Drivers
  public void add(int item) { 
    this.root = this.add(item, this.root);
    this.size++;
  }

  public boolean contains(int item) {
      return this.contains(item, this.root);
  }
  
  private BTNode add(int item, BTNode root) {
    /* base case */ if(root == null) return new BTNode(item);
    else if(item < root.item) root.left = this.add(item, root.left);
    else if(item > root.item) root.right = this.add(item, root.right);
    else throw new RuntimeException("Duplicate element.");
    return root;
  }
  
  private boolean contains(int item, BTNode root) {
    /* base case 1 */ if(root == null) return false;
    /* base case 2 */ else if(root.item == item) return true;
    else if(item < root.item) return this.contains(item, root.left);
    else return this.contains(item, root.right);
  }

  public int sum() { return this.root.sum(); }

  public int leafCount() { return this.root.leaves(); }
  public int oneCount() { return this.root.hasOneChild(); }
  public int twoCount() { return this.root.hasTwoChildren(); }
  
  public int size() { return this.size; }
  
  public boolean isEmpty() { return this.root == null; }
}