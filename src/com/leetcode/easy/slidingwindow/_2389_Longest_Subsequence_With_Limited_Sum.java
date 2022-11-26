package com.leetcode.easy.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _2389_Longest_Subsequence_With_Limited_Sum {
    static public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();

        for (int n : queries) {
            int sum = 0;
            if (nums[0] > n) {
                list.add(0);
            } else {

                for (int i = 0; i < nums.length; i++) {
                    sum += nums[i];
                    if (sum >= n) {
                        list.add((sum == n) ? i + 1 : i);
                        break;
                    }
                    if (i == nums.length - 1) {
                        list.add(nums.length);
                    }
                }
            }
        }
        int[] a = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            a[i] = list.get(i);
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = {4,5,2,1};
        int[] b = {3,10,21};
        System.out.println(Arrays.toString(answerQueries(a, b)));
    }
}
