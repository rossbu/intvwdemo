package com.shareforever.intvwdemo.pojo;

public class TreeNode {

    private int id;
    private TreeNode leftChild, rightChild;

    public TreeNode(int id) {
        this.id=id;
    }

    public TreeNode(int id, TreeNode leftChild, TreeNode rightChild){
        this.id = id;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }
}
