package com.leetcode.hard;

import com.leetcode.ArrayUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _2444_Count_Subarrays_With_Fixed_Bounds {
    //https://leetcode.com/problems/count-subarrays-with-fixed-bounds/description/
    //2444. Count Subarrays With Fixed Bounds

    public long countSubarrays(int[] nums, int minK, int maxK) {
        long counter = 0;
        int max = -1, min = -1;
        int s = nums.length;
        for (int r = 0, l = 0; r < s; r++) {
            int x = nums[r];
            if (x < minK || x > maxK) {
                l = r + 1;
                continue;
            }
            if (x == maxK) max = r;
            if (x == minK) min = r;
            counter += Math.max((Math.min(max, min) - l + 1), 0);
        }
        return counter;
    }

    public long countSubarrays1(int[] nums, int minK, int maxK) {
        int counter = 0;
        Set<String> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int min = -1;
            int max = -1;
            boolean isCorrectSequence = true;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == minK) min = j;
                else if (nums[j] == maxK) max = j;

                if (nums[j] < minK || nums[j] > maxK) {
                    isCorrectSequence = false;
                    break;
                }

                if (min != -1 && max != -1) {
                    break;
                }
            }

            String key = Math.max(max, min) + "_" + Math.min(max, min);

            if (isCorrectSequence && min != -1 && max != -1 && !set.contains(key)) {
                set.add(key);
                if (min < max) {
                    counter += (min - i);
                    for (int j = max; j < nums.length && (nums[j] >= minK && nums[j] <= maxK); j++) {
                        counter++;
                    }
                } else {
                    counter += (max - i);
                    for (int j = min; j < nums.length && (nums[j] >= minK && nums[j] <= maxK); j++) {
                        counter++;
                    }
                }
            }
        }

        return counter;
    }

    public long countSubarrays2(int[] nums, int minK, int maxK) {
        int counter = 0;
        List<Integer> leftBoundaries = new ArrayList<>();
        List<Integer> rightBoundaries = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == minK) leftBoundaries.add(i);
            if (nums[i] == maxK) rightBoundaries.add(i);
        }

//        for (int left : leftBoundaries) {
//            for (int right = 0; right < rightBoundaries.size(); right++) {
//                if (left > right) continue;
//                boolean isSequenceCorrect = true;
//                for (int i = left; i <= right; i++) {
//                    if (nums[i] < minK || nums[i] > maxK) {
//                        isSequenceCorrect = false;
//                        break;
//                    }
//                }
//                if (isSequenceCorrect) counter++;
//                String s ;
//                s.trim().
//            }
//        }

        return counter;
    }

    public static void main(String[] args) {
        var sol = new _2444_Count_Subarrays_With_Fixed_Bounds();
        System.out.println(sol.countSubarrays1(ArrayUtil.of(35054, 398719, 945315, 945315, 820417, 945315, 35054, 945315, 171832, 945315, 35054, 109750, 790964, 441974, 552913), 35054, 945315));
        System.out.println(sol.countSubarrays1(ArrayUtil.of(1, 3, 5, 2, 7, 5), 1, 5));
        System.out.println(sol.countSubarrays1(ArrayUtil.of(1, 1, 1, 1), 1, 1));
    }
}
