package com.shareforever.intvwdemo.datastructure.tree;

import com.shareforever.intvwdemo.pojo.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DFSTree {

  public static void main(String... args) {
    System.out.println("DFS starts");

    TreeNode t1 = new TreeNode(1, null, null);
    TreeNode t3 = new TreeNode(3, null, null);
    TreeNode t2 = new TreeNode(2, t1, t3);
    TreeNode t5 = new TreeNode(5, null, null);
    TreeNode t4 = new TreeNode(4, t2, t5); // root


    // 1. inOrder traverse
    DFSTree dfsTree = new DFSTree();
    ArrayList dfsList = new ArrayList();
    dfsTree.inorder(t4, dfsList);
    System.out.println(dfsList);

//    Collections.sort(dfsList, (Comparator<Comparable>) (o1, o2) -> o2.compareTo(o1));
    System.out.println("dfsList inorder = " + dfsList);

    // 2. preorder
    dfsList = new ArrayList();
    t4 = new TreeNode(4, null, null);
    t5 = new TreeNode(5, null, null);
    t2 = new TreeNode(2, t4, t5);
    t3 = new TreeNode(3, null, null);
    t1 = new TreeNode(1, t2, t3); // root


    dfsTree.preorder(t1, dfsList);

    System.out.println("dfsList preorder = " + dfsList);

    dfsTree.postOrder(t1);
  }

  public void inorder(TreeNode treeNode , ArrayList<Integer> list) {

    if (treeNode != null) {
      // search left child
      inorder(treeNode.getLeftChild(), list);

      // search current
      list.add(treeNode.getId());

      // search right child
      inorder(treeNode.getRightChild(), list);
    }
  }


  public void preorder( TreeNode node, List<Comparable> list) {
    if (node != null) {
      // current node
      list.add(node.getId());

      // left
      preorder(node.getLeftChild(), list);

      // right
      preorder(node.getRightChild(), list);
    }
  }

  void postOrder (TreeNode node) {
    if (node !=null){
      postOrder(node.getRightChild());

      System.out.print(node.getId() + ",");

      postOrder(node.getLeftChild());
    }
  }
}
