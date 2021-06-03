package interview.fastandslowpointers;

public class RearrangeList {

    //                s
    // 2 -> 4 -> 6 -> 8 -> 10 -> 12
    //                                 f
    public static void reorder(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reversed = reverse(slow);

        // head
        // 2 -> 12 -> 4 -> 10 -> *6 -> 8
        // tmp
        // 8
        // reversed
        // 12 -> 10 -> *8
        while (head != null && reversed != null) {
            ListNode tmp = head.next;
            head.next = reversed;
            head = head.next;
            reversed = reversed.next;
            if (reversed != null) {
                head.next = tmp;
            }
            head = head.next;
        }
    }

    // 8 -> 10 -> 12
    // head
    // null
    // next
    // null
    // reversed
    // 12 -> 10 -> 8
    private static ListNode reverse(ListNode head) {
        ListNode reversed = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = reversed;
            reversed = head;
            head = next;
        }
        return reversed;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(12);
        RearrangeList.reorder(head);
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
    }

    static class ListNode {
        int value = 0;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }
}
