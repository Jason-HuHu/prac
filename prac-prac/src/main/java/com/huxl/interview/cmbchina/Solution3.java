package com.huxl.interview.cmbchina;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class Solution3 {
    public static void main(String[] args) {

    }

    //递归的时间复杂度分析O(n) 空间复杂度根据递归调用深度来决定
    public int maxDepth(TreeNode root){
        if (root == null) return 0;
        int leftHigh = maxDepth(root.left) + 1;
        int rightHigh = maxDepth(root.right) + 1;
        return Math.max(leftHigh, rightHigh);
    }
    //非递归时间复杂度分析 O(n) 空间复杂度，就是用来存储每层元素的队列来决定
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> list = new LinkedList<>();
        //将根节点放进队列中
        list.offer(root);
        //二叉树的高度
        int level = 0;
        //本层已经访问过的元素个数
        int cur = 0;
        //每一层元素个数
        int count = 0;
        while (!list.isEmpty()){
            count = list.size();
            cur = 0;
            while (cur < count) {
                TreeNode node = list.poll();
                cur++;
                assert node != null;
                if (node.left != null) {
                    list.offer(node.left);
                }
                if (node.right != null) {
                    list.offer(node.right);
                }
            }
            level++;
        }
        return level;
    }
    //求二叉树的最大宽度
    public int maxWidth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int maxWidth = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            //当前层节点的个数
            int length = queue.size();
            while (length > 0) {
                TreeNode node = queue.poll();
                length--;
                if (node.left != null) {
                    //下层节点入队
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.left);
                }
            }
            maxWidth = Math.max(maxWidth, queue.size());
        }
        return maxWidth;
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}
