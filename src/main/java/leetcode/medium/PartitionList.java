package leetcode.medium;

public class PartitionList {

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

    // h
    // 1, 4, 3, 2, 5, 2   x = 3
    //    c
    //       s  e  n
    // p
    //
    // h
    // 2, 2, 9, 4, 3, 5   x = 3
    //       c
    //    e  s
    //    p
    //
    // t: O (N)
    // space: O (1)
    //
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode current = head, prev = null, newHead = null, start, end;
        while (current != null) {
            if (current.val < x) {
                if (newHead == null) {
                    newHead = current;
                } else {
                    prev.next = current;
                }
                prev = current;
                current = current.next;
            } else {
                start = current;
                end = current.next;
                while (end != null && end.val >= x) {
                    end = end.next;
                    start = start.next;
                }
                if (end == null) {
                    if (newHead == null) {
                        return head;
                    } else {
                        break;
                    }
                }
                ListNode next = end.next;
                start.next = null;
                if (prev != null) prev.next = end;
                end.next = current;
                start.next = next;
                prev = end;
                if (newHead == null) newHead = prev;
            }
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode a21 = new ListNode(2, null);
        ListNode a5 = new ListNode(5, a21);
        ListNode a2 = new ListNode(2, a5);
        ListNode a3 = new ListNode(3, a2);
        ListNode a4 = new ListNode(4, a3);
        ListNode a1 = new ListNode(1, a4);
        System.out.println(new PartitionList().partition(a1 ,3));

        ListNode a23 = new ListNode(2, null);
        ListNode a51 = new ListNode(5, a23);
        ListNode a22 = new ListNode(2, a51);
        ListNode a31 = new ListNode(3, a22);
        ListNode a41 = new ListNode(4, a31);
        ListNode a9 = new ListNode(9, a41);
        System.out.println(new PartitionList().partition(a9 ,3));
    }
}
