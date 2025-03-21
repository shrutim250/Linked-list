package LL;

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class ReverseLinkedListByRecursiveMethod {
    
    public Node reverseList(Node head) {
        // Base case: if head is null or only one node, return head
        if (head == null || head.next == null) {
            return head;
        }

        // Recursive call: reverse the rest of the list
        Node newHead = reverseList(head.next);

        // Reverse the link
        head.next.next = head;
        head.next = null;

        // Return new head of the reversed list
        return newHead;
    }

    public static void main(String[] args) {
        ReverseLinkedListByRecursiveMethod list = new ReverseLinkedListByRecursiveMethod();

        // Creating a sample linked list: 1 -> 2 -> 3 -> 4 -> null
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        // Reverse the linked list
        Node reversedHead = list.reverseList(head);

        // Print the reversed linked list
        Node temp = reversedHead;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
