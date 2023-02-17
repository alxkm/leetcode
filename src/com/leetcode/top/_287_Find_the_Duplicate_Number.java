package com.leetcode.top;

import java.util.Arrays;

public class _287_Find_the_Duplicate_Number {
    //https://leetcode.com/problems/find-the-duplicate-number/
    //287. Find the Duplicate Number

    public int findDuplicate(int[] nums) {
        int fast = nums[nums[0]];
        int slow = nums[0];

        while (fast != slow) {
            fast = nums[nums[fast]];
            slow = nums[slow];
        }

        fast = 0;

        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }

        return fast;
    }

    public int findDuplicate1(int[] nums) {
        Arrays.sort(nums);

        int prev = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (prev == nums[i]) {
                break;
            } else {
                prev = nums[i];
            }
        }
        return prev;
    }

    public int findDuplicate2(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == nums[i]) {
                    return nums[i];
                }
            }
        }
        return index;

        // int min = nums[0];
        // int max = nums[0];

        // int sum = 0;
        // for (int n : nums) {
        //     min = Math.min(min, n);
        //     max = Math.max(max, n);
        //     sum += n;
        // }

        // int s = 0;
        // int counter = 0;
        // for (int i = min; i <= max; i++) {
        //     s += i;
        //     counter++;
        // }

        // System.out.println(sum);
        // System.out.println(s);
        // System.out.println(nums.length);
        // System.out.println(counter);

        // return (sum - s) / (nums.length - counter);

        // Arrays.sort(nums);

        // int prev = nums[0];

        // for (int i = 1; i < nums.length; i++) {
        //     if (prev == nums[i]) {
        //         break;
        //     } else {
        //         prev = nums[i];
        //     }
        // }
        // return prev;
    }
}
