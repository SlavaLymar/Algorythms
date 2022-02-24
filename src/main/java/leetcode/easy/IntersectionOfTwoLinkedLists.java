package leetcode.easy;

public class IntersectionOfTwoLinkedLists {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        ListNode(int x, ListNode next) {
            val = x;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }
    }

    //
    // t: O (N)
    // space: O (1)
    //
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    public static void main(String[] args) {
        // listA = [4,1,8,4,5], listB = [5,6,1,8,4,5]

        ListNode l5 = new ListNode(5);
        ListNode l4 = new ListNode(4, l5);
        ListNode l8 = new ListNode(8, l4);
        ListNode l1 = new ListNode(1, l8);
        ListNode pA = new ListNode(4, l1);
        ListNode l11 = new ListNode(1, l8);
        ListNode l6 = new ListNode(6, l11);
        ListNode pB = new ListNode(5, l6);
        System.out.println(new IntersectionOfTwoLinkedLists().getIntersectionNode(pA, pB));
    }
}
