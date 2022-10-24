package com.company.hash;

import java.util.HashMap;
import java.util.Map;

public class _2206_Divide_Array_Into_Equal_Pairs {
    static public boolean divideArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int i : map.values()) {
            if (i < 2 || i % 2 > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] n =
                {12,8,19,5,4,8,14,18,20,12,1,14,9,15,14,5,11,4,7,2,2,11,18,5,13,20,16,7,1,6,13,13,14,3,2,1,12,11,4,17,12,13,19,6,17,4,19,2,4,4,7,19,7,6,9,14,8,2,6,9,17,9,14,1,13,11,11,8,12,13,10,9,11,6,9,20,19,4,10,10,19,12,13,10,3,16,13,10,20,5,14,20,13,14,3,7,15,7,10,1};

        System.out.println(divideArray(n));
    }
}
