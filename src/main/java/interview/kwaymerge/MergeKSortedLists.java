package interview.kwaymerge;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {

    static class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

    //            v             v             v
    // Input: L1=[2, 6, 8], L2=[3, 6, 7], L3=[1, 3, 4]
    // Output: [1, 2, 3, 3, 4, 6, 6, 7, 8]
    //              h
    // [1,2,3] -> [ 1, 2]
    //                 t
    // t: O (K + N * Log K)
    // space: O (K)
    public static ListNode merge(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<>((l1, l2) -> l1.value - l2.value);
        Collections.addAll(queue, lists);
        ListNode resultHead = null, resultTail = null;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            if (resultHead == null) {
                resultHead = resultTail = node;
            } else {
                resultTail.next = node;
                resultTail = resultTail.next;
            }
            if (node.next != null) {
                queue.add(node.next);
            }
        }
        return resultHead;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(6);
        l1.next.next = new ListNode(8);

        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(7);

        ListNode l3 = new ListNode(1);
        l3.next = new ListNode(3);
        l3.next.next = new ListNode(4);

        ListNode result = MergeKSortedLists.merge(new ListNode[] { l1, l2, l3 });
        System.out.print("Here are the elements form the merged list: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}
