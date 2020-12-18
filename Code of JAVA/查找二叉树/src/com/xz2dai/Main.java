package com.xz2dai;

public class Main {

    public static void main(String[] args) {

	    TreeNode root = BaseTreeControl.CreatBaseTree();
	    int baseHeight =  BaseTreeControl.GetHeight(root);
	    System.out.print(baseHeight);
    }
}
