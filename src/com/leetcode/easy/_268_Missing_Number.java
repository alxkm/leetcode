package com.leetcode.easy;

public class _268_Missing_Number {
    //268. Missing Number
    //https://leetcode.com/problems/missing-number/

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

    public int missingNumber1(int[] nums) {
        int s = 0, max = 0;
        boolean has = false;
        for (int n: nums) {
            max = Math.max(max, n);
            s += n;
            if (n == 0) has = true;
        }
        if (!has) return 0;
        int s1 = 0;
        for (int i = 0; i <= max; i++) {
            s1 += i;
        }

        if (s == s1) {
            return max + 1;
        }

        return s1 - s;
    }

}
