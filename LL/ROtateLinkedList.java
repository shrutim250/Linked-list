package LL;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class ROtateLinkedList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head; // No rotation needed for an empty list, single node, or zero rotations
        }

        // Step 1: Find the length of the list and the last node
        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Step 2: Calculate effective rotations needed
        k = k % length;
        if (k == 0) {
            return head; // No change needed if k is a multiple of the length
        }

        // Step 3: Find the new tail (length - k - 1) and the new head (length - k)
        int newTailPosition = length - k - 1;
        ListNode newTail = head;
        for (int i = 0; i < newTailPosition; i++) {
            newTail = newTail.next;
        }

        // Step 4: Set the new head, make list circular, then break at the new tail
        ListNode newHead = newTail.next;
        newTail.next = null;
        tail.next = head;

        return newHead;
    }


    public static void main(String[] args) {
        ROtateLinkedList rotateList = new ROtateLinkedList();

        // Creating linked list 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;

        System.out.println("Original Linked List:");
        printList(head);

        ListNode rotatedHead = rotateList.rotateRight(head, k);

        System.out.println("Linked List after rotating by " + k + " nodes:");
        printList(rotatedHead);
    }

    // Helper method to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
