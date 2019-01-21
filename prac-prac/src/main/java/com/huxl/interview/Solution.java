package com.huxl.interview;

/**
 * 解决方法
 *
 * @author xiaoh
 * @since 2019/1/20 16:29
 */
public class Solution {
    /**
     * 重建二叉树
     * @param pre 前序遍历结果
     * @param in 中序遍历结果
     * @return 原二叉树
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        /*
            思路
            前序遍历序列中 第一个数字总是根节点的值
            中序遍历序列中，根节点在序列中间，根节点左右分别为左子树和右子树，递归构建左右子树即可
         */
        if (pre == null || in == null || pre.length == 0 || pre.length != in.length) {
            return null;
        }

        return buildTree(pre,in,0,pre.length -1,0,in.length -1);
    }

    private TreeNode buildTree(int[] pre,int[] in,int preStart,int preEnd,int inStart,int inEnd){
        int rootValue =  pre[preStart];
        TreeNode rootNode = new TreeNode(rootValue);
        if (preStart == preEnd) {
            return rootNode;
        }

        int i = inStart,cnt = 0;
        for (; i <= inEnd; ++i) {
            if (in[i] == rootValue) {
                break;
            }
            ++cnt;
        }
        rootNode.setLeft(cnt >0 ? buildTree(pre,in,preStart+1,preStart + cnt,inStart,i-1) : null);
        rootNode.setRigth(i < inEnd ? buildTree(pre,in,preStart + cnt +1,preEnd,i + 1, inEnd) : null);
        return rootNode;
    }
}
