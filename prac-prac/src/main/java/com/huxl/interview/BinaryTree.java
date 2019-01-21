package com.huxl.interview;

/**
 * 二叉树相关操作
 *
 * @author xiaoh
 * @since 2019/1/20 16:27
 */
public class BinaryTree {
    public static void main(String[] args) {
        //重建二叉树
        Solution solution = new Solution();
        int[] pre = {1,2,3,4,5,6,7};
        int[] in = {3,2,4,1,6,5,7};

        TreeNode treeNode = solution.reConstructBinaryTree(pre,in);
        System.out.println(treeNode.getVal());
    }

}

class TreeNode{
    private int val;
    private TreeNode left;
    private TreeNode rigth;

    public TreeNode() {

    }

    public TreeNode(int x) {
        this.val = x;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRigth() {
        return rigth;
    }

    public void setRigth(TreeNode rigth) {
        this.rigth = rigth;
    }
}