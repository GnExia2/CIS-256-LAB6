/**
 * Description:
 * Main class with main method that reads book titles from books.txt and implements BST and Trie. Main method also
 * implements a speed test that compares the efficiency of BST and Trie insertion, deletion, and search operations.
 *
 * @author Cailey Murad, Alex Giang, Garrick Ngai
 * @since 10/7/23
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Reads book titles from books.txt and implements BST and Trie
 * Implements a speed test that compares the efficiency of BST and Trie insertion, deletion, and search operations
 */
public class Main {

    public static ArrayList<String> testTitles = new ArrayList<String>();
    public static long startTimeCompensated = 0;

    public static void main(String[] args) {
        // Create a BST and a Trie
        BST bst = new BST();
        Trie trie = new Trie();

        Random r = new Random();
        r.setSeed(System.nanoTime());

        // Read book titles from the text file and insert into data structures
        try (BufferedReader br = new BufferedReader(new FileReader("books.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                bst.insert(line);
                trie.insert(line);
                if (r.nextGaussian() > 0)
                    testTitles.add(line); // about 5000 of the 10000 titles will be added to the list of titles to test.
                else {
                    String fakeTitle = "" + (char) (77 + r.nextInt() % 13);
                    for (double d = -2; d < r.nextGaussian(); d += 0.05)
                        fakeTitle = fakeTitle + (char) (109 + r.nextInt() % 13);
                    testTitles.add(fakeTitle); // add fake titles to make search operations fail (worse case) so that there are 10000 test elements.
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        // Now, you have 10,000 book titles inserted into both data structures

        // Perform searches for two different books
        System.out.println("This program is a speed comparison of two structures, Binary Search Tree and Trie,");
        System.out.println("for storing titles of books with lengths ranging from 5 to 40 or more characters");
        System.out.println("and performing operations including search for a title, inserting a new title,");
        System.out.println("or deleting a title. Each operation for each data structure will be tested on the same set of");
        System.out.println("10,000 book titles, (different in each program run), and");
        System.out.println("data structure is loaded with the same list of 10,000 book titles (constant for each program run)");
        System.out.println("which can be found in books.txt. A time in nanoseconds will be displayed between the time");
        System.out.println("of the first test title is operated on (searched/inserted/deleted) and the time");
        System.out.println("when all test titles have been fully operated on for a side-by-side time comparison.");

        System.out.println("\nNow testing search operations in BST.\n");
        long startTimeCompensated = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            if (i < 4)
                System.out.println("Search for '" + getTitle(i) + "' returned " + bst.search(getTitle(i))
                        + ". \nTime so far (nanoseconds): " + (System.nanoTime() - startTimeCompensated));
            else if (i == 4)
                System.out.println("...\n(" + (10000 - 4) + " test results ommitted)\n");
            else
                bst.search(getTitle(i));
        }
        System.out.println("Total time to search test titles in BST: " + (System.nanoTime() - startTimeCompensated));
        long bstresult = (System.nanoTime() - startTimeCompensated);

        System.out.println("\n\nNow testing search operations in Trie.\n");
        startTimeCompensated = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            if (i < 4)
                System.out.println("Search for '" + getTitle(i) + "' returned " + trie.search(getTitle(i))
                        + ". \nTime so far (nanoseconds): " + (System.nanoTime() - startTimeCompensated));
            else if (i == 4)
                System.out.println("...\n(" + (10000 - 4) + " test results ommitted)\n");
            else
                trie.search(getTitle(i));
        }
        System.out.println("Total time to search test titles in Trie: " + (System.nanoTime() - startTimeCompensated));

        if ((System.nanoTime() - startTimeCompensated) > bstresult)
            System.out.println("\nBST was " + (1.0 * (System.nanoTime() - startTimeCompensated) / bstresult + " times faster."));
        else
            System.out.println("\nTrie was " + (1.0 * bstresult / (System.nanoTime() - startTimeCompensated) + " times faster."));

        System.out.println("\nNow testing deletion operations in BST.\n");
        startTimeCompensated = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            if (i < 4) {
                TreeNode result = bst.delete(getTitle(i));
                if (result != null) {
                    System.out.println("Deleted '" + getTitle(i) + "'. Time so far (nanoseconds): " + (System.nanoTime() - startTimeCompensated));
                    System.out.println(result.key);
                } else
                    System.out.println("Couldn't find '" + getTitle(i) + "'. Time so far (nanoseconds): " + (System.nanoTime() - startTimeCompensated));
            } else if (i == 4)
                System.out.println("...\n(" + (10000 - 4) + " deletions ommitted)\n");
            else
                bst.delete(getTitle(i));
        }
        System.out.println("Total time to delete test titles in BST: " + (System.nanoTime() - startTimeCompensated));
        bstresult = (System.nanoTime() - startTimeCompensated);

        System.out.println("\nNow testing deletion operations in Trie.\n");
        startTimeCompensated = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            if (i < 4) {
                boolean deleted = trie.delete(getTitle(i));
                if (deleted)
                    System.out.println("Deleted '" + getTitle(i) + "'. Time so far (nanoseconds): " + (System.nanoTime() - startTimeCompensated));
                else
                    System.out.println("Couldn't find '" + getTitle(i) + "'. Time so far (nanoseconds): " + (System.nanoTime() - startTimeCompensated));
            } else if (i == 4)
                System.out.println("...\n(" + (10000 - 4) + " deletions ommitted)\n");
            else
                trie.delete(getTitle(i));
        }
        System.out.println("Total time to insert test titles in Trie: " + (System.nanoTime() - startTimeCompensated));

        if ((System.nanoTime() - startTimeCompensated) > bstresult)
            System.out.println("\nBST was " + (1.0 * (System.nanoTime() - startTimeCompensated) / bstresult + " times faster."));
        else
            System.out.println("\nTrie was " + (1.0 * bstresult / (System.nanoTime() - startTimeCompensated) + " times faster."));


        System.out.println("\nNow testing insertion operations in BST. (Note: BST now has 5,000 titles instead of 10,000)\n");
        startTimeCompensated = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            if (i < 4) {
                bst.insert(getTitle(i));
                System.out.println("Inserted '" + getTitle(i) + "'. Time so far (nanoseconds): " + (System.nanoTime() - startTimeCompensated));
            } else if (i == 4)
                System.out.println("...\n(" + (10000 - 4) + " insertions ommitted)\n");
            else
                bst.insert(getTitle(i));
        }
        System.out.println("Total time to insert test titles in BST: " + (System.nanoTime() - startTimeCompensated));
        bstresult = (System.nanoTime() - startTimeCompensated);

