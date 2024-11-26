package com.leetcode.medium.greedy;

import com.leetcode.ArrayUtil;

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

    public static void main(String[] args) {
        var sol = new _2601_Prime_Subtraction_Operation();
        System.out.println(sol.primeSubOperation(ArrayUtil.of(5,8,3)));
        System.out.println(sol.primeSubOperation(ArrayUtil.of(4, 9, 6, 10)));
    }
}
