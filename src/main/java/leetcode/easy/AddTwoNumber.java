package leetcode.easy;

public class AddTwoNumber {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTreeNumbers(l1, l2, false);
    }

    public ListNode addTreeNumbers(ListNode l1, ListNode l2, boolean plusOne) {
        if (l1 == null && l2 == null) {
            if (plusOne) {
                return new ListNode(1);
            }
            return null;
        }
        if (l1 == null) {
            l1 = new ListNode(0);
        }
        if (l2 == null) {
            l2 = new ListNode(0);
        }

        ListNode result = new ListNode(l1.val + l2.val + (plusOne ? 1 : 0));

        boolean nextPlusOne = false;
        if (result.val - 10 >= 0) {
            result.val -= 10;
            nextPlusOne = true;
        }
        result.next = addTreeNumbers(l1.next, l2.next, nextPlusOne);
        return result;
    }

    public class ListNode {
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
}
