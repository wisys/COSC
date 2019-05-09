package year2.trees;

/**
 * Professor: R. Escalante
 * Class:     COSC-1437
 * Semester:  Spring 2019
 * Date:      May 8nd, 2019
 * Purpose:   Demo program; Run to see debug output based on two year2.trees.BSTree.java instances.
 *
 * @author    Johnathon Skidmore
 * @code      year2.trees.BSTDemo.java
 * @since     2019-05-6
 */
public class BSTDemo {

    public static void main(String[] args) {
        BSTree bsTree = new BSTree();
        bsTree.add(20);
        bsTree.add(10);
        bsTree.add(40);
        bsTree.add(30);
        bsTree.add(50);
        BSTree bsTree1 = new BSTree();
        bsTree1.add(512);
        bsTree1.add(2048);
        bsTree1.add(64);
        bsTree1.add(1024);
        bsTree1.add(128);

        System.out.println(bsTree.toString());
        System.out.print(String.format("root:%s\nsize:%d\nsum:%d\nleafCount:%d\nNodes with one child:%s\nNodes with two children:%s\n", bsTree.root.toString(), bsTree.size, bsTree.sum(), bsTree.leafCount(), bsTree.oneCount(), bsTree.twoCount()));
        System.out.println("preorder:");
        bsTree.preorder();
        System.out.println("inorder:");
        bsTree.inorder();
        System.out.println("postorder:");
        bsTree.postorder();
        System.out.println();

        System.out.println(bsTree1.toString());
        System.out.print(String.format("root:%s\nsize:%d\nsum:%d\nleafCount:%d\nNodes with one child:%s\nNodes with two children:%s\n", bsTree1.root.toString(), bsTree1.size, bsTree1.sum(), bsTree1.leafCount(), bsTree1.oneCount(), bsTree1.twoCount()));
        System.out.println("preorder:");
        bsTree1.preorder();
        System.out.println("inorder:");
        bsTree1.inorder();
        System.out.println("postorder:");
        bsTree1.postorder();
        System.out.println();

    }

}
