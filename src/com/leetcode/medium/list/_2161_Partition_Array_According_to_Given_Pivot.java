package com.leetcode.medium.list;

import java.util.ArrayList;
import java.util.List;

public class _2161_Partition_Array_According_to_Given_Pivot {
    //https://leetcode.com/problems/partition-array-according-to-given-pivot/
    //2161. Partition Array According to Given Pivot

    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        int q = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) {
                l1.add(nums[i]);
            } else {
                if (nums[i] == pivot) {
                    q++;
                } else {
                    l2.add(nums[i]);
                }
            }
        }

        for (int i = 0; i < l1.size(); i++) {
            nums[i] = l1.get(i);
        }
        for (int i = l1.size(); i < l1.size() + q; i++) {
            nums[i] = pivot;
        }
        for (int i = l1.size() + q, j = 0; i < nums.length; i++, j++) {
            nums[i] = l2.get(j);
        }
        return nums;
    }

    public int[] pivotArray1(int[] nums, int pivot) {
        int[] ar = new int[nums.length];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) {
                ar[j++] = nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == pivot) {
                ar[j++] = nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > pivot) {
                ar[j++] = nums[i];
            }
        }
        return ar;
    }
}
