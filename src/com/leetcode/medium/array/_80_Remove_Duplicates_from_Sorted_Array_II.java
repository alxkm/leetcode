package com.leetcode.medium.array;

public class _80_Remove_Duplicates_from_Sorted_Array_II {
    //https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
    //TOP

    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 0;
        int n = nums.length;

        while (i < n) {
            int tmp = nums[i];
            while (n > j && nums[j] == tmp) {
                j++;
            }
            if (j - i > 2) {
                int delta = (j - i - 2);
                int k = i + 2;
                while (n > j) {
                    nums[k] = nums[j];
                    j++;
                    k++;
                }
                i += 2;
                j = i;
                n -= delta;
            } else {
                i = j;
                j = i + 1;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int[] a = new int[] {0,0,1,1,1,1,2,3,3};
        var solution = new _80_Remove_Duplicates_from_Sorted_Array_II();
        System.out.println(solution.removeDuplicates(a));
    }
}
