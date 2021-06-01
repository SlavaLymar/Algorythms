package interview.fastandslowpointers;

public class PalindromicLinkedList {

    //           s
    // 2 -> 4 -> 6 -> 4 -> 2
    //                     f
    // n
    public static boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reverseRightHalf = reverse(slow);
        ListNode copy = reverseRightHalf;

        while (reverseRightHalf != null && head != null) {
            if (reverseRightHalf.value != head.value) {
                return false;
            }
            reverseRightHalf = reverseRightHalf.next;
            head = head.next;
        }
        reverse(copy);
        return true;
    }

    // 6 -> 4 -> 2
    // head
    // null
    // next
    // null
    // reverse
    // 2 -> 4 -> 6
    private static ListNode reverse(ListNode head) {
        ListNode reverse = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = reverse;
            reverse = head;
            head = next;
        }
        return reverse;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));

        head.next.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));
    }

    static class ListNode {
        int value = 0;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }
}
