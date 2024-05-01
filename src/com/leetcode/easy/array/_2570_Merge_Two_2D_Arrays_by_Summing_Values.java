package com.leetcode.easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _2570_Merge_Two_2D_Arrays_by_Summing_Values {
    //2570. Merge Two 2D Arrays by Summing Values
    //https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values/description/

    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> l = new ArrayList<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i][0] == nums2[j][0]) {
                l.add(new int[]{nums1[i][0], nums1[i][1] + nums2[j][1]});
                i++;
                j++;
            } else if (nums1[i][0] < nums2[j][0]) {
                l.add(new int[]{nums1[i][0], nums1[i][1]});
                i++;
            } else {
                //if (nums1[i][0] > nums2[j][0])
                l.add(new int[]{nums2[j][0], nums2[j][1]});
                j++;
            }
        }

        while (i < nums1.length) {
            l.add(new int[]{nums1[i][0], nums1[i][1]});
            i++;
        }
        while (j < nums2.length) {
            l.add(new int[]{nums2[j][0], nums2[j][1]});
            j++;
        }

        int[][] ar = new int[l.size()][2];
        for (i = 0; i < l.size(); i++) {
            ar[i] = l.get(i);
        }
        return ar;
    }

    public static void main(String[] args) {
        int[][] ar1 = new int[][] {{1,2},{2,3},{4,5}};
        int[][] ar2 = new int[][] {{1,4},{3,2},{4,1}};
        System.out.println(Arrays.deepToString(mergeArrays(ar1, ar2)));
    }
}
