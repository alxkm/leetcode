package com.company.array;

import java.util.ArrayList;
import java.util.List;

public class _905_Sort_Array_By_Parity {
    public int[] sortArrayByParity(int[] nums) {
        int[] n = new int[nums.length];
        List<Integer> odds = new ArrayList<>();
        int j = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                n[j++] = num;
            } else {
                odds.add(num);
            }
        }
        for (int a : odds) {
            n[j++] = a;
        }
        return n;
    }
}
