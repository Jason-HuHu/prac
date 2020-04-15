package com.huxl.tree;

/**
 * 线段树
 */
public class SegmentTree {
    private class SegmentTreeNode {
        int start, end, max;
        SegmentTreeNode left, right;
        SegmentTreeNode(int start, int end, int max) {
            this.start = start;
            this.end = end;
            this.max = max;
            this.left = this.right = null;
        }
    }

    public SegmentTreeNode build(int start, int end, int[] nums) {
        if (start > end) {
            return null;
        }

        if (start == end) {
            return new SegmentTreeNode(start, end, nums[start]);
        }

        SegmentTreeNode node = new SegmentTreeNode(start, end, nums[start]);

        // 自上而下而下递归分裂
        if (start != end) {
            int mid = (start + end) / 2;
            node.left = build(start, mid, nums);
            node.right = build(mid + 1, end, nums);
        }

        // 自下而上回溯更新
        if (node.left != null && node.left.max > node.max) {
            node.max = node.left.max;
        }

        if (node.right != null && node.right.max > node.max) {
            node.max = node.right.max;
        }

        return node;
    }

    public int query(SegmentTreeNode root, int start, int end) {
        // 如果节点区间相等于查找区间，直接返回对应的值即可
        if (root.start == start && root.end == end) {
            return root.max;
        }

        int mid = (root.start + root.end) / 2;
        int leftMax = Integer.MIN_VALUE, rightMax = Integer.MIN_VALUE;

        // 判断是否需要去左子树查找
        if (start <= mid) {
            // 节点相交查找区间的情况
            if (end > mid) {
                leftMax = query(root.left, start, mid);
            } // 节点包含查找区间的情况
            else {
                leftMax = query(root.left, start, end);
            }
        }

        // 判断是否需要去右子树查找
        if (mid < end) {
            // 节点相交查找区间的情况
            if (start <= mid) {
                rightMax = query(root.right, mid + 1, end);
            } // 节点包含查找区间的情况
            else {
                rightMax = query(root.right, start, end);
            }
        }

        return Math.max(leftMax, rightMax);
    }

    public void modify(SegmentTreeNode root, int index, int value) {
        // 找到对应的叶子节点，进行元素更新
        if (index == root.start && index == root.end) {
            root.max = value;
        }

        if (root.start >= root.end) {
            return;
        }

        // 自上而下递归查找
        modify(root.left, index, value);
        modify(root.right, index, value);

        // 自下而上回溯更新
        root.max = Math.max(root.left.max, root.right.max);
    }
}
