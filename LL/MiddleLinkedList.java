package LL;

class ListNode {
    int val;
    ListNode next;
    
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class MiddleLinkedList {
    ListNode head;

    public ListNode findMiddle() {
        if (head == null) {
            return null; // List is empty
        }
        
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;          // Move slow pointer by one
            fast = fast.next.next;     // Move fast pointer by two
        }

        return slow; // Slow pointer is at the middle
    }

    public static void main(String[] args) {
        MiddleLinkedList list = new MiddleLinkedList(); // Change made here
        list.head = new ListNode(1);
        list.head.next = new ListNode(2);
        list.head.next.next = new ListNode(3);
        list.head.next.next.next = new ListNode(4);
        list.head.next.next.next.next = new ListNode(5);

        ListNode middle = list.findMiddle();
        if (middle != null) {
            System.out.println("The middle node value is: " + middle.val);
        } else {
            System.out.println("The list is empty.");
        }
    }
}
