package com.leetcode.easy.enumeration;

public class _1534_Count_Good_Triplets {
    static public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (Math.abs(arr[i] - arr[j]) <= a
                            && Math.abs(arr[j] - arr[k]) <= b
                            && Math.abs(arr[i] - arr[k]) <= c) {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        int[] a = {3, 0, 1, 1, 9, 7};
        System.out.println(countGoodTriplets(a, 7, 2, 3));
    }
}
