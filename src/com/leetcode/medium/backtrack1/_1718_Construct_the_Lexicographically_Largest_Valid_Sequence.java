package com.leetcode.medium.backtrack1;

import java.util.Arrays;

public class _1718_Construct_the_Lexicographically_Largest_Valid_Sequence {
    //https://leetcode.com/problems/construct-the-lexicographically-largest-valid-sequence/description/
    //1718. Construct the Lexicographically Largest Valid Sequence

    int n;
    int[] seq;
    boolean[] used;

    public int[] constructDistancedSequence(int n) {
        this.n = n;
        int size = 2 * n - 1;
        seq = new int[size];
        used = new boolean[n + 1];
        Arrays.fill(seq, -1);
        f(0);
        return seq;
    }

    private boolean f(int index) {
        if (index == seq.length) {
            return true;
        }
        if (seq[index] != -1) {
            return f(index + 1);
        }
        for (int num = n; num > 0; num--) {
            if (used[num]) continue;

            if (num == 1) {
                seq[index] = 1;
                used[1] = true;
                if (f(index + 1)) return true;
                seq[index] = -1;
                used[1] = false;

            } else {
                int index2 = index + num;

                if (index2 < seq.length && seq[index2] == -1) {
                    seq[index] = seq[index2] = num;
                    used[num] = true;
                    if (f(index + 1)) return true;
                    seq[index] = seq[index2] = -1;
                    used[num] = false;
                }
            }
        }
        return false;
    }
}
