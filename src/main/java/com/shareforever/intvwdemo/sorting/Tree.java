package com.shareforever.intvwdemo.sorting;


public class Tree {
    public static void main(String[] args) {
        Sum();
    }

    private static void Sum() {
        // design a binary tree and find sum of all values of the tree
        Node node7 = new Node(7, null, null);
        Node node6 = new Node(6, node7, null);
        Node node5 = new Node(5, null, null);
        Node node4 = new Node(4, node5, node6);
        Node node3 = new Node(3, node4, null);
        Node node2 = new Node(2, null, null);
        Node node1 = new Node(1, node2, node3);

        // caculate sum of tree
        int sum = findSum(node1);
        System.out.println("sum: " + sum);
    }

    // recursive to find all node until no child ( which means null )
    static int findSum(Node node) {
        if (node == null) return 0;
        Node left = node.getLeft();
        Node right = node.getRight();
        int sum = node.getValue();
        int leftSum = findSum(left);
        int rightSum = findSum(right);
        if (left != null) {
            sum += leftSum;
        }
        if (right != null) {
            sum += rightSum;
        }
        return sum;
    }
}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
