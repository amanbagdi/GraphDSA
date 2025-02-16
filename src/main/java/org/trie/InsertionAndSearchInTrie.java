package org.trie;

public class InsertionAndSearchInTrie {

    static Node root  = new Node();

    public static void main(String[] args) {
        String[] words = {"the", "a", "there", "their", "any"};

        for (String word: words) {
            insertWordInTrie(word);
        }
        boolean b1 = searchInTrie("there");
        if (b1) System.out.println("Found word there");
        else System.out.println("Not Found word there");

        boolean b2 = searchInTrie("thier");
        if (b2) System.out.println("Found word thier");
        else System.out.println("Not Found word thier");

        boolean b3 = searchInTrie("their");
        if (b3) System.out.println("Found word their");
        else System.out.println("Not Found word their");
    }

    public static void insertWordInTrie(String word) {
        Node current = root;

        for (int i=0; i<word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (current.children[idx] == null)
                current.children[idx] = new Node();
            if (i == word.length()-1)
                current.children[idx].eow = true;

            current = current.children[idx];
        }
    }

    public static boolean searchInTrie(String word) {
        Node currentNode = root;

        for (int i=0; i<word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (currentNode.children[idx] == null)
                return false;
            if (i == word.length()-1 && !currentNode.children[idx].eow)
                return false;

            currentNode= currentNode.children[idx];
        }
        return true;
    }

}
