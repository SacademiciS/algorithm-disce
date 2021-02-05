package com.algorithm.disce.ctribus;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private Map<Integer, DLinkNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkNode head;
    private DLinkNode tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkNode();
        tail = new DLinkNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    private void moveToHead(DLinkNode node) {
        removeNode(node);
        addNodeToHead(node);
    }

    private void addNodeToHead(DLinkNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public void put(int key, int value) {
        DLinkNode node = cache.get(key);
        if (node == null) {
            DLinkNode newNode = new DLinkNode(key, value);
            cache.put(key, newNode);
            addNodeToHead(newNode);
            ++size;
            if (size > capacity) {
                DLinkNode tail = removeToTail();
                cache.remove(tail.key);
                --size;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private DLinkNode removeToTail() {
        DLinkNode node = tail.prev;
        removeNode(node);
        return node;
    }

    public static class DLinkNode {
        int key;
        int value;
        DLinkNode prev;
        DLinkNode next;

        DLinkNode() {

        }

        DLinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
