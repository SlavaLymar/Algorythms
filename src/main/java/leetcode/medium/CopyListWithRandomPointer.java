package leetcode.medium;

import java.util.Objects;

public class CopyListWithRandomPointer {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public Node(int val, Node next, Node random) {
            this.val = val;
            this.next = next;
            this.random = random;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return val == node.val &&
                    Objects.equals(next, node.next) &&
                    Objects.equals(random, node.random);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, next, random);
        }
    }

    //
    // 0. [[7,null],[13,0],[11,4],[10,2],[1,0]]
    //       cur
    //
    // 1. insert copied node into exist sequence
    // [[7,null],[7,null]`,[13,0],[13,null]`,[11,4],[11,null]`,[10,2],[10,null]`,[1,0],[1,null]`]
    //
    // 2. define random links for copied nodes
    // [[7,null],[7,null]`,[13,0],[13,0]`,[11,4],[11,4]`,[10,2],[10,2]`,[1,0],[1,0]`]
    //
    // 3. widthraw copied nodes from exist
    // [[7,null],[13,0],[11,4],[10,2],[1,0]]
    // [[7,null]`,[13,0]`,[11,4]`,[10,2],[1,0]`]
    //
    //
    // t: O (N)
    // space: O (1)
    //
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node cur = head;

        // 1.
        while (cur != null) {
            Node clone = new Node(cur.val);
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        }

        cur = head;
        // 2.
        while (cur != null) {
            cur.next.random = cur.random != null ? cur.random.next : null;
            cur = cur.next.next;
        }

        // 3.
        cur = head;
        Node cloneTail = cur.next;
        Node clone = cur.next;
        while (cur != null) {
            cur.next = cur.next.next;
            cloneTail.next = cloneTail.next != null ? cloneTail.next.next : null;
            cur = cur.next;
            cloneTail = cloneTail.next;
        }
        return clone;
    }

    public static void main(String[] args) {

        // [[7,null],[13,0],[11,4],[10,2],[1,0]]

        Node head = new Node(7);
        Node n1 = new Node(1, null, head);
        Node n13 = new Node(13);
        Node n11 = new Node(11);
        Node n10 = new Node(10, n1, n11);
        n11.next = n10;
        n11.random = n1;
        n13.next = n11;
        n13.random = head;
        head.next = n13;
        head.random = null;

        Node copy = new CopyListWithRandomPointer().copyRandomList(head);
        System.out.println(copy);
        System.out.println(head == copy);
    }
}
