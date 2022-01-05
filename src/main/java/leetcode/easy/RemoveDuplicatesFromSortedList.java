package leetcode.easy;

public class RemoveDuplicatesFromSortedList {

    public static class ListNode {
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

    //     c
    //  p
    // [1, 1, 1, 2, 2, 2, 3, 3]
    //l
    //     c
    //  p
    // [1, 2, 2, 3, 3]
    //l
    //
    //
    // t: O (N)
    // space: O (1)
    //
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode cur = head.next, prev = head, last = null;
        while (cur != null) {
            if (cur.val != prev.val) {
                last = prev;
                prev = prev.next;
                cur = cur.next;
            } else {
                while (cur != null && cur.val == prev.val) {
                    cur = cur.next;
                    prev = prev.next;
                }
                if (last == null) {
                    head = last = prev;
                } else {
                    last.next = prev;
                    last = prev;
                }
                if (cur != null) {
                    cur = cur.next;
                    prev = prev.next;
                }
            }
        }
        return head;
    }
}
