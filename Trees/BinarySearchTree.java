public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {

    /* Creates an empty BST. */
    public BinarySearchTree() {
        // TODO: YOUR CODE HERE
<<<<<<< HEAD
        super();
=======
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
    }

    /* Creates a BST with root as ROOT. */
    public BinarySearchTree(TreeNode root) {
        // TODO: YOUR CODE HERE
<<<<<<< HEAD
        super(root);
    }

    private boolean key_search(TreeNode node, T wanted_key) {
        if (node.item == wanted_key) {
            return true;
        }
        else {
            boolean found_in_left = false;
            boolean found_in_right = false;
            if (node.left != null) {
                found_in_left = key_search(node.left, wanted_key);
            }
            if (node.right != null) {
                found_in_right = key_search(node.right, wanted_key);
            }
            return found_in_left || found_in_right;
        }
=======
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
    }

    /* Returns true if the BST contains the given KEY. */
    public boolean contains(T key) {
        // TODO: YOUR CODE HERE
<<<<<<< HEAD
        if (this.root == null) {
            return false;
        }
        else {
            return key_search(this.root, key);
        }
    }

    private void add_to_bst(TreeNode node, T key) {
        if (node.item.compareTo(key) == 0) {
            return;
        }
        else if (node.item.compareTo(key) < 0) {
            if (node.right == null) {
                node.right = new TreeNode(key);
            }
            else {
                add_to_bst(node.right, key);
            }
        }
        else if (node.item.compareTo(key) > 0) {
            if (node.left == null) {
                node.left = new TreeNode(key);
            }
            else {
                add_to_bst(node.left, key);
            }
        }
=======
        return false;
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
    }

    /* Adds a node for KEY iff KEY isn't in the BST already. */
    public void add(T key) {
        // TODO: YOUR CODE HERE
<<<<<<< HEAD
        if (this.root == null) {
            this.root = new TreeNode(key);
        }
        else {
            add_to_bst(this.root, key);
        }
=======
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
    }

    /* Deletes a node from the BST. 
     * Even though you do not have to implement delete, you 
     * should read through and understand the basic steps.
    */
    public T delete(T key) {
        TreeNode parent = null;
        TreeNode curr = root;
        TreeNode delNode = null;
        TreeNode replacement = null;
        boolean rightSide = false;

        while (curr != null && !curr.item.equals(key)) {
            if (curr.item.compareTo(key) > 0) {
                parent = curr;
                curr = curr.left;
                rightSide = false;
            } else {
                parent = curr;
                curr = curr.right;
                rightSide = true;
            }
        }
        delNode = curr;
        if (curr == null) {
            return null;
        }

        if (delNode.right == null) {
            if (root == delNode) {
                root = root.left;
            } else {
                if (rightSide) {
                    parent.right = delNode.left;
                } else {
                    parent.left = delNode.left;
                }
            }
        } else {
            curr = delNode.right;
            replacement = curr.left;
            if (replacement == null) {
                replacement = curr;
            } else {
                while (replacement.left != null) {
                    curr = replacement;
                    replacement = replacement.left;
                }
                curr.left = replacement.right;
                replacement.right = delNode.right;
            }
            replacement.left = delNode.left;
            if (root == delNode) {
                root = replacement;
            } else {
                if (rightSide) {
                    parent.right = replacement;
                } else {
                    parent.left = replacement;
                }
            }
        }
        return delNode.item;
    }
}