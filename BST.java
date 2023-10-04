class TreeNode {
    String key;
    TreeNode left;
    TreeNode right;

    public TreeNode(String key) {
        this.key = key;
        left = null;
        right = null;
    }
}

public class BST {
    private TreeNode root;

    public BST() {
        root = null;
    }

    public void insert(String key) {
        long startTime = System.currentTimeMillis();

        root = insertRec(root, key);

        long endTime = System.currentTimeMillis();
        System.out.println("Insertion time for '" + key + "': " + (endTime - startTime) + " ms");
    }

    private TreeNode insertRec(TreeNode root, String key) {
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }

        if (key.compareTo(root.key) < 0) {
            root.left = insertRec(root.left, key);
        } else if (key.compareTo(root.key) > 0) {
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    public boolean search(String key) {
        long startTime = System.currentTimeMillis();

        boolean result = searchRec(root, key);

        long endTime = System.currentTimeMillis();
        System.out.println("Search time for '" + key + "': " + (endTime - startTime) + " ms");
        return result;
    }

    private boolean searchRec(TreeNode root, String key) {
        if (root == null) {
            return false;
        }

        if (key.equals(root.key)) {
            return true;
        }

        if (key.compareTo(root.key) < 0) {
            return searchRec(root.left, key);
        }

        return searchRec(root.right, key);
    }

    public void delete(String key) {
        long startTime = System.currentTimeMillis();

        root = deleteRec(root, key);

        long endTime = System.currentTimeMillis();
        System.out.println("Deletion time for '" + key + "': " + (endTime - startTime) + " ms");
    }

    private TreeNode deleteRec(TreeNode root, String key) {
        if (root == null) {
            return root;
        }

        if (key.compareTo(root.key) < 0) {
            root.left = deleteRec(root.left, key);
        } else if (key.compareTo(root.key) > 0) {
            root.right = deleteRec(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.key = minValue(root.right);

            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    private String minValue(TreeNode node) {
        String minValue = node.key;
        while (node.left != null) {
            minValue = node.left.key;
            node = node.left;
        }
        return minValue;
    }
}
