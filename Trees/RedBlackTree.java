public class RedBlackTree<T extends Comparable<T>> {

    /* Root of the tree. */
    RBTreeNode<T> root;

    static class RBTreeNode<T> {

        final T item;
        boolean isBlack;
        RBTreeNode<T> left;
        RBTreeNode<T> right;

        /* Creates a RBTreeNode with item ITEM and color depending on ISBLACK
           value. */
        RBTreeNode(boolean isBlack, T item) {
            this(isBlack, item, null, null);
        }

        /* Creates a RBTreeNode with item ITEM, color depending on ISBLACK
           value, left child LEFT, and right child RIGHT. */
        RBTreeNode(boolean isBlack, T item, RBTreeNode<T> left,
                   RBTreeNode<T> right) {
            this.isBlack = isBlack;
            this.item = item;
            this.left = left;
            this.right = right;
        }
    }

    /* Creates an empty RedBlackTree. */
    public RedBlackTree() {
        root = null;
    }

    /* Creates a RedBlackTree from a given BTree (2-3-4) TREE. */
    public RedBlackTree(BTree<T> tree) {
        Node<T> btreeRoot = tree.root;
        root = buildRedBlackTree(btreeRoot);
    }

    /* Builds a RedBlackTree that has isometry with given 2-3-4 tree rooted at
       given node R, and returns the root node. */
    RBTreeNode<T> buildRedBlackTree(Node<T> r) {
        if (r == null) {
            return null;
        }

        if (r.getItemCount() == 1) {
            // TODO: Replace with code to create a 2 node equivalent
<<<<<<< HEAD
            RBTreeNode<T> new_root = new RBTreeNode<>(true, r.getItemAt(0));
            if (r.getChildrenCount() > 0) {
                Node<T> child1 = r.getChildAt(0);
                new_root.left = buildRedBlackTree(child1);

                if (r.getChildrenCount() > 1) {
                    Node<T> child2 = r.getChildAt(1);
                    new_root.right = buildRedBlackTree(child2);
                }
            }
            return new_root;
        } else if (r.getItemCount() == 2) {
            // TODO: Replace with code to create a 3 node equivalent
            T first = r.getItemAt(0);
            T second = r.getItemAt(1);
            T val1;
            T val2;
            if (first.compareTo(second) > 0) {
                val1 = first;
                val2 = second;
            }
            else {
                val1 = second;
                val2 = first;
            }
            RBTreeNode<T> new_root = new RBTreeNode<>(true, val1);
            new_root.left = new RBTreeNode<>(false, val2);
            if (r.getChildrenCount() > 0) {
                Node<T> child1 = r.getChildAt(0);
                new_root.left.left = buildRedBlackTree(child1);

                if (r.getChildrenCount() > 1) {
                    Node<T> child2 = r.getChildAt(1);
                    new_root.left.right = buildRedBlackTree(child2);

                    if (r.getChildrenCount() > 2) {
                        Node<T> child3 = r.getChildAt(2);
                        new_root.right = buildRedBlackTree(child3);
                    }
                }
            }
            return new_root;
        } else {
            // TODO: Replace with code to create a 4 node equivalent
            T first = r.getItemAt(0);
            T second = r.getItemAt(1);
            T third = r.getItemAt(2);
            T val1;
            T val2;
            T val3;
            if (first.compareTo(second) > 0) {
                if (first.compareTo(third) > 0) {
                    val3 = first;

                    if (second.compareTo(third) > 0) {
                        val1 = second;
                        val2 = third;
                    }
                    else {
                        val1 = third;
                        val2 = second;
                    }
                }
                else {
                    val1 = first;
                    val2 = second;
                    val3 = third;
                }
            }
            else {
                if (second.compareTo(third) > 0) {
                    val3 = second;

                    if (first.compareTo(third) > 0) {
                        val1 = first;
                        val2 = third;
                    }
                    else {
                        val1 = third;
                        val2 = first;
                    }
                }
                else {
                    val1 = second;
                    val2 = first;
                    val3 = third;
                }
            }
            RBTreeNode<T> new_root = new RBTreeNode<>(true, val1);
            new_root.left = new RBTreeNode<>(false, val2);
            new_root.right = new RBTreeNode<>(false, val3);
            if (r.getChildrenCount() > 0) {
                Node<T> child1 = r.getChildAt(0);
                new_root.left.left = buildRedBlackTree(child1);

                if (r.getChildrenCount() > 1) {
                    Node<T> child2 = r.getChildAt(1);
                    new_root.left.right = buildRedBlackTree(child2);

                    if (r.getChildrenCount() > 2) {
                        Node<T> child3 = r.getChildAt(2);
                        new_root.right.left = buildRedBlackTree(child3);

                        if (r.getChildrenCount() > 3) {
                            Node<T> child4 = r.getChildAt(3);
                            new_root.right.right = buildRedBlackTree(child4);
                        }
                    }
                }
            }
            return new_root;
=======
            return null
        } else if (r.getItemCount() == 2) {
            // TODO: Replace with code to create a 3 node equivalent
            return null
        } else {
            // TODO: Replace with code to create a 4 node equivalent
            return null
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
        }
    }

    /* Flips the color of NODE and its children. Assume that NODE has both left
       and right children. */
    void flipColors(RBTreeNode<T> node) {
        node.isBlack = !node.isBlack;
        node.left.isBlack = !node.left.isBlack;
        node.right.isBlack = !node.right.isBlack;
    }

    /* Rotates the given node NODE to the right. Returns the new root node of
       this subtree. */
    RBTreeNode<T> rotateRight(RBTreeNode<T> node) {
        // TODO: YOUR CODE HERE
<<<<<<< HEAD
        RBTreeNode<T> new_root = node;
        if (node.left != null) {
            new_root = node.left;
            RBTreeNode<T> temp = new_root.right;
            new_root.right = node;
            node.left = temp;
        }
        return new_root;
=======
        return null;
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
    }

    /* Rotates the given node NODE to the left. Returns the new root node of
       this subtree. */
    RBTreeNode<T> rotateLeft(RBTreeNode<T> node) {
        // TODO: YOUR CODE HERE
<<<<<<< HEAD
        RBTreeNode<T> new_root = node;
        if (node.right != null) {
            new_root = node.right;
            RBTreeNode<T> temp = new_root.left;
            new_root.left = node;
            node.right = temp;
        }
        return new_root;
=======
        return null;
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
    }

    public void insert(T item) {   
        root = insert(root, item);  
        root.isBlack = true;    
    }

    /* Inserts the given node into this Red Black Tree*/
    private RBTreeNode<T> insert(RBTreeNode<T> node, T item) {
        // Insert (return) new red leaf node.
        if (node == null) {
            return new RBTreeNode<>(false, item);
        }

        // Handle normal binary search tree insertion.
        int comp = item.compareTo(node.item);
        if (comp == 0) {
            return node; // do nothing.
        } else if (comp < 0) {
            node.left = insert(node.left, item);
        } else {
            node.right = insert(node.right, item);
        }

        // handle case C and "Right-leaning" situation.
        

        // handle case B
        

        // handle case A
        
        // TODO: YOUR CODE HERE
        return null; //fix this return statement
    }

    /* Returns whether the given node NODE is red. Null nodes (children of leaf
       nodes are automatically considered black. */
    private boolean isRed(RBTreeNode<T> node) {
        return node != null && !node.isBlack;
    }

}
