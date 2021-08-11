<<<<<<< HEAD
import java.util.*;
=======
import java.util.ArrayList;
import java.util.Iterator;
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65

/* An AmoebaFamily is a tree, where nodes are Amoebas, each of which can have
   any number of children. */
public class AmoebaFamily implements Iterable<AmoebaFamily.Amoeba> {

    /* ROOT is the root amoeba of this AmoebaFamily */
    private Amoeba root = null;
<<<<<<< HEAD
    public static int size = 0;
=======
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65

    /* Creates an AmoebaFamily, where the first Amoeba's name is NAME. */
    public AmoebaFamily(String name) {
        root = new Amoeba(name, null);
    }

    /* Adds a new Amoeba with CHILDNAME to this AmoebaFamily as the youngest
       child of the Amoeba named PARENTNAME. This AmoebaFamily must contain an
       Amoeba named PARENTNAME. */
    public void addChild(String parentName, String childName) {
        if (root != null) {
            root.addChildHelper(parentName, childName);
        }
    }

    /* Prints the name of all Amoebas in this AmoebaFamily in preorder, with
       the ROOT Amoeba printed first. Each Amoeba should be indented four spaces
       more than its parent. */
    public void print() {
<<<<<<< HEAD
        if (root != null) {
            printerHelper(root);
        }
    }

    public static void create_space(int size) {
        for (; size >= 1; size--) {
            System.out.print("    ");
        }
    }

    private static void printerHelper(Amoeba curr) {
        if (curr == null) {
            create_space(size);
            System.out.println(curr.name);
        }
        create_space(size);
        System.out.println(curr.name);
        size+= 1;
        Iterator<Amoeba> iterator1 = curr.children.iterator();
        while (iterator1.hasNext()) {
            create_space(size);
            AmoebaFamily.printerHelper(iterator1.next());
        }
        size-= 1;
    }



    /* Returns the length of the longest name in this AmoebaFamily. */
    public int longestNameLength() {
        return 0;
    }


    /* Returns the longest name in this AmoebaFamily. */
    public String longestName() {
        return " ";
    }



    /* Returns an Iterator for this AmoebaFamily. */
    public Iterator<Amoeba> iterator2() {
        return new AmoebaDFSIterator();
    }


    /* Returns an Iterator for this AmoebaFamily. */
    public Iterator<Amoeba> iterator() {
        return new AmoebaBFSIterator();
    }


    /* Creates a new AmoebaFamily and prints it out. */
    public static void main(String[] args) {

=======
        // TODO: YOUR CODE HERE
    }

    /* Returns the length of the longest name in this AmoebaFamily. */
    public int longestNameLength() {
        if (root != null) {
            return root.longestNameLengthHelper();
        }
        return 0;
    }

    /* Returns the longest name in this AmoebaFamily. */
    public String longestName() {
        // TODO: YOUR CODE HERE
        return "";
    }

    /* Returns an Iterator for this AmoebaFamily. */
    public Iterator<Amoeba> iterator() {
        return new AmoebaDFSIterator();
    }

    /* Creates a new AmoebaFamily and prints it out. */
    public static void main(String[] args) {
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
        AmoebaFamily family = new AmoebaFamily("Amos McCoy");
        family.addChild("Amos McCoy", "mom/dad");
        family.addChild("Amos McCoy", "auntie");
        family.addChild("mom/dad", "me");
        family.addChild("mom/dad", "Fred");
        family.addChild("mom/dad", "Wilma");
        family.addChild("me", "Mike");
        family.addChild("me", "Homer");
        family.addChild("me", "Marge");
        family.addChild("Mike", "Bart");
        family.addChild("Mike", "Lisa");
        family.addChild("Marge", "Bill");
        family.addChild("Marge", "Hilary");
<<<<<<< HEAD


        System.out.println("Here's the family:");
        family.print();



        Iterator<Amoeba> DFSiter = family.iterator();
        while (DFSiter.hasNext()) {
            System.out.println(DFSiter.next());
        }

        System.out.println("\n");

        Iterator<Amoeba> BFSiter = family.iterator();
        while (BFSiter.hasNext()) {
            System.out.println(BFSiter.next());
        }
    }


=======
        System.out.println("Here's the family:");
        family.print();
    }

