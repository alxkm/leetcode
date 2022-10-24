package com.leetcode.easy.ennumeration;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class _1588_Sum_of_All_Odd_Length_Subarrays {

    static public int sumOddLengthSubarrays(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        int counter = 0;
        for (int i = 1; i <= arr.length; i++) {
            for (int j = 0; j <= arr.length - i; j++) {
                List<Integer> a = new ArrayList<>();
                int sum = 0;
                for (int k = j, l = 0; l < i; k++, l++) {
                    a.add(arr[k]);
                    sum += arr[k];
                }
                list.add(a);
                if (a.size() % 2 != 0) {
                    counter += sum;
                }
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        int[] a = {10,11,12};
        System.out.println(sumOddLengthSubarrays(a));
    }
}
