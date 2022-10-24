package com.company;

public class _66_Plus_One {
    class Solution {
        public int[] plusOne(int[] digits) {
            int r = 0;

            for (int i = digits.length - 1; i >= 0; i--) {
                int v = 0;
                if (i == digits.length - 1) {
                    v = digits[i] + 1;
                } else {
                    v = digits[i] + r;
                }
                r = 0;

                if (v / 10 != 0) {
                    r = v / 10;
                    v = v % 10;
                }
                digits[i] = v;
            }
            if (r > 0) {
                int[] newDigits = new int[digits.length + 1];
                newDigits[0] = r;
                for (int i = 1; i < newDigits.length; i++) {
                    newDigits[i] = digits[i - 1];
                }
                return newDigits;
            }
            return digits;
        }
    }
}
