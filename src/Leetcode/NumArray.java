package Leetcode;

import SegmentTree.SegmentTree;

/**
 * https://leetcode-cn.com/problems/range-sum-query-immutable/
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 */
class NumArray {

    private SegmentTree<Integer> segmentTree;

    public NumArray(int[] nums) {
        if (nums.length > 0) {
            Integer[] arr = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                arr[i] = nums[i];
            }
            segmentTree = new SegmentTree<Integer>(arr, ((a, b) -> a + b));
        }
    }

    public int sumRange(int i, int j) {
        if (segmentTree == null) {
            throw new IllegalArgumentException("segment tree is null");
        }
        return segmentTree.query(i, j);
    }
}