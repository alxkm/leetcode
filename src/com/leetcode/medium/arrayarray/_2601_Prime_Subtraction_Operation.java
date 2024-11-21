package com.leetcode.medium.arrayarray;

import java.util.ArrayList;
import java.util.List;

public class _2601_Prime_Subtraction_Operation {
    //2601. Prime Subtraction Operation
    //https://leetcode.com/problems/prime-subtraction-operation/description/

    public static List<Integer> primes = new ArrayList<>();

    static {
        for (int i = 2; i <= 1000; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) primes.add(i);
        }
    }

    public boolean primeSubOperation(int[] nums) {
        int p0 = 0;
        for (int n: primes) {
            if (n >= nums[0]) break;
            p0 = n;
        }
        nums[0] -= p0;

        for (int i = 1; i < nums.length; i++) {
            int p = 0;
            for (int n: primes) {
                if ((nums[i] - n > nums[i - 1]) && nums[i] > n) {
                    p = n;
                } else {
                    break;
                }
            }
            nums[i] -= p;
            if (nums[i - 1] >= nums[i]) return false;
        }
        return true;
    }

    //foreign_solution
    class Solution {

        public boolean primeSubOperation(int[] nums) {
            int maxElement = getMaxElement(nums);

            // Store the sieve array.
            boolean[] sieve = new boolean[maxElement + 1];
            fill(sieve, true);
            sieve[1] = false;
            for (int i = 2; i <= Math.sqrt(maxElement + 1); i++) {
                if (sieve[i]) {
                    for (int j = i * i; j <= maxElement; j += i) {
                        sieve[j] = false;
                    }
                }
            }

            // Start by storing the currValue as 1, and the initial index as 0.
            int currValue = 1;
            int i = 0;
            while (i < nums.length) {
                // Store the difference needed to make nums[i] equal to currValue.
                int difference = nums[i] - currValue;

                // If difference is less than 0, then nums[i] is already less than
                // currValue. Return false in this case.
                if (difference < 0) {
                    return false;
                }

                // If the difference is prime or zero, then nums[i] can be made
                // equal to currValue.
                if (sieve[difference] == true || difference == 0) {
                    i++;
                    currValue++;
                } else {
                    // Otherwise, try for the next currValue.
                    currValue++;
                }
            }
            return true;
        }

        private int getMaxElement(int[] nums) {
            int max = -1;
            for (int num : nums) {
                if (num > max) {
                    max = num;
                }
            }
            return max;
        }

        private void fill(boolean[] arr, boolean value) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = value;
            }
        }
    }
}
