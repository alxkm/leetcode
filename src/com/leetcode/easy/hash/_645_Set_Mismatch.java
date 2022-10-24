package com.leetcode.easy.hash;

import java.util.HashSet;
import java.util.Set;

public class _645_Set_Mismatch {
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
}
