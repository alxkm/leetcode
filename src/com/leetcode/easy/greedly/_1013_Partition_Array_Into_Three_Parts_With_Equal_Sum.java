package com.leetcode.easy.greedly;

public class _1013_Partition_Array_Into_Three_Parts_With_Equal_Sum {
    //1013. Partition Array Into Three Parts With Equal Sum
    //https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/
    //todo todo

    public boolean canThreePartsEqualSum(int[] arr) {
        int s = 0;
        for (int i = 0; i < arr.length; i++) s += arr[i];
        if (s % 3 != 0) return false;
        int a = s / 3;
        int i = 0;
        boolean a1 = false, a2 = false, a3 = false;
        int b = 0;
        for (; i < arr.length; i++) {
            b += arr[i];
            if (b == a) {
                i++;
                a1 = true;
                break;
            }
        }
        b = 0;
        for (; i < arr.length; i++) {
            b += arr[i];
            if (b == a) {
                i++;
                a2 = true;
                break;
            }
        }
        b = 0;
        for (; i < arr.length; i++) {
            b += arr[i];
            if (b == a)  {
                a3 = true;
                break;
            }
        }
        return a1 && a2 && a3;
    }
}
