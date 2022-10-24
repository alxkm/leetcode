package com.company.math;

import java.util.ArrayList;
import java.util.Arrays;

public class _2160_Minimum_Sum_of_Four_Digit_Number_After_Splitting_Digits {
    static public int minimumSum(int num) {
        String s = String.valueOf(num);
        var l = new ArrayList<Integer>();
        Integer m1 = 1000;

        for (int i = 0; i < s.length(); i++) {
            int a = (int)s.charAt(i) - 48;
            if (a != 0) {
                l.add(a);
                m1 = Math.min(a, m1);
            }
        }
        if (l.size() == 1) return l.get(0);
        if (l.size() == 2) return l.get(0) + l.get(1);
        l.remove(m1);
        Integer m2 = 1000;
        for (Integer integer : l) {
            m2 = Math.min(integer, m2);
        }
        l.remove(m2);
        if (l.size() == 1) return (m1 * 10 + l.get(0)) + m2;

        int a = l.get(0) == 0 ? m1 : (m1 * 10 + l.get(0));
        int b = l.get(1) == 0 ? m1 : (m2 * 10 + l.get(1));
        return a + b;
    }

    static public int minimumSum1(int num) {
        int number1 = num % 10;
        int number2 = (num % 100) / 10;
        int number3 = (num %1000) / 100;
        int number4 = num / 1000;
        int[] arr = new int[]{number1,number2,number3,number4};
        Arrays.sort(arr);
        System.out.print(Arrays.toString(arr));
        int total = arr[3] + arr[0] * 10 + arr[2] + arr[1]*10;
        return total;
    }

    public static void main(String[] args) {
       // System.out.println(minimumSum(1000));
        System.out.println(minimumSum1(2030));
    }
}
