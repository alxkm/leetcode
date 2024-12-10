package com.leetcode.medium.arrayarray;

import java.util.ArrayDeque;
import java.util.Deque;

public class _3254_Find_the_Power_of_K_Size_Subarrays_I {
    //3254. Find the Power of K-Size Subarrays I
    //https://leetcode.com/problems/find-the-power-of-k-size-subarrays-i/description/

    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] results = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            boolean isSortedAndConsecutive = true;
            int maxElement = nums[i];
            int j = i + 1;
            while (j < i + k) {
                if (nums[j] != nums[j - 1] + 1) {
                    isSortedAndConsecutive = false;
                    break;
                }
                j++;
            }
            results[i] = isSortedAndConsecutive ? nums[j - 1] : -1;
        }

        return results;
    }

    //foreign_solution
    public int[] resultsArray1(int[] nums, int k) {
        int length = nums.length;
        int[] result = new int[length - k + 1];
        Deque<Integer> indexDeque = new ArrayDeque<>();

        for (int currentIndex = 0; currentIndex < length; currentIndex++) {
            // Remove elements that are out of the window
            if (
                    !indexDeque.isEmpty() &&
                            indexDeque.peekFirst() < currentIndex - k + 1
            ) {
                indexDeque.pollFirst();
            }

            // Check if current element breaks the consecutive and sorted condition
            if (
                    !indexDeque.isEmpty() &&
                            nums[currentIndex] != nums[currentIndex - 1] + 1
            ) {
                indexDeque.clear(); // Invalidate the entire deque if condition breaks
            }

            // Add current element index to the deque
            indexDeque.offerLast(currentIndex);

            // Check if the window is of size k and update result
            if (currentIndex >= k - 1) {
                if (indexDeque.size() == k) { // Valid window of size k
                    result[currentIndex - k + 1] = nums[indexDeque.peekLast()];
                } else {
                    result[currentIndex - k + 1] = -1; // Not valid, return -1
                }
            }
        }

        return result;
    }
}
