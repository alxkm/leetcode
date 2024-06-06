package com.leetcode.medium.binary;

public class _1442_Count_Triplets_That_Can_Form_Two_Arrays_of_Equal_XOR {
    //https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/description/
    //1442. Count Triplets That Can Form Two Arrays of Equal XOR

    public static int countTriplets(int[] arr) {
        int counter = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int a = 0;
                for (int k = i; k < j; k++) {
                    a ^= arr[k];
                }

                for (int k = j; k < n; k++) {
                    for (int l = k + 1; l <= n; l++) {
                        int b = 0;
                        for (int m = k; m < l; m++) {
                            b ^= arr[m];
                        }

                        if (a == b) counter++;
                    }
                }
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        countTriplets(new int[1]);
    }
}
