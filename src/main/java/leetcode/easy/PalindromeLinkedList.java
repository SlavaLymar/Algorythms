package leetcode.easy;

public class PalindromeLinkedList {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    //
    //   s
    // 1,2,2,1
    //     f
    //
    //     s
    // 1,2,2,2,1
    //         f
    //
    // t: O (N)
    // space: O (1)
    //
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode firstHalfTail = firstHalfTail(head);
        ListNode secondHalfHead = reverse(firstHalfTail.next);

        ListNode l1 = head;
        ListNode l2 = secondHalfHead;
        boolean result = true;
        while (result && l2 != null) {
            if (l1.val != l2.val) result = false;
            l1 = l1.next;
            l2 = l2.next;
        }
        firstHalfTail.next = reverse(secondHalfHead);
        return result;
    }

    private ListNode reverse(ListNode node) {
        ListNode curr = node, prev = null, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private ListNode firstHalfTail(ListNode head) {
        ListNode slow = head, fast = head;
        while (slow.next != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