>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
    /* An Amoeba is a node of an AmoebaFamily. */
    public static class Amoeba {

        private String name;
        private Amoeba parent;
        private ArrayList<Amoeba> children;

        public Amoeba(String name, Amoeba parent) {
            this.name = name;
            this.parent = parent;
            this.children = new ArrayList<Amoeba>();
        }

        public String toString() {
            return name;
        }

        public Amoeba getParent() {
            return parent;
        }

        public ArrayList<Amoeba> getChildren() {
            return children;
        }

        /* Adds child with name CHILDNAME to an Amoeba with name PARENTNAME. */
        public void addChildHelper(String parentName, String childName) {
            if (name.equals(parentName)) {
                Amoeba child = new Amoeba(childName, this);
                children.add(child);
            } else {
                for (Amoeba a : children) {
                    a.addChildHelper(parentName, childName);
                }
            }
        }

        /* Returns the length of the longest name between this Amoeba and its
           children. */
        public int longestNameLengthHelper() {
            int maxLengthSeen = name.length();
            for (Amoeba a : children) {
                maxLengthSeen = Math.max(maxLengthSeen,
<<<<<<< HEAD
                        a.longestNameLengthHelper());
=======
                                         a.longestNameLengthHelper());
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
            }
            return maxLengthSeen;
        }

<<<<<<< HEAD
        //to do: arraylist;
=======
        // TODO: ADD HELPER FUNCTIONS HERE
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65

    }

    /* An Iterator class for the AmoebaFamily, running a DFS traversal on the
       AmoebaFamily. Complete enumeration of a family of N Amoebas should take
       O(N) operations. */
    public class AmoebaDFSIterator implements Iterator<Amoeba> {

<<<<<<< HEAD
        /* AmoebaDFSIterator constructor. Sets up all of the initial information
           for the AmoebaDFSIterator. */
        private Stack<Amoeba> fringe = new Stack<Amoeba>();

        public AmoebaDFSIterator() {
            if (root != null) {
                this.fringe.push(root);
            }
=======
        // TODO: IMPLEMENT THE CLASS HERE

        /* AmoebaDFSIterator constructor. Sets up all of the initial information
           for the AmoebaDFSIterator. */
        public AmoebaDFSIterator() {
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
        }

        /* Returns true if there is a next element to return. */
        public boolean hasNext() {
<<<<<<< HEAD
            return !(fringe.empty());
=======
            return false;
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
        }

        /* Returns the next element. */
        public Amoeba next() {
<<<<<<< HEAD
            if (!hasNext()) {
                throw new IllegalArgumentException();
            }

            Amoeba curr = this.fringe.pop();
            if (curr.children != null) {
                for (int size_of_child = curr.children.size(); size_of_child > 0; size_of_child--) {
                    this.fringe.push(curr.children.get(size_of_child - 1));
                }
            }
            return curr;
=======
            return null;
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* An Iterator class for the AmoebaFamily, running a BFS traversal on the
       AmoebaFamily. Complete enumeration of a family of N Amoebas should take
       O(N) operations. */
    public class AmoebaBFSIterator implements Iterator<Amoeba> {

<<<<<<< HEAD
        private Queue<Amoeba> fringe = new LinkedList<Amoeba>();

        /* AmoebaBFSIterator constructor. Sets up all of the initial information
           for the AmoebaBFSIterator. */

        public AmoebaBFSIterator() {
            if (root != null) {
                this.fringe.add(root);
            }
=======
        // TODO: IMPLEMENT THE CLASS HERE

        /* AmoebaBFSIterator constructor. Sets up all of the initial information
           for the AmoebaBFSIterator. */
        public AmoebaBFSIterator() {
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
        }

        /* Returns true if there is a next element to return. */
        public boolean hasNext() {
<<<<<<< HEAD
            return !(this.fringe.isEmpty());
=======
            return false;
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
        }

        /* Returns the next element. */
        public Amoeba next() {
<<<<<<< HEAD
            if (!hasNext()) {
                throw new IllegalArgumentException();
            }
            Amoeba curr = this.fringe.poll();
            if (curr.children != null) {
                int size_of_child = curr.children.size();
                for (int i = 0; i < size_of_child; i++)  {
                    fringe.add(curr.children.get(i));
                }
            }
            return curr;
=======
            return null;
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 13eef6096e842d8d55a0eb148f915e7d4f861c65