        System.out.println("\nNow testing insertion operations in Trie. (Note: Trie now has 5,000 titles instead of 10,000)\n");
        startTimeCompensated = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            if (i < 4) {
                trie.insert(getTitle(i));
                System.out.println("Inserted '" + getTitle(i) + "'. Time so far (nanoseconds): " + (System.nanoTime() - startTimeCompensated));
            } else if (i == 4)
                System.out.println("...\n(" + (10000 - 4) + " insertions ommitted)\n");
            else
                trie.insert(getTitle(i));
        }
        System.out.println("Total time to insert test titles in Trie: " + (System.nanoTime() - startTimeCompensated));

        if ((System.nanoTime() - startTimeCompensated) > bstresult)
            System.out.println("\nBST was " + (1.0 * (System.nanoTime() - startTimeCompensated) / bstresult + " times faster."));
        else
            System.out.println("\nTrie was " + (1.0 * bstresult / (System.nanoTime() - startTimeCompensated) + " times faster."));


    }

    // gets the book title from the ArrayList while compensating for the time it took to get the title from the ArrayList.
    public static String getTitle(int i) {
        long startTime = System.nanoTime();
        String ret = testTitles.get(i);
        startTimeCompensated += System.nanoTime() - startTime; // compensate for time it took to get the title from the ArrayList
        return ret;
    }

}
