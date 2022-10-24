package com.leetcode.easy;

public class _268_Missing_Number {
    public int missingNumber(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int sum = 0;

//        if ((nums.length == 2) && nums[0] == 0 && nums[1] == 1) return 2;
//        if ((nums.length == 2) && nums[0] == 1 && nums[1] == 0) return 2;
//        if (nums.length == 1 && nums[0] == 0) return 1;
//        if (nums.length == 1 && nums[0] == 1) return 0;

        boolean isNull = false;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            sum += num;
            if (num == 0) isNull = true;
        }
        if (!isNull) return 0;

        int sum1 = 0;
        for (int i = min; i <= max; i++) {
            sum1 += i;
        }

        if (sum1 == sum) return max + 1;

        return sum1 - sum;
    }

}
