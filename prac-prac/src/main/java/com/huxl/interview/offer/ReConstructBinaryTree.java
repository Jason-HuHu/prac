package com.huxl.interview.offer;

/**
 * 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}
 * 和中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建二叉树并返回。
 *
 * @author huxl
 */
public class ReConstructBinaryTree {

    public static void main(String[] args) {

    }

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            val = val;
        }
    }


    /**
     *
     * @param pre 前序遍历结果
     * @param in 中序遍历结果
     * @return 二叉树
     */
    public TreeNode rebuildTree(int[] pre,int[] in){
        if (pre.length == 0 || in.length == 0) {
            return null;
        }

        return reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
    }

    /**
     *
     * @param pre 前序遍历结果
     * @param preStart 前序遍历坐标
     * @param preEnd 前序遍历终止坐标
     * @param in 中序遍历结果
     * @param inStart 中序遍历起始坐标
     * @param inEnd 中序遍历结束坐标
     * @return 二叉树
     */
    private TreeNode reConstructBinaryTree(int[] pre,int preStart,int preEnd,int[] in,int inStart,int inEnd){
        //递归终止条件
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        //构建二叉树,前序遍历的第一个节点为根节点
        TreeNode root = new TreeNode(pre[preStart]);
        //
        for (int i=inStart;i <= inEnd; i++) {

            if (in[i] == pre[preStart]) {
                root.left = reConstructBinaryTree(pre,preStart+1,preStart+i-inStart,in,inStart,i-1);
                root.right = reConstructBinaryTree(pre,i-inStart+preStart +1,preEnd,in,i+1,inEnd);
            }
        }

        return root;
    }
}
