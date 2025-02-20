package com.leetcode.medium.array;

import java.util.ArrayList;
import java.util.List;

public class _3159_Find_Occurrences_of_an_Element_in_an_Array {
    //3159. Find Occurrences of an Element in an Array
    //https://leetcode.com/problems/find-occurrences-of-an-element-in-an-array/description/

    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        List<Integer> occurrences = new ArrayList<>();
        int[] ans = new int[queries.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                occurrences.add(i);
            }
        }
        for (int i = 0; i < queries.length; i++) {
            if (occurrences.size() >= queries[i]) {
                ans[i] = occurrences.get(queries[i] - 1);
            } else {
                ans[i] = -1;
            }
        }
        return ans;
    }
}
