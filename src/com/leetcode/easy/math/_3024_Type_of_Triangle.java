package com.leetcode.easy.math;

import java.util.Arrays;

public class _3024_Type_of_Triangle {
    //3024. Type of Triangle
    //https://leetcode.com/problems/type-of-triangle/description/

    public String triangleType(int[] nums) {
        Arrays.sort(nums);
        if (nums[2] >= nums[0] + nums[1]) return "none";
        if (nums[0] == nums[1] && nums[1] == nums[2] && nums[2] == nums[0]) return "equilateral";
        else if ((nums[0] == nums[1] && nums[1] != nums[2]) || (nums[2] == nums[1] && nums[1] != nums[0]) || (nums[0] == nums[2] && nums[1] != nums[2])) return "isosceles";
        else if ((nums[0] + nums[1] > nums[2]) && (nums[0] + nums[2] > nums[1]) && (nums[1] + nums[2] > nums[0])) return "scalene";
        return "none";
    }
}
