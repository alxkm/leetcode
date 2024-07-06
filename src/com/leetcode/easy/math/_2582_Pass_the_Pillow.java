package com.leetcode.easy.math;

public class _2582_Pass_the_Pillow {
    //2582. Pass the Pillow
    //https://leetcode.com/problems/pass-the-pillow/description/?envType=daily-question&envId=2024-07-06

    public int passThePillow(int n, int time) {
        int pos = 1;
        boolean forward = true;

        if (n == 2) {
            while (time-- > 0) {
                pos++;
                if (time - 1 >= 0) {
                    pos--;
                    time--;
                }
            }
            return pos;
        }

        while (time-- > 0) {
            if (forward) pos++;
            else pos--;

            if (pos == n && time - 1 >= 0) {
                pos--;
                forward = false;
                time--;
            } else if (pos == 1 && time - 1 >= 0) {
                forward = true;
                pos++;
                time--;
            }
        }
        return pos;
    }

    public int passThePillow1(int n, int time) {
        if (time + 1 < n) return 1 + time;

        int div = time / (n - 1);

        if (div % 2 == 0) return 1 + time % (n - 1);
        return n - (time % (n - 1));
    }

    public static void main(String[] args) {
        var sol = new _2582_Pass_the_Pillow();
        System.out.println(sol.passThePillow(2, 341));
        System.out.println(sol.passThePillow(4, 5));
    }
}
