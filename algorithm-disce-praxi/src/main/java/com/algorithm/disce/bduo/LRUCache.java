package com.algorithm.disce.bduo;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wjh
 * @Description
 * @Date: 2021/2/1 16:24
 * Copyright (c) 2019 北京新媒传信科技有限公司
 */
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
        return -1;
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
