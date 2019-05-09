package year2.lists;

public class DoublyLinkedList {

    private class Node {
        public String value;
        public Node next, prev;

        Node(String value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        Node(String value, Node next) { this(value, next, null); }

        Node(String value) { this(value, null, null); }
    }

    private Node first, last;

    public DoublyLinkedList() {
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public int size() {
        int count = 0;
        Node p = this.first;
        while(p != null) {
            count++;
            p = p.next;
        }
        return count;
    }

    /**
     * The add method adds to the end of the list.
     * @param e The value to add.
     */
    public void add(String e) {
        if(isEmpty()) {
            this.last = new Node(e);
            this.first = this.last;
        } else {
            this.last.next = new Node(e, null, last);
            this.last = this.last.next;
        }
    }

    /**
     * This add method adds an element at an index.
     * @param index The index at which to insert / add.
     * @param e The String element to add to the year2.elements.Node list.
     * @exception IndexOutOfBoundsException When the index is out of bounds.
     */
    public void add(int index, String e) {
        if(index < 0 || index > size()) {
            String message = String.valueOf(index);
            throw new IndexOutOfBoundsException(message);
        }

        if(index == 0) {
            // New element goes at the beginning.
            Node p = this.first; // Old first.
            this.first = new Node(e, p, null);
            if(p != null)
                p.prev = this.first;
            if(this.last == null)
                this.last = this.first;
            return;
        }

        // Variable pred points to the predecessor of the new node.
        Node pred = this.first;
        for(int k = 1; k <= index - 1; k++)
            pred = pred.next;

        // Splice in a node with the new element.
        // We want to go from pred-- succ -> pred--middle-succ.
        Node succ = pred.next, middle = new Node(e, succ, pred);
        pred.next = middle;
        if(succ == null)
            this.last = middle;
        else
            succ.prev = middle;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node p = this.first;

        while(p != null) {
            stringBuilder.append(p.value).append("\n");
            p = p.next;
        }
        return stringBuilder.toString();
    }

    /**
     * The remove method removes the element at a given position.
     * @param index The position of the element to remove.
     * @return The element removed.
     * @exception IndexOutOfBoundsException When the index is out of bounds.
     */
    public String remove(int index) {
        if(index < 0 || index >= size()) {
            String message = String.valueOf(index);
            throw new IndexOutOfBoundsException(message);
        }

        Node target = this.first;
        for(int k = 1; k <= index - 1; k++)
            target = target.next;

        String element = target.value; // Element to return.
        Node pred = target.prev;       // year2.elements.Node before the target.
        Node succ = target.next;       // year2.elements.Node after the target.

        // Route forward and back pointers around the node to be removed.
        if(pred == null) this.first = succ;
        else pred.next = succ;

        if(succ == null) this.last = pred;
        else succ.prev = pred;

        return element;
    }

    /**
     * The remove method removes an element from the list.
     * @param e The element to remove.
     * @return true if the element was removed.
     */
    public boolean remove(String e) {
        if(isEmpty()) return false;

        // Locate the node targeted for removal.
        Node target = this.first;
        while(target != null && !e.equals(target.value))
            target = target.next;

        if(target == null) return false;

        // The predecessor node and successive node of the target node.
        Node pred = target.prev, succ = target.next;

        // Route forward and back pointers around the node to be removed.
        if(pred == null) this.first = succ;
        else pred.next = succ;

        if(succ == null) this.last = pred;
        else succ.prev = pred;

        return true;
    }
}
