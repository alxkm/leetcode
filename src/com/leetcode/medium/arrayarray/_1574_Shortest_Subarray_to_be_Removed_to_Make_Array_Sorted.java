package com.leetcode.medium.arrayarray;

public class _1574_Shortest_Subarray_to_be_Removed_to_Make_Array_Sorted {
    //https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted
    //1574. Shortest Subarray to be Removed to Make Array Sorted

    public int findLengthOfShortestSubarray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < arr.length - 1 && arr[left] <= arr[left + 1]) {
            left++;
        }

        if (left == arr.length - 1)
            return 0;

        while (right > 0 && arr[right] >= arr[right - 1]) {
            right--;
        }

        int len = Math.min(arr.length - left - 1, right);

        int i = 0, j = right;
        while (i <= left && j < arr.length) {
            if (arr[i] <= arr[j]) {
                len = Math.min(len, j - i - 1);
                i++;
            } else {
                j++;
            }
        }

        return len;
    }
}
