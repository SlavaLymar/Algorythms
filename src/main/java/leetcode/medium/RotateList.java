package leetcode.medium;

public class RotateList {

    //
    // 1, 2, 3, 4, 5
    //
    // 1. count length
    // 2. connect tail with head
    // 3. skip rotatins (if rotations > length)
    // 4. find end of list and set last.next = null
    //
    // t: O (N)
    // space: O (1)
    //
    public static ListNode rotateRight(ListNode head, int rotations) {
        if (head == null || head.next == null || rotations <= 0) {
            return head;
        }
        int length = 1;
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
            length++;
        }
        current.next = head;
        rotations %= length;
        int skipLength = length - rotations;
        ListNode last = null;
        for (int i = 0; i < skipLength; i++) {
            last = head;
            head = head.next;
        }
        last.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode l5 = new ListNode(5, null);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);
        System.out.println(rotateRight(l1, 2));
    }

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
}
