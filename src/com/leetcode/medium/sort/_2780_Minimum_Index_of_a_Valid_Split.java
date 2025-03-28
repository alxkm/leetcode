package com.leetcode.medium.sort;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _2780_Minimum_Index_of_a_Valid_Split {
    //2780. Minimum Index of a Valid Split
    //https://leetcode.com/problems/minimum-index-of-a-valid-split/?envType=daily-question&envId=2025-03-27

    public int minimumIndex(List<Integer> nums) {
        if (nums.size() == 1) return -1;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.size(); i++) {
            map.merge(nums.get(i), 1, (x, y) -> x + 1);
        }

        Map<Integer, Integer> curMap = new HashMap<>();
        for (int i = 0; i < nums.size() - 1; i++) {
            int quantityInLeftPart = curMap.merge(nums.get(i), 1, (x, y) -> x + 1);
            int quantityInRightPart = map.get(nums.get(i)) - quantityInLeftPart;

            int sizeOfElementsInLeft = i + 1;
            int sizeOfElementsInRight = nums.size() - (i + 1);

            boolean isLeftDominant = (quantityInLeftPart > sizeOfElementsInLeft / 2) || (quantityInLeftPart == sizeOfElementsInLeft);
            boolean isRightDominant = (quantityInRightPart > sizeOfElementsInRight / 2) || (quantityInRightPart == sizeOfElementsInRight);

            if (isLeftDominant && isRightDominant) {
                return i;
            }
        }
        return -1;
    }
}
