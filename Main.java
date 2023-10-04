import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        // Create a BST and a Trie
        BST bst = new BST();
        Trie trie = new Trie();

        // Read book titles from the text file and insert into data structures
        try (BufferedReader br = new BufferedReader(new FileReader("books.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                bst.insert(line);
                trie.insert(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Now, you have 10,000 book titles inserted into both data structures

        // Perform searches for two different books
        String book1 = "1984";
        String book2 = "To Kill a Mockingbird";

        System.out.println("Search Result in BST:");
        System.out.println("Search for '" + book1 + "': " + bst.search(book1));
        System.out.println("Search for '" + book2 + "': " + bst.search(book2));

        System.out.println("\nSearch Result in Trie:");
        System.out.println("Search for '" + book1 + "': " + trie.search(book1));
        System.out.println("Search for '" + book2 + "': " + trie.search(book2));
    }
}