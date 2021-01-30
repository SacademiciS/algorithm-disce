package com.algorithm.disce.template;

public class TrieNode {

    private TrieNode[] links;

    private boolean isEnd;

    private final int R = 26;

    public TrieNode() {
        links = new TrieNode[R];
    }

    public boolean containKey(char c) {
        return links[c - 'a'] != null;
    }

    public TrieNode get(char c) {
        return links[c - 'a'];
    }

    public void put(char c, TrieNode node) {
        links[c - 'a'] = node;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}
