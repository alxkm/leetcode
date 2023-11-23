package com.leetcode.medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1630_Arithmetic_Subarrays {
    //1630. Arithmetic Subarrays
    //https://leetcode.com/problems/arithmetic-subarrays/
    //FOREING_SOLUTION
    //Nov 23, 2023 15:13

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> list = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            boolean is = true;
            int left = l[i], right = r[i];
            int[] sub = Arrays.copyOfRange(nums, left, right + 1);
            Arrays.sort(sub);
            int diff = sub[0] - sub[1];
            for (int j = 2; j < sub.length; j++) {
                if (sub[j - 1] - sub[j] != diff) {
                    is = false;
                    break;
                }
            }
            list.add(is);
        }
        return list;
    }


    public List<Boolean> checkArithmeticSubarrays1(int[] nums, int[] l, int[] r) {
        List<Boolean> answer = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            answer.add(isArithmeticProgression(nums, l[i], r[i]));
        }
        return answer;
    }

    private boolean isArithmeticProgression(int[] n, int l, int r) {
        int[] nums = Arrays.copyOfRange(n, l, r + 1);
        Arrays.sort(nums);
        int a0 = nums[0] - nums[1];
        int an = nums[nums.length - 2] - nums[nums.length - 1];
        if (a0 != an) return false;
        for (int i = 1; i < nums.length - 1; i++) {
            if ((nums[i] - nums[i + 1]) != an) return false;
        }
        return true;
    }
}
