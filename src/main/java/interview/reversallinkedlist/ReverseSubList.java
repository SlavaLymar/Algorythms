package interview.reversallinkedlist;

public class ReverseSubList {

    // 1 -> 2 -> 3 -> 4 -> 5
    // 1. lastNodeNonReverse: 1 -> 2 -> 3 -> 4 -> 5
    // 2. lastNodeReverse: 2 -> 3 -> 4 -> 5
    // 3. previous: 4 -> 3 -> 2 current: 5 -> null
    // 4. lastNodeNonReverse.next = previous
    // 5. lastNodeReverse.next = current
    public static ListNode reverse(ListNode head, int p, int q) {
        if (p == q) return head;

        ListNode current = head, previous = null;
        while (current != null && current.value < p) {
            previous = current;
            current = current.next;
        }
        ListNode lastNodeNonReverse = previous;
        ListNode lastNodeReverse = current;
        ListNode next = null;
        while (current != null && current.value <= q) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        if (lastNodeNonReverse != null) {
            lastNodeNonReverse.next = previous;
        }
        if (lastNodeReverse != null) {
            lastNodeReverse.next = current;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = ReverseSubList.reverse(head, 2, 4);
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
