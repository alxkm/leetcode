package com.leetcode.medium.slidingwindow;

public class _1343_Number_of_Sub_arrays_of_Size_K_and_Average_Greater_than_or_Equal_to_Threshold {
    static public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        int counter = 0;

        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        if ((sum / k) >= threshold) counter++;

        for (int i = 1; i <= arr.length - k; i++) {
            sum -= arr[i - 1];
            sum += arr[i + k - 1];

            if ((sum / k) >= threshold) counter++;
        }
        return counter;
    }

    public static void main(String[] args) {
        int [] a =  {2,2,2,2,5,5,5,8};
        int k = 3;
        int t = 4;

        System.out.println(numOfSubarrays(a, k, t));
    }
}
