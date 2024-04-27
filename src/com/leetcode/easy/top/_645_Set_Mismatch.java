package com.leetcode.easy.top;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _645_Set_Mismatch {
    //645. Set Mismatch
    //https://leetcode.com/problems/set-mismatch/description/
    //hash

    public int[] findErrorNums(int[] nums) {
        Set<Integer> set = new HashSet();
        int min = 10000;
        int max = 0;
        int duplicated = 10000;
        for (int n : nums) {
            min = Math.min(n, min);
            max = Math.max(n, max);
            if (set.contains(n)) duplicated = n;
            set.add(n);
        }
        int missed = 10000000;
        for (int i = min; i <= max; i++) {
            if (!set.contains(i)) missed = i;
        }
        int[] a = new int[2];
        a[0] = duplicated;
        if (missed == 10000000 && min != 1) missed = min - 1;
        if (missed == 10000000 && min == 1) missed = max + 1;
        a[1] = missed;
        return a;
    }

    public int[] findErrorNums1(int[] nums) {
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                int prevIndex = i;
                while (nums[prevIndex] != prevIndex + 1) {
                    int tmp = nums[prevIndex];
                    int newIndex = tmp - 1;
                    if (newIndex == prevIndex) {
                        l.add(prevIndex + 1);
                        break;
                    }
                    nums[prevIndex] = prevIndex + 1;
                    prevIndex = newIndex;
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) l.add(i + 1);
        }

        int[] ar = new int[l.size()];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = l.get(i);
        }
        return ar;
    }

    public int[] findErrorNums2(int[] nums) {
        boolean[] map = new boolean[nums.length + 1];
        int[] arr = new int[2];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map[nums[i]]) {
                arr[0] = nums[i];
            } else {
                sum += nums[i];
                map[nums[i]] = true;
            }
        }
        arr[1] = Math.abs(((nums.length * (nums.length + 1)) / 2) - sum);
        return arr;
    }

    public static void main(String[] args) {
        var sol = new _645_Set_Mismatch();

        sol.findErrorNums1(new int[] {1,2,2,4});
    }
}
