package leetcode.medium;

public class SwapNodesInPairs {

    public static class ListNode {
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
    }

    //
    // head
    // 2 -> 1 ->
    //
    // current
    //
    //
    // tmp
    // 4 -> 3
    //
    // prev
    // 3
    //
    // subNodeEnd
    // 3 -> 4
    //
    // next
    //
    //
    //
    public static ListNode swapPairs(ListNode head) {
        ListNode current = head, tmp = null, prev = null;
        while (true) {
            ListNode subNodeEnd = current, next;
            for (int i = 0; i < 2 && current != null; i++) {
                next = current.next;
                current.next = tmp;
                tmp = current;
                current = next;
            }
            if (prev == null) {
                head = tmp;
            } else {
                prev.next = tmp;
            }
            subNodeEnd.next = current;
            prev = subNodeEnd;
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

        ListNode result = swapPairs(head);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
