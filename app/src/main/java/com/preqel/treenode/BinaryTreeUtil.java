package com.preqel.treenode;

import java.util.Stack;

/**
 * Created by preqel on 2018/9/26.
 */

public class BinaryTreeUtil {


    public static void  preorderTraversalRec(TreeNode root){

        if(root == null) return ;
        System.out.println(root.getData());
        preorderTraversalRec(root.getLeft());
        preorderTraversalRec(root.getRight());
    }

    public static void preorderTraversalStack(TreeNode root){
        if(root == null )return ;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){

            TreeNode cur = stack.pop();

            System.out.println(cur.getData().toString());

            if(cur.getRight()!= null)//先押入右子节点，这样弹栈的时候先出左子节点
            {
                stack.push(cur.getRight());
            }
            if(cur.getLeft()!= null){
                stack.push(cur.getLeft());
            }
        }
    }
}
