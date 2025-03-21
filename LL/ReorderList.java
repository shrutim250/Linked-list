package LL;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class ReorderList {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // Step 1: Find the middle of the list
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list
        ListNode HeadSecond = reverseList(slow.next);
        slow.next = null; // Split the list into two halves

        // Step 3: Merge the two halves
        ListNode HeadFirst = head;
        while (HeadSecond != null) {
            ListNode temp1 = HeadFirst.next;
            ListNode temp2 = HeadSecond.next;

            HeadFirst.next = HeadSecond;
            HeadSecond.next = temp1;

            HeadFirst = temp1;
            HeadSecond = temp2;
        }
    }

    // Helper method to reverse a list
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }
        return prev;
    }

    // Helper method to print the list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Create example list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);

        ReorderList reorder = new ReorderList();
        reorder.reorderList(head);

        System.out.println("Reordered List:");
        printList(head);
    }
}

