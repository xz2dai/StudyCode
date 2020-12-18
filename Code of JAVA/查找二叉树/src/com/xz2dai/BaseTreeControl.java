package com.xz2dai;


import java.util.Vector;

public class BaseTreeControl {
    public static TreeNode CreatBaseTree(){
        //后序添加
        TreeNode f = new TreeNode(7);
        TreeNode c = new TreeNode(4); c.setRightNode(f);
        TreeNode a = new TreeNode(2); a.setLeftNode(c);
        TreeNode g = new TreeNode(8);
        TreeNode e = new TreeNode(6); e.setLeftNode(g);
        TreeNode d = new TreeNode(5);
        TreeNode b = new TreeNode(d,e,3);
        TreeNode root = new TreeNode(a,b,1);

        return root;
    }
    public static void DLR(TreeNode root){
        if(root == null) return;
        else{
            System.out.print(root.value+" ");
            DLR(root.LeftNode);
            DLR(root.RightNode);
        }
    }
    public static void LDR(TreeNode root){
        if(root == null) return;
        else{
            LDR(root.LeftNode);
            System.out.print(root.value+" ");
            LDR(root.RightNode);
        }
    }
    public static void LRD(TreeNode root){
        if(root == null) return;
        else{
            LRD(root.LeftNode);
            LRD(root.RightNode);
            System.out.print(root.value+" ");
        }
    }
    public static void LevelOrder(TreeNode root){
        int f=0,r=0;
        TreeNode p;
        TreeNode[] q=new TreeNode[100];
        p = root;
        if(p!=null){
            f=1;
            q[f]=p;
            r=2;
        }
        while (f!=r){
            p=q[f];
            System.out.print(p.value);
            if(p.LeftNode != null){
                q[r] = p.LeftNode;
                r=(r+1)%100;
            }
            if(p.RightNode != null){
                q[r] = p.RightNode;
                r=(r+1)%100;
            }
            f=(f+1)%100;
        }
    }
    public static int GetHeight(TreeNode root){
        int RightHeight=0,LeftHeight=0;
        if(root.LeftNode==null && root.RightNode==null){
            return 1;
        }
        if(root.RightNode != null) RightHeight=GetHeight(root.RightNode)+1;
        if(root.LeftNode != null) LeftHeight=GetHeight(root.LeftNode)+1;
        if(RightHeight >= LeftHeight) return RightHeight;
        else return LeftHeight;
    }

    public static TreeNode DeleteNode(int x,TreeNode root){
        //删除节点后中序遍历寻找后继节点
        Vector<TreeNode> TreeList = new Vector<>();

        return root;
    }


}
