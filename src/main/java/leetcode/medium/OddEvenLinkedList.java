package leetcode.medium;

public class OddEvenLinkedList {

     public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    //                     n
    //                     p
    //                          c
    // h
    // 1 ->      3      -> 5
    //
    // h
    //      t
    // 2 -> 4
    //
    // t: O (N)
    // space: O (1)
    //
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;

        ListNode current = head, previous = null, next = null, h = null, t = null;
        while (current != null) {
            previous = current;
            current = current.next;
            if (current != null) {
                next = current.next;
            } else {
                break;
            }

            if (h == null) {
                h = t = current;
            } else {
                t.next = current;
                t = t.next;
            }

            previous.next = next;
            t.next = null;
            current = next;
        }

        previous.next = h;

        return head;
    }
}
