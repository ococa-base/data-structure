package Leetcode;

public class NumArray2 {

    private int [] sum; // sum[i] 存储前i个元素的和， sum[0] = 0；
                        // sum[i] 存储[0, ... , i-1]的和
                        // sum[1] = nums[0];

    public NumArray2(int[] nums) {

        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        // 区间 [0, 1, 2, 3, 4]
        return sum[j + 1] - sum[i];
    }

}
