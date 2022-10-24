package com.leetcode.easy.string.additional;

public class _1974_Minimum_Time_to_Type_Word_Using_Special_Typewriter {
    static public int minTimeToType(String word) {
        int i = 0;
        int sum = 0;
        int curPos = 97;
        while (i < word.length()) {
            int clockwise = Math.abs(word.charAt(i) - curPos);
            int counterClockwise = Math.abs(word.charAt(i)  - (char)(curPos - 26));
            int counterClockwise1 = Math.abs((word.charAt(i) - 26)  - curPos);
            int min = Math.min(clockwise, counterClockwise);
            sum += Math.min(min, counterClockwise1);
            sum += 1;
            curPos = word.charAt(i);
            i++;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(minTimeToType("zjpc"));
    }
}
