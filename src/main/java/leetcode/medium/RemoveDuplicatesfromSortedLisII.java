package leetcode.medium;

public class RemoveDuplicatesfromSortedLisII {

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

    //           p
    //              c
    // [1, 2, 3, 3, 4, 4, 5]
    //     l
    //
    //  p
    //     c
    // [1, 1, 1, 2, 3]
    //l
    //
    //  p
    //     c
    // [1, 1]
    //  l
    //
    // t: O (N)
    // space: O (1)
    //
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode current = head.next, previous = head, lastNonDuplicate = null;
        while (current != null) {
            if (current.val != previous.val) {
                lastNonDuplicate = previous;
                current = current.next;
                previous = previous.next;
            } else {
                while ((current != null && current.val == previous.val)
                        || (current != null && current.next != null && current.next.val == current.val)) {
                    current = current.next;
                    previous = previous.next;
                }
                if (lastNonDuplicate == null) {
                    head = current;
                    lastNonDuplicate = current;
                    if (current != null) {
                        current = current.next;
                        previous = previous.next;
                    }
                }
                if (lastNonDuplicate != null) {
                    lastNonDuplicate.next = current;
                }
            }
        }
        return lastNonDuplicate == null ? null : head;
    }

    public static void main(String[] args) {

//        ListNode n5 = new ListNode(5, null);
//        ListNode n41 = new ListNode(4, n5);
//        ListNode n4 = new ListNode(4, n41);
//        ListNode n31 = new ListNode(3, n4);
//        ListNode n3 = new ListNode(3, n31);
//        ListNode n2 = new ListNode(2, n3);
//        ListNode n1 = new ListNode(1, n2);
//
//        System.out.println(deleteDuplicates(n1));
//
//        ListNode n111 = new ListNode(1, null);
//        ListNode n11 = new ListNode(1, n111);
//
//        System.out.println(deleteDuplicates(n11));

//        ListNode n21 = new ListNode(2, null);
//        ListNode n1111 = new ListNode(1, n21);
//        ListNode n1115 = new ListNode(1, n1111);
//
//        System.out.println(deleteDuplicates(n1115));

        ListNode n22 = new ListNode(2, null);
        ListNode n23 = new ListNode(2, n22);
        ListNode n112 = new ListNode(1, n23);

        System.out.println(deleteDuplicates(n112));
    }
}
