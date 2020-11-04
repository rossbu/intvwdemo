package com.shareforever.intvwdemo.datastructure.tree;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.Vector;

import static java.lang.Math.abs;

/**
 * https://algorithms.tutorialhorizon.com/binary-search-tree-complete-implementation/
 * left < root <= right
 * The left subtree of a node contains only nodes with keys lesser than the node’s key.
 * The right subtree of a node contains only nodes with keys greater or equal than the node’s key.
 * The left and right subtree each must also be a binary search tree.
 */
public class BinarySearchTree {
    public static BST bst;

    @Data
    @Getter
    @ToString
    static class BST {

        int data;
        BST left, right = null;

        public BST(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {

        // Input: A one dimensional array  and Output: Binary Search Tree of Minimal Height
        // https://algorithms.tutorialhorizon.com/sorted-array-to-binary-search-tree-of-minimal-height/
        int[] arr = {2, 18, 3, 6, 7, 17, 8, 9, 12, 15, 16, 20};  // 12 elements
        int len = arr.length;

        // sort the tree , then create the tree
        Arrays.sort(arr);  // sort first
        bst = create(arr, 0, len - 1);
        System.out.println("root data ( after creation)is : " + bst.data);

        // is height-balanced Binary Tree?
        System.out.println("balanced tree? " + isBalanced(bst));

        // insert a node to the tree
        insertRecursive(bst, 40); // insert recursively  , which needs a entry root, recursive methods can use the new 'root'.
        insertIterative(11);  // insert iteratively

        // inOrder display
        System.out.println("\n---in Order traversal tree  (LNR)---");
        inOrderTraversal(bst);

        // preOrder display
        System.out.println("\n\n---pre Order traversal tree (NLR) ---");
        preOrderTraversal(bst);

        // postOrder display
        System.out.println("\n\n---post Order traversal tree (LRN) ---");
        postOrderTraversal(bst);

        // preOrder but graphic display
        System.out.println("\n\n---pre Order graphic tree ---");
        System.out.println(traversePreOrder(bst));

        // search key
        System.out.println("\n---search the tree ---");
        BST searched = search(11);
        System.out.println(searched == null ? "not found " : "found:" + searched);

        // delete leaf, one child, 2 children  -- either one of 3 cases
        deleteKey(12);


    }

    /*
        Create a Balanced BST - BBST
        1) Get the Middle of the array and make it root.
        2) Recursively do same for left half and right half.
              a) Get the middle of left half and make it left child of the root
                  created in step 1.
              b) Get the middle of right half and make it right child of the
                  root created in step 1.

    */
    static BST create(int[] arr, int start, int end) {
        if (start > end)
            return null;

        // find the middle node from a sorted array
        int mid = (start + end) / 2;
        BST root = new BST(arr[mid]);

        // left tree using recur
        root.left = create(arr, start, mid - 1);

        // right tree using recur
        root.right = create(arr, mid + 1, end);

        // return parent root which contains all sub-trees
        return root;
    }


    /*
        find only one pointer to move left or right
     */
    static BST search(int key) {
        BST current = bst;
        // loop whole tree do : == , < , >=   3 conditions.
        while (current != null) {
            if (key == current.data) {
                return current;
            } else if (key < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null; // not found.
    }

    /*
        needs 2 points slow and fast ( parent and current).
        iteratively insert a key to binary tree
     */
    static void insertIterative(int key) {
        BST newnode = new BST(key);

        if (bst == null) {
            bst = newnode;
            return;
        }

        // 2 points, one is on parent ( slow ) , one is on current ( fast )
        BST current = bst;  // root
        BST parent;

        while (true) {
            parent = current;
            if (key < current.data) {
                current = current.left;
                if (current == null) {
                    parent.left = newnode;
                    return;
                }
            } else {
                current = current.right;
                if (current == null) {
                    parent.right = newnode;
                    return;
                }
            }
        }
    }


    static BST insertRecursive(BST root, int key) {
        // when null return a new tree
        if (root == null) return new BST(key);

        // left < key <= right
        if (key < root.data)
            root.left = insertRecursive(root.left, key);
        if (key >= root.data)
            root.right = insertRecursive(root.right, key);

        return root;
    }

    /*
        https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/
        https://algorithms.tutorialhorizon.com/binary-search-tree-complete-implementation/

        0 children -  leaf
              50                            50
           /     \         delete(20)      /   \
          30      70       --------->    30     70
         /  \    /  \                     \    /  \
       20   40  60   80                   40  60   80

       1 child.
              50                             50
           /     \         delete(30)      /   \
          30      70       --------->    40     70
            \    /  \                          /  \
            40  60   80                       60   80

       2 children.
              50                             60
           /     \         delete(50)      /   \
          40      70       --------->    40    70
                 /  \                            \
                60   80                           80
     */
    static boolean deleteKey(int key) {

        // find the node
        boolean isLeftChild = false;
        boolean isRightChild = false;
        BST current = bst; // the node with key
        BST parent = bst;  // you have to know the parent and the 'current' node, so that you can link the node properly.

        while (current != null) {
            if (key == current.data) {
                break;
            } else if (key < current.data) {
                parent = current;
                current = current.left;
                isLeftChild = true;
            } else {
                parent = current;
                current = current.right;
                isLeftChild = false;
            }
        }

        // delete the node for either of 3 cases.
        if (current.left == null && current.right == null) {  // 0 child   -  2 nodes leaf or only one node as root
            if (current == bst) {  // root
                bst = null;
            }
            if (isLeftChild) { // left leaf
                parent.left = null;
            } else { // right leaf
                parent.right = null;
            }
        } else if (current.right == null) {   // 1 left child


        } else if (current.left == null) { // 1 right child

        } else {    //2 children

        }
        // todo
        return false;
    }

    /*
        in-order traversal to display
     */
    static void inOrderTraversal(BST root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.data + " ");
            inOrderTraversal(root.right);
        }
    }

    static void preOrderTraversal(BST root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    static void postOrderTraversal(BST root) {
        if (root != null) {
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
            System.out.print(root.data + " ");
        }
    }

    static boolean isLeaf(BST node) {
        if (node.left == null && node.right == null)
            return true;
        return false;
    }

    /*
    https://stackoverflow.com/questions/742844/how-to-determine-if-binary-tree-is-balanced
    Excellent answer. I think it meets all the requirement's that Eric posted regarding Bonus and Super-Bonus.
    It's iterative (using a queue) and not recursive - so call-stack won't be overflowed and we move all memory-issues to heap.
    It doesn't even requires traversing the entire tree.
    It moves level by level, so if a tree is grossly unbalanced to 1 side,
    it will find it really soon (soonest? well sooner than most recursive algorithms,
    though you could implement a post-order traversal iterative algorithm which will find last-level unbalances sooner but will act poorer on first levels). So +1
     */
    static boolean isBalanced(BST root) {
        if (root == null) {
            return true;
        }
        Vector<BST> queue = new Vector<BST>();
        int level = 1, minLevel = Integer.MAX_VALUE, maxLevel = Integer.MIN_VALUE;
        queue.add(root);
        while (!queue.isEmpty()) {
            int elementCount = queue.size();
            while (elementCount > 0) {
                BST node = queue.remove(0);
                if (isLeaf(node)) {
                    if (minLevel > level)
                        minLevel = level;
                    if (maxLevel < level)
                        maxLevel = level;
                } else {
                    if (node.left != null)
                        queue.add(node.left);
                    if (node.right != null)
                        queue.add(node.right);
                }
                elementCount--;
            }
            if (abs(maxLevel - minLevel) > 1) {
                return false;
            }
            level++;
        }
        return true;
    }


    /*
        this is for graphy presentation in the output
     */
    static String traversePreOrder(BST root) {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.getData());

        String pointerRight = "└──";
        String pointerLeft = (root.getRight() != null) ? "├──" : "└──";

        traverseNodes(sb, "", pointerLeft, root.getLeft(), root.getRight() != null);
        traverseNodes(sb, "", pointerRight, root.getRight(), false);

        return sb.toString();
    }

    static void traverseNodes(StringBuilder sb, String padding, String pointer, BST node,
                              boolean hasRightSibling) {
        if (node != null) {
            sb.append("\n");
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.getData());

            StringBuilder paddingBuilder = new StringBuilder(padding);
            if (hasRightSibling) {
                paddingBuilder.append("│  ");
            } else {
                paddingBuilder.append("   ");
            }

            String paddingForBoth = paddingBuilder.toString();
            String pointerRight = "└──";
            String pointerLeft = (node.getRight() != null) ? "├──" : "└──";

            traverseNodes(sb, paddingForBoth, pointerLeft, node.getLeft(), node.getRight() != null);
            traverseNodes(sb, paddingForBoth, pointerRight, node.getRight(), false);
        }
    }
}
