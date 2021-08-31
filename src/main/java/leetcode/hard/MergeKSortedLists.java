package leetcode.hard;

import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {

    public class ListNode {
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

    //     v     v       v
    // [[1,4,5],[1,3,4],[2,6]]
    //
    // [1,2,4]
    // head = 1,4,5
    // tail = 1,1,3,4
    //
    // t: O (N  Log K)
    // space: O (K)
    //
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<>((l1, l2) -> l1.val - l2.val);
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }
        ListNode head = null, tail = null;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            if (head == null) {
                head = tail = node;
            } else {
                tail.next = node;
                tail = tail.next;
            }
            if (node.next != null) {
                queue.offer(node.next);
            }
        }
        return head;
    }
}
