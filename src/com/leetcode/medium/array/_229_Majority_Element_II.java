package com.leetcode.medium.array;

import java.util.ArrayList;
import java.util.List;

public class _229_Majority_Element_II {
    //https://leetcode.com/problems/majority-element-ii/
    //TOP

    public List<Integer> majorityElement(int[] nums) {
        if (nums.length == 1) return List.of(nums[0]);

        int major1 = getMajorityElementExcept(nums, -1);
        int counter1 = 0;
        for (int n: nums) {
            if (n == major1) counter1++;
        }

        int major2 = getMajorityElementExcept(nums, major1);
        int counter2 = 0;
        for (int n: nums) {
            if (n == major2) counter2++;
        }

        List<Integer> majors = new ArrayList<>();
        int limit = nums.length / 3;

        if (counter1 > limit) {
            majors.add(major1);
        }

        if (counter2 > limit) {
            majors.add(major2);
        }

        return majors;
    }

    private int getMajorityElementExcept(int[] nums, int except) {
        int major = -1;
        int counter = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == except) continue;

            if (nums[i] == major) {
                counter++;
            } else {
                counter--;
            }

            if (counter <= 0) {
                major = nums[i];
                counter = 1;
            }
        }

        return major;
    }

    public static void main(String[] args) {
        var solution = new _229_Majority_Element_II();
        int[] nums = new int[] {2,1,1,3,1,4,5,6};
        System.out.println(solution.majorityElement(nums));
    }
}
