package com.leetcode.easy.arrayarray;

public class _1652_Defuse_the_Bomb {
    //1652. Defuse the Bomb
    //https://leetcode.com/problems/defuse-the-bomb/description/?envType=daily-question&envId=2024-11-18

    public int[] decrypt(int[] code, int k) {
        int[] ans = new int[code.length];
        if (k == 0) return ans;

        for (int i = 0; i < code.length; i++) {
            int w = 0;
            if (k > 0) {
                int counter = 0;
                for (int j = i + 1; j < code.length && counter != k; j++) {
                    counter++;
                    w += code[j];
                }
                if (counter != k) {
                    for (int j = 0; j < code.length && counter != k; j++) {
                        counter++;
                        w += code[j];
                    }
                }
            } else {
                int counter = 0;
                for (int j = i - 1; j >= 0 && counter != k; j--) {
                    counter--;
                    w += code[j];
                }
                if (counter != k) {
                    for (int j = code.length - 1; j >= 0 && counter != k; j--) {
                        counter--;
                        w += code[j];
                    }
                }
            }
            ans[i] = w;
        }
        return ans;
    }
}
