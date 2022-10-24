package com.company;

public class _136_Single_Number {
    static class Solution {
        public static int singleNumber(int[] nums) {
            if (nums.length == 1) return nums[0];

            long sum = 0;
            int a = 0;
            int b = 0;
            for (int i = 0; i < nums.length; i++) {
                if ((i + 1) % 2 == 0) {
                    sum += nums[i];
                    a++;
                } else {
                    sum -= nums[i];
                    b++;
                }
            }
            System.out.println(a);
            System.out.println(b);
            return (int) Math.abs(sum);
        }
    }

    public static void main(String[] args) {
        int[] a = {4,1,2,1,2};
        System.out.println(Solution.singleNumber(a));
    }
}
