package com.xz2dai;


public class TreeNode {
    public TreeNode RightNode;
    public TreeNode LeftNode;
    public int value;
    TreeNode(TreeNode leftNode,TreeNode rightNode,int value){
        setLeftNode(leftNode);
        setRightNode(rightNode);
        setValue(value);
    }
    TreeNode(int value){
        setValue(value);
    }
    public void setRightNode(TreeNode rightNode){
        this.RightNode = rightNode;
    }
    public void setLeftNode(TreeNode leftNode){
        this.LeftNode = leftNode;
    }
    public void setValue(int value){
        this.value = value;
    }
}
