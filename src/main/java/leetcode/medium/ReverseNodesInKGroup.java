package leetcode.medium;

public class ReverseNodesInKGroup {

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

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head.next == null) {
            return head;
        }
        ListNode current = head, tmp = null, prevNodeEnd = null;
        while (true) {
            ListNode subNodeEnd = current, next;
            int count = 0;
            boolean exit = false;
            for (int i = 0; current != null && i < k; i++) {
                count++;
                next = current.next;
                current.next = tmp;
                tmp = current;
                current = next;
            }
            while (count != k && count > 0) {
                exit = true;
                next = tmp.next;
                tmp.next = current;
                current = tmp;
                tmp = next;
                count--;
            }
            if (exit) {
                break;
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
//        head.next.next.next.next.next = new ListNode(6);
//        head.next.next.next.next.next.next = new ListNode(7);
//        head.next.next.next.next.next.next.next = new ListNode(8);

        ListNode result = reverseKGroup(head, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
