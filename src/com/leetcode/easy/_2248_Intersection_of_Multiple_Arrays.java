package com.company;

import java.util.ArrayList;
import java.util.List;

public class _2248_Intersection_of_Multiple_Arrays {
    static public List<Integer> intersection(int[][] nums) {
        var list = new ArrayList<Integer>();
        for (int i : nums[0]) {
            list.add(i);
        }
        var toRemove = new ArrayList<Integer>();
        for (Integer n : list) {
            for (int i = 1, numsLength = nums.length; i < numsLength; i++) {
                boolean contains = false;
                for (int num : nums[i]) {
                    if (num == n) {
                        contains = true;
                        break;
                    }
                }
                if (!contains) {
                    toRemove.add(n);
                    break;
                }
            }
        }
        list.removeAll(toRemove);
        return list;
    }

    public static void main(String[] args) {
//        int [][] nums  = {
//                {3,1,2,4,5},
//                {1,2,3,4},
//                {3,4,5,6}
//        };

//        int [][] nums  = {
//                {1,2,3},
//                {4,5,6}
//        };


        int [][] nums  = {
                {1,2,3},
                {4,5,6}
        };

        System.out.println(intersection(nums));
    }
}
