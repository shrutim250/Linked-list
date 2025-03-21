package LL;
class LinkedList {
    Node head;

    // Node class definition
    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Method to start recursive insertion
    public void insertAtPosition(int val, int position) {
        head = insertRecursive(head, val, position);
    }

    // Recursive insertion method
    private Node insertRecursive(Node current, int val, int position) {
        // Base case: Position is 0, so insert here
        if (position == 0) {
            Node newNode = new Node(val);
            newNode.next = current;
            return newNode;
        }

        // Recursive step: move to the next node and reduce position by 1
        current.next = insertRecursive(current.next, val, position - 1);
        return current;
    }

    // Helper method to display the list
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtPosition(3, 0); // Inserting at head
        list.insertAtPosition(5, 1); // Inserting at position 1
        list.insertAtPosition(7, 2); // Inserting at position 2
        list.insertAtPosition(9, 1); // Inserting at position 1 again

        list.display(); // Expected Output: 3 -> 9 -> 5 -> 7 -> END
    }
}

