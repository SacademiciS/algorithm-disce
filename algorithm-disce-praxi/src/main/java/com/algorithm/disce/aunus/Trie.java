package com.algorithm.disce.aunus;

public class Trie {

//    public class TrieNode {
//        private TrieNode[] node;
//        private int R = 26;
//        private boolean isEnd;
//
//        public TrieNode() {
//            node = new TrieNode[R];
//            isEnd = false;
//        }
//
//        public void put(char c) {
//            if (!containsKey(c)) {
//                node[c - 'a'] = new TrieNode();
//            }
//        }
//
//        public TrieNode get(char c) {
//            return node[c - 'a'];
//        }
//
//        public boolean containsKey(char c) {
//            return node[c - 'a'] != null;
//        }
//
//        public void setEnd() {
//            isEnd = true;
//        }
//
//        public boolean isEnd() {
//            return isEnd;
//        }
//    }
//
//    private TrieNode root;
//
//    /**
//     * Initialize your data structure here.
//     */
//    public Trie() {
//        root = new TrieNode();
//    }
//
//    /**
//     * Inserts a word into the trie.
//     */
//    public void insert(String word) {
//        TrieNode trieNode = root;
//        for (char c : word.toCharArray()) {
//            if (!trieNode.containsKey(c)) {
//                trieNode.put(c);
//                trieNode = trieNode.get(c);
//            }
//        }
//        trieNode.setEnd();
//    }
//
//    /**
//     * Returns if the word is in the trie.
//     */
//    public boolean search(String word) {
//        TrieNode node = containPrefix(word);
//        return node != null && node.isEnd();
//    }
//
//    /**
//     * Returns if there is any word in the trie that starts with the given prefix.
//     */
//    public boolean startsWith(String prefix) {
//        return containPrefix(prefix) != null;
//    }
//
//    private TrieNode containPrefix(String word) {
//        TrieNode trieNode = root;
//        for (char c : word.toCharArray()) {
//            if (!trieNode.containsKey(c)) {
//                return null;
//            }
//            trieNode = trieNode.get(c);
//        }
//        return trieNode;
//    }

}
