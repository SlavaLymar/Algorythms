package leetcode.medium;

public class ConvertSortedListToBinarySearchTree {

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

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    //            f
    // -10,-3,0,5,9
    //        s
    //     p
    //
    // t: O (N * log N)
    // space: O (log N)
    //
    // 1. recursive find middle with slow-fast pointers
    //  a. prev.next = null
    //  b. node = middle
    //  c. node.left = head
    //  d. node.right = middle.next
    //
    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        ListNode mid = findMid(head);
        TreeNode node = new TreeNode(mid.val);
        if (head == mid) return node;
        node.left = sortedListToBST(head);
        node.right = sortedListToBST(mid.next);
        return node;
    }

    private static ListNode findMid(ListNode head) {
        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (prev != null) prev.next = null;
        return slow;
    }

    public static void main(String[] args) {
        ListNode l9 = new ListNode(9, null);
        ListNode l5 = new ListNode(5, l9);
        ListNode l0 = new ListNode(0, l5);
        ListNode l3 = new ListNode(-3, l0);
        ListNode head = new ListNode(-10, l3);
        System.out.println(sortedListToBST(head));
    }
}
