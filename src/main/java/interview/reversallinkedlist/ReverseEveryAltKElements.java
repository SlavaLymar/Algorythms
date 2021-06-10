package interview.reversallinkedlist;

public class ReverseEveryAltKElements {

    // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8  k = 2
    //
    // previous             current
    // 2 -> 1               3 -> 4 -> 5 -> 6 -> 7 -> 8
    // 2 -> 1 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8
    public static ListNode reverse(ListNode head, int k) {
        ListNode current = head, previous = null, lastSubNodeEnd = null;;
        while (current != null) {
            ListNode subNodeEnd = current;
            ListNode next = null;
            for (int i = 0; i < k && current != null; i++) {
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }
            if (lastSubNodeEnd == null) {
                head = previous;
            } else {
                lastSubNodeEnd.next = previous;
            }
            subNodeEnd.next = current;
            lastSubNodeEnd = subNodeEnd;
            for (int i = 0; i < k && current != null; i++) {
                lastSubNodeEnd = current;
                current = current.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        ListNode result = ReverseEveryAltKElements.reverse(head, 2);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
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
