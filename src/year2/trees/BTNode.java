package year2.trees;

/**
 * Professor: R. Escalante
 * Class:     COSC-1437
 * Semester:  Spring 2019
 * Date:      May 8nd, 2019
 * Purpose:   BST (Binary search tree) node object with recursion of search and node counts.
 *
 * @author    Johnathon Skidmore
 * @code      year2.trees.BTNode.java
 * @since     2019-05-6
 */
public class BTNode {
  public int item;
  public BTNode left, right;
  
  public BTNode(int item) {
    this.item = item;
  }
  
  public BTNode(int item, BTNode left, BTNode right) {
    this.item = item;
    this.left = left;
    this.right = right;
  }

  // Drivers
  public void preorder() { this.preorder(this); }
  public void inorder() { this.inorder(this); }
  public void postorder() { this.postorder(this); }
  public int sum() { return this.sum(this); }
  public int leaves() { return this.leafCount(this); }
  public int hasOneChild() { return this.uniChildCount(this); }
  public int hasTwoChildren() { return this.biChildCount(this); }

  private void preorder(BTNode node) {
    System.out.println(node); // V
    if(node.left != null) this.preorder(node.left); // L
    if(node.right != null) this.preorder(node.right); // R
  }
  
  private void inorder(BTNode node) {
    if(node.left != null) this.inorder(node.left); // L
    System.out.println(node); // V
    if(node.right != null) this.inorder(node.right); // R
  }
  
  private void postorder(BTNode node) {
    if(node.left != null) this.postorder(node.left); // L
    if(node.right != null) this.postorder(node.right); // R
    System.out.println(node); // V
  }

  private int sum(BTNode node) {
    int sum = node.item;
    if(node.left != null) sum += this.sum(node.left);
    if(node.right != null) sum += this.sum(node.right);
    return sum;
  }

  private int leafCount(BTNode node) {
    if(node == null) return 0;
    if(this.hasNoChildren(node)) return 1 + this.leafCount(node.left) + this.leafCount(node.right);
    else return this.leafCount(node.left) + this.leafCount(node.right);
  }

  private int uniChildCount(BTNode node) {
    if(node == null) return 0;
    if(this.hasOneChild(node)) return 1 + this.uniChildCount(node.left) + this.uniChildCount(node.right);
    else return this.uniChildCount(node.left) + this.uniChildCount(node.right);
  }

  private int biChildCount(BTNode node) {
    if(node == null) return 0;
    if(this.hasTwoChildren(node)) return 1 + this.biChildCount(node.left) + this.biChildCount(node.right);
    else return this.biChildCount(node.left) + this.biChildCount(node.right);
  }
  
  private boolean hasNoChildren(BTNode node) { return (node.left == null && node.right == null); }
  private boolean hasOneChild(BTNode node) { return (node.left != null || node.right != null); }
  private boolean hasTwoChildren(BTNode node) { return (node.left != null && node.right != null); }

  public String toString() { return "[" + this.item + "]";}
}