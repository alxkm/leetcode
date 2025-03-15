package com.leetcode.medium.monotonic;

public class _769_Max_Chunks_To_Make_Sorted {
    //769. Max Chunks To Make Sorted
    //https://leetcode.com/problems/max-chunks-to-make-sorted/description/

    class Solution {
        public int maxChunksToSorted(int[] arr) {
            int maxSoFar = 0;
            int chunks = 0;
            for (int i = 0; i < arr.length; i++) {
                maxSoFar = Math.max(maxSoFar, arr[i]);
                if (maxSoFar == i) chunks += 1;
            }
            return chunks;
        }
    }
}
