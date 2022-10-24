package com.leetcode.easy.alg;

public class _1629_Slowest_Key {
    static public char slowestKey(int[] releaseTimes, String keysPressed) {
        int max = releaseTimes[0];
        char ch =  keysPressed.charAt(0);
        for (int i = 1; i < releaseTimes.length; i++) {
            int cur = releaseTimes[i] - releaseTimes[i - 1];

            if (cur == max && keysPressed.charAt(i) > ch) {
                ch = keysPressed.charAt(i);
                continue;
            }

            if (cur > max) {
                max = cur;
                ch = keysPressed.charAt(i);
            }
        }
        return ch;
    }

    public static void main(String[] args) {
        int[] a = {9,29,49,50};
        String s = "cbcd";

        System.out.println(slowestKey(a, s));
    }
}
