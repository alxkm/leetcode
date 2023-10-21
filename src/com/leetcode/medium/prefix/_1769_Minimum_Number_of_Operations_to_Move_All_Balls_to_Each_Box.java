package com.leetcode.medium.prefix;

public class _1769_Minimum_Number_of_Operations_to_Move_All_Balls_to_Each_Box {
    //https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/
    //1769. Minimum Number of Operations to Move All Balls to Each Box
    //TOP

    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int s = 0;
            for (int j = 0; j < n; j++) {
                if (boxes.charAt(j) == '1') {
                    s += Math.abs(i - j);
                }
            }
            answer[i] = s;
        }

        return answer;
    }

    public int[] minOperations1(String boxes) {
        int n = boxes.length();
        int[] left = new int[n];
        int[] right = new int[n];
        char[] ch = boxes.toCharArray();
        int counter = ch[0] - '0';
        for (int i = 1; i < n; i++) {
            left[i] = counter + left[i - 1];
            counter += ch[i] - '0';
        }
        counter = ch[n - 1] - '0';
        for (int i = n - 2; i >= 0; i--) {
            right[i] = counter + right[i + 1];
            counter += ch[i] - '0';
        }

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = left[i] + right[i];
        }

        return answer;
    }
}
