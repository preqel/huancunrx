package com.preqel.treenode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by preqel on 2018/9/26.
 *
 * //
 */


public class TreeNode {

    private TreeNode lChild;

    private TreeNode rChild;

    private TreeNode mRoot;

    private List<TreeNode> datas;

    private Object data ;



    public TreeNode(){

    }

    public TreeNode(Object obj){
        this(null,null,obj);
    }
    public TreeNode(TreeNode left,TreeNode right,Object data){
        this.lChild= left;
        this.rChild = right;
        this.data = data;
    }


    public void createTree(Object[] objs) {
        datas = new ArrayList<TreeNode>();
        for (Object obj : objs)
            datas.add(new TreeNode(obj));
        mRoot = datas.get(0);
        for (int i = 0; i < objs.length / 2; i++) {
            datas.get(i).lChild = datas.get(i * 2 + 1);
            if (i * 2 + 2 < datas.size()) {
                datas.get(i).rChild = datas.get(i * 2 + 2);
            }
        }
    }
        //todo 按层次遍历二叉树 算法 经典
            public ArrayList<Object> printFromTopBottom(TreeNode treeNode){
        ArrayList<Object> list = new ArrayList<Object>();
        Queue<TreeNode> queue = new ArrayBlockingQueue<TreeNode>(100);

        TreeNode last = mRoot;
        TreeNode nLast = mRoot;
        queue.add(treeNode);
        while(!queue.isEmpty()){

            TreeNode out  = queue
                    .poll();
            System.out.println(out.data+" ");

            list.add(out.data);
            if(out.lChild!= null) {
                queue.add(out.lChild);
                nLast   = out.lChild;
            }
            if(out.rChild!= null){
                queue.add(out.rChild);
                nLast = out.rChild;
            }
            if(out == last){
                System.out.println("");
                last= nLast;
            }

        }

        return list;
    }



    public Object getData() {
        return data;
    }

    public TreeNode getLeft() {
        return lChild;
    }
    public TreeNode getRight(){
                return rChild;
    }

}
