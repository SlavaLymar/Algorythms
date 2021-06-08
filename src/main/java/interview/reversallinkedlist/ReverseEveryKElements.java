package interview.reversallinkedlist;

public class ReverseEveryKElements {
    //                v - current
    // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8
    // ^ - subNodeEnd
    //
    // 3 -> 2 -> 1 -> 4 -> 5 -> 6 -> 7 -> 8
    //
    public static ListNode reverse(ListNode head, int k) {
        if (k <= 1 || head.next == null) {
            return head;
        }
        ListNode current = head, tmp = null, prevNodeEnd = null;;
        while (true) {
            ListNode subNodeEnd = current, next;
            for (int i = 0; current != null && i < k; i++) {
                next = current.next;
                current.next = tmp;
                tmp = current;
                current = next;
            }
            if (prevNodeEnd == null) {
                head = tmp;
            } else {
                prevNodeEnd.next = tmp;
            }
            subNodeEnd.next = current;
            prevNodeEnd = subNodeEnd;
            if (current == null) {
                break;
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

        ListNode result = ReverseEveryKElements.reverse(head, 3);
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
