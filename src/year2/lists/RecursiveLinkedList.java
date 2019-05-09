package year2.lists;

public class RecursiveLinkedList {

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

    private Node first = null;

    private int size(Node list) {
        if(list == null) return 0;        // Base case.
        else return size(list.next) + 1;  // Add 1 to size of tail.
    }

    public int size() { return size(this.first); }

    /**
     * Adds an element to the end of the list.
     * @param e The value to add to the end of the list.
     */
    public void add(String e) {
        this.first = add(e, this.first);
    }

    /**
     * This add method adds an element e at place index in the linked list.
     * @param index The place in the list to to add an element.
     * @param e The element to add to the linked list.
     */
    public void add(int index, String e) {
        // Replace first with the result of adding e at index in first.
        this.first = add(index, e, this.first);
    }

    private Node add(String e, Node list) {
        if(list == null) {
            // Base case.
            return new Node(e);
        } else {
            // Add e to the end of the tail and use the result to replace the tail.
            list.next = add(e, list.next); // The modified tail is used to replace the current tail in list.
            return list;                   // Return the original list with the tail thus replaced.
        }
    }

    private Node add(int index, String e, Node list) {
        if(index < 0 || index > size()) {
            String message = String.valueOf(index);
            throw new IndexOutOfBoundsException(message);
        }

        if(index == 0) return new Node(e, list);

        list.next = add(index-1, e, list.next);
        return list;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        // Use p to walk down the list.
        Node p = this.first;
        while(p != null) {
            stringBuilder.append(p.value).append("\n");
            p = p.next;
        }

        return stringBuilder.toString();
    }

    private class RemovalResult {
        Node node, list;

        RemovalResult(Node remNode, Node remList) {
            this.node = remNode;
            this.list = remList;
        }

        public String remove(int index) {
            RemovalResult removalResult = remove(index, first);
            String element = removalResult.node.value; // Element to return.
            first = removalResult.list;
            return element;
        }

        private RemovalResult remove(int index, Node list) {
            if(index < 0 || index >= size()) {
                String message = String.valueOf(index);
                throw new IndexOutOfBoundsException(message);
            }

            if(index == 0) {
                // Remove first node on the list.
                RemovalResult removalResult = new RemovalResult(list, list.next);
                list.next = null;
                return removalResult;
            }

            // Recursively remove the element at index-1 in the tail.
            RemovalResult removalResult = remove(index-1, list.next);

            // Replace the tail with the results and return after modifying the list part of RemovalResult.
            list.next = removalResult.list;
            removalResult.list = list;
            return removalResult;
        }

        private RemovalResult remove(String e, Node list) {
            if(list == null)
                return new RemovalResult(null, null);

            if(list.value.equals(e)) {
                RemovalResult removalResult = new RemovalResult(list, list.next);
                list.next = null;
                return removalResult;
            }

            // year2.elements.Node to be removed is after the first ndoe on list,
            // recursively remove it from the tail.
            RemovalResult removalResult = remove(e, list.next);
            list.next = removalResult.list;
            removalResult.list = list;
            return removalResult;
        }
    }
}
