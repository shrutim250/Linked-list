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

    // Method to remove duplicates from sorted linked list
    public void removeDuplicates() {
        Node current = head;

        // Traverse the list until the end
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                // Skip the duplicate node
                current.next = current.next.next;
            } else {
                // Move to the next node if no duplicate
                current = current.next;
            }
        }
    }

    // Method to add a node at the end of the list
    public void add(int val) {
        if (head == null) {
            head = new Node(val);
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(val);
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
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        
        System.out.println("Original List:");
        list.display();

        list.removeDuplicates();
        
        System.out.println("List after removing duplicates:");
        list.display();
    }

    public ListNode findMiddle() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findMiddle'");
    }
}

