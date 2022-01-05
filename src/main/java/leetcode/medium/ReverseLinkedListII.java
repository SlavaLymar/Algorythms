package leetcode.medium;

public class ReverseLinkedListII {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }

        ListNode(int val, ListNode next) { this.val = val; this.next = next;
      }
  }

    //
    // head = [1,2,3,4,5], left = 2, right = 4
    //
    // index = 1
    //
    //
    //                   p    c
    //         1 -> 2 -> 3 -> 4 -> 5
    //e        sp   s
    //en
    //
    // sp.next = null
    // e.next = null
    // reverse(s)
    // sp.next = e
    // s.next = en
    //
    // t: O (N)
    // space: O (1)
    //
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return null;
        if (left < 1 || right < 1 || left == right) return head;
        ListNode current = head, prev = null, start = null, startPrev = null, end = null, endNext = null;
        int index = 1;
        while (start == null || end == null) {
            if (index == left) {
                start = current;
                startPrev = prev;
            }
            if (index == right) {
                end = current;
                endNext = current.next;
            }
            if (start != null && end != null) {
                if (left != 1) {
                    startPrev.next = null;
                }
                end.next = null;
                this.reverse(start);
                if (left != 1) {
                    startPrev.next = end;
                } else {
                    head = end;
                }
                start.next = endNext;
                break;
            }
            prev = current;
            current = current.next;
            index++;
        }
        return head;
    }

    //
    //
    //  c :
    //  p: 4 -> 3 -> 2
    //  n:
    //
    //
    private void reverse(ListNode head) {
        ListNode current = head, prev = null, next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
    }

    public static void main(String[] args) {
        ListNode l5 = new ListNode(5, null);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);

        System.out.println(new ReverseLinkedListII().reverseBetween(l1, 2, 4));
    }
}
