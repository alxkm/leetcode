package com.leetcode.medium.implementation;

public class _592_Fraction_Addition_and_Subtraction {
    //592. Fraction Addition and Subtraction
    //https://leetcode.com/problems/fraction-addition-and-subtraction/description/?envType=daily-question&envId=2024-08-23
    //FOREIGN_SOLUTION

    public String fractionAddition(String expression) {
        int num = 0;
        int denom = 1;

        int i = 0;
        while (i < expression.length()) {
            int currNum = 0;
            int currDenom = 0;

            boolean isNegative = false;

            // check for sign
            if (expression.charAt(i) == '-' || expression.charAt(i) == '+') {
                if (expression.charAt(i) == '-') {
                    isNegative = true;
                }
                // move to next character
                i++;
            }

            // build numerator
            while (Character.isDigit(expression.charAt(i))) {
                int val = expression.charAt(i) - '0';
                currNum = currNum * 10 + val;
                i++;
            }

            if (isNegative) currNum *= -1;

            //skip divisor
            i++;

            // build denominator
            while (
                    i < expression.length() &&
                            Character.isDigit(expression.charAt(i))
            ) {
                int val = expression.charAt(i) - '0';
                currDenom = currDenom * 10 + val;
                i++;
            }

            // add fractions together using common denominator
            num = num * currDenom + currNum * denom;
            denom = denom * currDenom;
        }

        int gcd = Math.abs(FindGCD(num, denom));

        // reduce fractions
        num /= gcd;
        denom /= gcd;

        return num + "/" + denom;
    }

    private int FindGCD(int a, int b) {
        if (a == 0) return b;
        return FindGCD(b % a, a);
    }
}
