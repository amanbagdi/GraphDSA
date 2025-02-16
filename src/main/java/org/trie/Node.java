package org.trie;

public class Node {

    Node[] children;
    boolean eow;

    public Node() {
        children = new Node[26];
        eow = false;
    }

}
