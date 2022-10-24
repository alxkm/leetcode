package com.leetcode.easy;

public class _2180_Count_Integers_With_Even_Digit_Sum {
    // we can parse like string
    static public int countEven(int num) {

        int c = 0;
        for (int i = 1; i <= num; i++) {
            int n = i;
            int ddd = n / 100;
            if (ddd == 10) ddd = 1;
            n = n - ddd * 100;
            int dd = n / 10;
            if (dd == 10) dd = 1;
            n = n - dd * 10;
            int sum = ddd + dd + n;
            if (sum % 2 == 0){
                c++;
                System.out.println(i);
            }
        }
        return c;
    }

    public static void main(String[] args) {
        System.out.println(countEven(150));
    }
}
