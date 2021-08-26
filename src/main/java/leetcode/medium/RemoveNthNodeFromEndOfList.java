package leetcode.medium;

import java.util.LinkedList;

public class RemoveNthNodeFromEndOfList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;


        }
    }

    // 1.
    //  l
    // [1,2,3,4,5], n=2
    //  r
    //
    // 2.
    //  l
    // [1,2,3,4,5], n=2
    //        r
    // 3.
    //      l
    // [1,2,3,4,5], n=2
    //            r
    // delete(l.next)
    //
    // t: O (N)
    // space: O (1)
    //
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode left = head, right = head;
        for (int i = 0; i <= n; i++) {
            if (right == null) return head.next;
            right = right.next;
        }
        while (right != null) {
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode l5 = new ListNode(5, null);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);
        System.out.println(removeNthFromEnd(l1, 2));
        System.out.println(removeNthFromEnd(new ListNode(1, null), 1));

        ListNode r2 = new ListNode(2, null);
        ListNode r1 = new ListNode(1, r2);
        System.out.println(removeNthFromEnd(r1, 2));


    }
}
