package com.leetcode.medium.slidingwindow;

import com.leetcode.ArrayUtil;

public class _1052_Grumpy_Bookstore_Owner {
    //1052. Grumpy Bookstore Owner
    //https://leetcode.com/problems/grumpy-bookstore-owner/description/

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int unrealizedCustomers = 0;
        for (int i = 0; i < minutes; i++) {
            unrealizedCustomers += customers[i] * grumpy[i];
        }

        int n = customers.length;
        int prev = unrealizedCustomers;
        for (int i = minutes; i < n; i++) {
            int newValue = prev;
            newValue += customers[i] * grumpy[i];
            newValue -= grumpy[i - minutes] * customers[i - minutes];
            prev = newValue;

            unrealizedCustomers = Math.max(unrealizedCustomers, newValue);
        }

        int realizedCustomers = unrealizedCustomers;
        for (int i = 0; i < n; i++) {
            realizedCustomers += customers[i] * (1 - grumpy[i]);
        }

        return realizedCustomers;
    }

    public static void main(String[] args) {
        var sol = new _1052_Grumpy_Bookstore_Owner();
        int[] customers = ArrayUtil.of(1,0,1,2,1,1,7,5);
        int[] grumpy = ArrayUtil.of(0,1,0,1,0,1,0,1);
        int minutes = 3;
        System.out.println(sol.maxSatisfied(customers, grumpy, minutes));
        //System.out.println(sol.maxSatisfied(ArrayUtil.of(4,10,10), ArrayUtil.of(1,1,0), 2));
    }
}
