package com.leetcode.medium.array;

import java.util.HashMap;
import java.util.Map;

public class _2295_Replace_Elements_in_an_Array {
    //2295. Replace Elements in an Array
    //https://leetcode.com/problems/replace-elements-in-an-array/

    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int[] op : operations) {
            int j = map.get(op[0]);
            map.remove(op[0]);
            nums[j] = op[1];
            map.put(op[1], j);
        }

        return nums;
    }

    public int[] arrayChange1(int[] nums, int[][] operations) {
        int[] map = new int[1000001];
        for (int i = 0; i < nums.length; i++) {
            map[nums[i]] = i;
        }

        for (int[] op : operations) {
            int j = map[op[0]];
            nums[j] = op[1];
            map[op[1]] = j;
        }

        return nums;
    }

    public static void main(String[] args) {
        var sol = new _2295_Replace_Elements_in_an_Array();
        sol.arrayChange(new int[]{1}, new int[][]{{1, 2}, {2, 3}, {3,1000000}, {1000000,1}});
    }
}
