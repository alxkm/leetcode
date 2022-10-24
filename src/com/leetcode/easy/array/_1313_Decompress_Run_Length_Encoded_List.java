package com.leetcode.easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1313_Decompress_Run_Length_Encoded_List {
    static public int[] decompressRLElist(int[] nums) {
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < nums.length;) {
            int a = nums[i];
            int b = nums[i + 1];
            i += 2;

            for (int j = 0; j < a; j++) {
                l.add(b);
            }
        }

        int[] n = new int[l.size()];
        for (int i = 0; i < l.size(); i++) {
            n[i] = l.get(i);
        }
        return n;
    }

    public static void main(String[] args) {
        int[] a = {1,1,2,3};

        System.out.println(Arrays.toString(decompressRLElist(a)));
    }
}
