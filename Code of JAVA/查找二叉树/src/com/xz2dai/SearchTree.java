package com.xz2dai;

public class SearchTree {
    public static TreeNode Find(int x, TreeNode root) {
        if (root == null)
            return null;
        else if (x < root.value)
            return Find(x, root.LeftNode);
        else if (x > root.value)
            return Find(x, root.RightNode);
        else return root;
    }

    public static TreeNode FindMin(TreeNode root) {
        if (root == null)
            return null;
        else if (root.LeftNode == null)
            return root;
        else return FindMin(root.LeftNode);
    }

    public static TreeNode FindMax(TreeNode root) {
        if (root == null)
            return null;
        if (root.RightNode == null)
            return root;
        else return FindMax(root.RightNode);
    }

    public static TreeNode Insert(int x, TreeNode root) {
        if (root == null) {
            root = new TreeNode(x);
            return root;
        } else {
            if (x < root.value) {
                if (root.LeftNode == null) root.LeftNode = new TreeNode(x);
                else root.LeftNode = Insert(x, root.LeftNode);
            } else if (x > root.value) {
                if (root.RightNode == null) root.RightNode = new TreeNode(x);
                else root.RightNode = Insert(x, root.RightNode);
            }
        }
        int diff = BaseTreeControl.GetHeight(root.LeftNode) - BaseTreeControl.GetHeight(root.RightNode);
        if(diff !=0 && diff !=1){
            root = CorrectTree(root);
        }
        return root;
    }

    public static TreeNode CorrectTree(TreeNode root){
        //先找到最后一个高度不平衡的子树
        //判断用LL、RR、LR、RL中的哪一种
        return root;
    }

    public static TreeNode LL(TreeNode root) {
        TreeNode tempNodeK1, tempNodeK2;
        tempNodeK2 = root;
        tempNodeK1 = root.LeftNode;
        tempNodeK2.LeftNode = tempNodeK1.RightNode;
        tempNodeK1.RightNode = tempNodeK2;
        return tempNodeK1;
    }

    public static TreeNode RR(TreeNode root) {
        TreeNode tempNodeK1, tempNodeK2;
        tempNodeK2 = root;
        tempNodeK1 = root.RightNode;
        tempNodeK2.RightNode = tempNodeK1.LeftNode;
        tempNodeK1.LeftNode = tempNodeK2;
        return tempNodeK1;
    }

    public static TreeNode LR(TreeNode root) {
        TreeNode tempNodeK1, tempNodeK2, tempNodeK3;
        tempNodeK3 = root;
        tempNodeK1 = root.LeftNode;
        tempNodeK2 = tempNodeK1.RightNode;

        tempNodeK2.LeftNode = tempNodeK1;
        tempNodeK1.RightNode = null;        //To LL

        if (tempNodeK2.RightNode != null) tempNodeK3.LeftNode = tempNodeK2.RightNode;
        else tempNodeK3.LeftNode = tempNodeK2.LeftNode;
        tempNodeK2.RightNode = tempNodeK3;

        return tempNodeK2;
    }

    public static TreeNode RL(TreeNode root) {
        TreeNode tempNodeK1, tempNodeK2, tempNodeK3;
        tempNodeK3 = root;
        tempNodeK1 = root.RightNode;
        tempNodeK2 = tempNodeK1.LeftNode;

        tempNodeK2.RightNode = tempNodeK1;
        tempNodeK1.LeftNode = null;        //To RR

        if (tempNodeK2.LeftNode != null) tempNodeK3.RightNode = tempNodeK2.LeftNode;
        else tempNodeK3.RightNode = tempNodeK2.RightNode;
        tempNodeK2.LeftNode = tempNodeK3;

        return tempNodeK2;
    }
}
