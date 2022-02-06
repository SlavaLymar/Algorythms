package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    static class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
    }

    private void addNode(DLinkedNode node) {
        /**
         * Always add the new node right after head.
         */
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node){
        /**
         * Remove an existing node from the linked list.
         */
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void moveToHead(DLinkedNode node){
        /**
         * Move certain node in between to the head.
         */
        removeNode(node);
        addNode(node);
    }

    private DLinkedNode popTail() {
        /**
         * Pop the current tail.
         */
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    // head <-> tail
    // put(1,1)
    // head <-> {1:1} <-> tail
    // put(2,2)
    // head <-> {1:1} <-> {2:2} <-> tail
    // put(3,3)
    // head <-> {2:2} <-> {3:3} <-> tail
    // get(2)
    // head <-> {3:3} <-> {2:2} <-> tail
    //
    // t: O (1)
    // space: O (N)
    //
    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        // head.prev = null;

        tail = new DLinkedNode();
        // tail.next = null;

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) return -1;

        // move the accessed node to the head;
        moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);

        if(node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            cache.put(key, newNode);
            addNode(newNode);

            ++size;

            if(size > capacity) {
                // pop the tail
                DLinkedNode tail = popTail();
                cache.remove(tail.key);
                --size;
            }
        } else {
            // update the value.
            node.value = value;
            moveToHead(node);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
//        ["LRUCache","get","put","get","put","put","get","get"]
//[[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
        int v2 = cache.get(2);
        cache.put(2,6);
        int v1 = cache.get(1);
        cache.put(1,5);
        cache.put(1,2);
        v1 = cache.get(1);
        v2 = cache.get(2);
        System.out.println();
    }
}
