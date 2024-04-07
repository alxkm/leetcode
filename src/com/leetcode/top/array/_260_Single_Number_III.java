package com.leetcode.top.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _260_Single_Number_III {
    //https://leetcode.com/problems/single-number-iii/
    //260. Single Number III
    //FOREIGN_SOLUTION
    //TOP

    public int[] singleNumber(int[] nums) {
        // Map<Integer, Integer> map = new HashMap<>();
        // for (int n: nums) map.put(n, map.getOrDefault(n, 0) + 1);
        // int[] two = new int[2];
        // List<Integer> twoList = map.entrySet()
        //                             .stream()
        //                             .filter(s -> s.getValue() == 1)
        //                             .map(s -> s.getKey())
        //                             .collect(Collectors.toList());
        // two[0] = twoList.get(0);
        // two[1] = twoList.get(1);
        // return two;
        if (nums.length == 2) return nums;

        List<Integer> list = new ArrayList<>();
        int[] two = new int[2];
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) {
                list.add(nums[i]);
                break;
            }
            if (nums[i] != nums[i + 1]) {
                list.add(nums[i]);
                i ++;
            }

            if (list.size() == 2) break;
        }
        two[0] = list.get(0);
        two[1] = list.get(1);
        return two;
    }

    public static void main(String[] args) {
        int[] a = {1,2,1,3,2,5};
        var solution = new _260_Single_Number_III();
        System.out.println(Arrays.toString(solution.singleNumber(a)));
    }
}
