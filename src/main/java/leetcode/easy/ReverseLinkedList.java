package leetcode.easy;

public class ReverseLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //
    //
    // 1 2 3 4 5
    //
    // c: 5 -> 4 -> 3 -> 2 -> 1
    // n:
    // p: 4 -> 3 -> 2 -> 1
    //
    // t: O (N)
    // space: O (1)
    //
    public ListNode reverseList(ListNode head) {
        ListNode current = head, next = null, previous = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
}
