package leetcode.medium;

public class SortList {

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

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    //
    //
    // 7 -> 5 -> 4 -> 2 -> 1 -> 3 - 9
    // h              m
    //
    // 7 -> 5 -> 4    2 -> 1 -> 3 - 9
    //
    // h   m
    // 7   5 -> 4     h        m
    //                2 -> 1   3 -> 9
    //
    //     l   r      l    r   l    r
    // 7   5   4      2    1   3    9
    //
    // l   r          l        r
    // 7   4 -> 5     1 -> 2   3 -> 9
    //
    // l              r
    // 4 -> 5 -> 7    1 -> 2 -> 3 -> 9
    //
    // 1 -> 2 -> 3 -> 4 -> 5 -> 7 -> 9
    //
    // t: O (N*LogN)
    // space: O (N*LogN)
    //
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left, right);
    }

    ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        tail.next = (list1 != null) ? list1 : list2;
        return dummyHead.next;
    }

    ListNode getMid(ListNode head) {
        ListNode midPrev = null;
        while (head != null && head.next != null) {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }

    public static void main(String[] args) {
        ListNode l9 = new ListNode(9, null);
        ListNode l3 = new ListNode(3, l9);
        ListNode l1 = new ListNode(1, l3);
        ListNode l2 = new ListNode(2, l1);
        ListNode l4 = new ListNode(4, l2);
        ListNode l5 = new ListNode(5, l4);
        ListNode head = new ListNode(7, l5);
        // 7 -> 5 -> 4 -> 2 -> 1 -> 3 - 9
        System.out.println(
            new SortList().sortList(head)
        );
    }
}
