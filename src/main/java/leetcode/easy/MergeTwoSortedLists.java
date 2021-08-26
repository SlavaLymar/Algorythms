package leetcode.easy;

public class MergeTwoSortedLists {

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

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    //
    // l1 = [1,2,4], l2 = [1,3,4]
    //
    //
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode tail = new ListNode();
        ListNode head = tail;
        if (l1 == null && l2 == null) {
            return l1;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
                tail = tail.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
                tail = tail.next;
            }
        }
        if (l1 != null) {
            tail.next = l1;
        } else {
            tail.next = l2;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l14 = new ListNode(4, null);
        ListNode l12 = new ListNode(2, l14);
        ListNode l11 = new ListNode(1, l12);

        ListNode l24 = new ListNode(4, null);
        ListNode l23 = new ListNode(3, l24);
        ListNode l21 = new ListNode(1, l23);

        System.out.println(mergeTwoLists(l11, l21));

        ListNode l0 = new ListNode(0, null);
        System.out.println(mergeTwoLists(null, l0));
    }
}
