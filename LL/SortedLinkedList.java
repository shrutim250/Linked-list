package LL;

class Node {
    int val;
    Node next;
    
    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class SortedLinkedList {
    Node head;

    // Method to insert a node in a sorted order
    public void insertSorted(int val) {
        Node newNode = new Node(val);

        // If the list is empty or the new node should be placed at the beginning
        if (head == null || head.val >= newNode.val) {
            newNode.next = head;
            head = newNode;
            return;
        }

        // Find the position to insert the new node
        Node temp = head;
        while (temp.next != null && temp.next.val < newNode.val) {
            temp = temp.next;
        }

        // Insert the new node
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Method to print the linked list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SortedLinkedList list = new SortedLinkedList();
        
        list.insertSorted(5);
        list.insertSorted(2);
        list.insertSorted(8);
        list.insertSorted(1);
        list.insertSorted(3);
        
        System.out.println("Sorted Linked List:");
        list.printList();
    }
}
