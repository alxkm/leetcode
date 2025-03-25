package com.leetcode.easy.array;

import com.leetcode.ArrayUtil;

public class _3151_Special_Array_I {
    //3151. Special Array I
    //https://leetcode.com/problems/special-array-i/description/

    public boolean isArraySpecial(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] % 2 == 0 && nums[i] % 2 != 0) continue;
            else if (nums[i - 1] % 2 != 0 && nums[i] % 2 == 0) continue;
            return false;
        }
        return true;
    }

    public boolean isArraySpecial1(int[] nums) {
        if (nums.length == 1) return true;
        if (nums.length == 2) return ((nums[0] % 2 != 0 && nums[1] % 2 == 0) || (nums[0] % 2 == 0 && nums[1] % 2 != 0));
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i - 1] % 2 != 0 && nums[i] % 2 == 0) || (nums[i - 1] % 2 == 0 && nums[i] % 2 != 0)) continue;
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        var sol = new _3151_Special_Array_I();
        System.out.println(sol.isArraySpecial(ArrayUtil.of(2, 1, 4)));
    }
}
