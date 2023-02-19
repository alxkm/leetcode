package com.leetcode.top;

public class _75_Sort_Colors {
    //https://leetcode.com/problems/sort-colors/
    //75. Sort Colors

    public void sortColors(int[] nums) {
        int[] pos = new int[]{0, 0, nums.length - 1};

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && i >= pos[0]) {
                int prev = nums[pos[0]];
                nums[i] = prev;
                nums[pos[0]] = 0;
                pos[0] += 1;
                i -= 1;
            } else if (nums[i] == 2 && pos[2] >= i) {
                int prev = nums[pos[2]];
                nums[i] = prev;
                nums[pos[2]] = 2;
                pos[2] -= 1;
                i -= 1;
            }
        }
    }


    public void sortColors1(int[] nums) {
        int r = 0, w = 0, b = 0;

        for (int n: nums) {
            if (n == 0) r++;
            else if (n == 1) w++;
            else b++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (r > 0) {
                nums[i] = 0;
                r--;
            }
            else if (w > 0) {
                nums[i] = 1;
                w--;
            }
            else if (b > 0) {
                nums[i] = 2;
                b--;
            }
        }
    }

}
