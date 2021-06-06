package interview.reversallinkedlist;

public class ReverseLinkedList {

    //        current                             previous
    // 2 -> 4 -> 6 -> 8 -> 10             null
    // 4 -> 6 -> 8 -> 10                  2 -> null
    // 6 -> 8 -> 10                       4 -> 2 -> null
    // 8 -> 10                            6 -> 4 -> 2 -> null
    // 10                                 8 -> 6 -> 4 -> 2 -> null
    // null                               10 -> 8 -> 6 -> 4 -> 2 -> null
    public static ListNode reverse(ListNode head) {
        ListNode current = head, previous = null, next;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);

        ListNode result = ReverseLinkedList.reverse(head);
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
