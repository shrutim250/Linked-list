package LL;
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2; // If list1 is empty, return list2
        if (list2 == null) return list1; // If list2 is empty, return list1

        ListNode head;  // Head of the merged list
        ListNode tail;  // Tail of the merged list to build upon

        // Initialize the head and tail with the smaller node
        if (list1.val < list2.val) {
            head = tail = list1;
            list1 = list1.next;
        } else {
            head = tail = list2;
            list2 = list2.next;
        }

        // Build the merged list
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;  // Move the tail to the newly added node
        }

        // Attach the remaining nodes if any
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }

        return head;
    }

    public static void main(String[] args) {
        // Example usage
        MergeTwoSortedLists merge = new MergeTwoSortedLists();

        // Creating first sorted list: 1 -> 3 -> 5
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);

        // Creating second sorted list: 2 -> 4 -> 6
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);

        // Merging the lists
        ListNode mergedList = merge.mergeTwoLists(list1, list2);

        // Print merged list
        while (mergedList != null) {
            System.out.print(mergedList.val + " -> ");
            mergedList = mergedList.next;
        }
        System.out.print("null");
    }
}
