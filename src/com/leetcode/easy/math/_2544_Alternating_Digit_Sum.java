package com.leetcode.easy.math;

import java.util.Stack;

public class _2544_Alternating_Digit_Sum {
    //https://leetcode.com/problems/alternating-digit-sum/

    public int alternateDigitSum(int n) {
        Stack<Integer> s = new Stack<>();

        while (n > 0) {
            s.add(n % 10);
            n /= 10;
        }
        int answer = 0;
        boolean is = false;
        while (!s.isEmpty()) {
            int a = s.pop();
            if (is) {
                a *= -1;
                is = false;
            } else {
                is = true;
            }

            answer += a;
        }
        return answer;
    }
}
