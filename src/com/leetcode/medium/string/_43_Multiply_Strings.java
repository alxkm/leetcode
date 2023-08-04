package com.leetcode.medium.string;

import java.util.Stack;

public class _43_Multiply_Strings {
    //https://leetcode.com/problems/multiply-strings/

    public String multiply(String num1, String num2) {
        Stack<String> st = new Stack<>();
        char[] n1;
        char[] n2;
        if (num1.length() >= num2.length()) {
            n1 = num1.toCharArray();
            n2 = num2.toCharArray();
        } else {
            n1 = num2.toCharArray();
            n2 = num1.toCharArray();
        }
        for (int i = n2.length - 1; i >= 0; i--) {
            StringBuilder sb = new StringBuilder();
            int cur = 0;

            int zeros = n2.length - 1 - i;
            sb.append("0".repeat(Math.max(0, zeros)));

            for (int j = n1.length - 1; j >= 0; j--) {

                int mul = (n1[j] - 48) * (n2[i] - 48) + cur;
                if (mul >= 10) {
                    cur = mul / 10;
                    mul %= 10;
                } else {
                    cur = 0;
                }
                sb.append(mul);
            }
            if (cur > 0) {
                sb.append(cur);
            }
            String str = sb.reverse().toString();
            st.add(str);
        }

        while (st.size() > 1) {
            char[] f = st.pop().toCharArray();
            char[] s = st.pop().toCharArray();
            StringBuilder sb = new StringBuilder();
            int cur = 0;
            for (int i = f.length - 1, j = s.length - 1; i >= 0 || j >= 0; i--, j--) {
                int d1 = 0;
                int d2 = 0;
                if (i >= 0) {
                    d1 = f[i] - 48;
                }
                if (j >= 0) {
                    d2 = s[j] - 48;
                }

                int sum = d1 + d2 + cur;
                if (sum >= 10) {
                    cur = sum / 10;
                    sum %= 10;
                } else {
                    cur = 0;
                }
                sb.append(sum);
            }
            if (cur > 0) {
                sb.append(cur);
            }
            String str = sb.reverse().toString();
            st.add(str);
        }
        return st.pop();
    }

    public static void main(String[] args) {
        var solution = new _43_Multiply_Strings();
        String num1 = "99", num2 = "99";
        System.out.println(solution.multiply(num1, num2));
    }
}
