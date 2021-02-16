package com.algorithm.disce.bduo;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private Map<Integer, DLinkNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkNode head,tail;

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

    public void put(int key, int value) {
        DLinkNode node = cache.get(key);
        if (node == null) {
            DLinkNode newNode = new DLinkNode(key, value);
            cache.put(key, newNode);
            //注意！！！ 记得要加入链表
            addToHead(newNode);
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

    private void moveToHead(DLinkNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(DLinkNode node) {
        node.prev = head;
        node.next = head.next;
        //注意！！！
        //head.next.prev = node 要放在 head.next = node 前面
        //如果颠倒过来, head.next.prev = node 则会变成 node.prev = node 重复指向自己节点
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private static class DLinkNode {
        int key;
        int value;
        DLinkNode prev;
        DLinkNode next;

        DLinkNode() {

        }

        DLinkNode(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

}
