import java.util.HashMap;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        long startTime = System.currentTimeMillis();

        TrieNode current = root;
        for (char c : word.toCharArray()) {
            current.children.putIfAbsent(c, new TrieNode());
            current = current.children.get(c);
        }
        current.isEndOfWord = true;

        long endTime = System.currentTimeMillis();
        System.out.println("Insertion time for '" + word + "': " + (endTime - startTime) + " ms");
    }

    public boolean search(String word) {
        long startTime = System.currentTimeMillis();

        TrieNode current = root;
        for (char c : word.toCharArray()) {
            if (!current.children.containsKey(c)) {
                long endTime = System.currentTimeMillis();
                System.out.println("Search time for '" + word + "': " + (endTime - startTime) + " ms");
                return false;
            }
            current = current.children.get(c);
        }
        boolean result = current.isEndOfWord;

        long endTime = System.currentTimeMillis();
        System.out.println("Search time for '" + word + "': " + (endTime - startTime) + " ms");
        return result;
    }

    public void delete(String word) {
        long startTime = System.currentTimeMillis();

        delete(root, word, 0);

        long endTime = System.currentTimeMillis();
        System.out.println("Deletion time for '" + word + "': " + (endTime - startTime) + " ms");
    }

    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.isEndOfWord) {
                return false;
            }
            current.isEndOfWord = false;
            return current.children.isEmpty();
        }
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDelete = delete(node, word, index + 1);
        if (shouldDelete) {
            current.children.remove(ch);
            return current.children.isEmpty();
        }
        return false;
    }
}
