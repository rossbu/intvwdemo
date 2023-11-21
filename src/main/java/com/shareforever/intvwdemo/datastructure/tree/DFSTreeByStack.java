package com.shareforever.intvwdemo.datastructure.tree;

import com.shareforever.intvwdemo.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFSTreeByStack {

  public static void main(String... args) {
    System.out.println("DFS Stack starts");

    TreeNode t1 = new TreeNode(1, null, null);
    TreeNode t3 = new TreeNode(3, null, null);
    TreeNode t2 = new TreeNode(2, t1, t3);
    TreeNode t5 = new TreeNode(5, null, null);
    TreeNode t4 = new TreeNode(4, t2, t5); // root


    // 1. inOrder traverse
    DFSTreeByStack dfsTree = new DFSTreeByStack();
    ArrayList dfsList = new ArrayList();
    dfsTree.inorder(t4, dfsList);
    System.out.println(dfsList);

//    Collections.sort(dfsList, (Comparator<Comparable>) (o1, o2) -> o2.compareTo(o1));
    System.out.println("dfsList inorder = " + dfsList);

  }

  public void inorder(TreeNode treeNode , ArrayList<Integer> list) {
    if (treeNode == null ) return ;

    Stack stack  = new Stack();


    if (treeNode != null) {

    }
  }


}
