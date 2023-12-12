package com.leetcode.easy.array;

public class _1287_Element_Appearing_More_Than_25_In_Sorted_1287 {
    //1287. Element Appearing More Than 25% In Sorted Array
    //https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/

    public int findSpecialInteger(int[] arr) {
        int size = arr.length / 4 + 1;
        for (int i = 1, counter = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) counter = 0;
            counter++;
            if (counter >= size) return arr[i];
        }
        return arr[0];
    }
}
