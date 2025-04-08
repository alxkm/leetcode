package com.leetcode.medium.backtrack;

import java.util.Arrays;
import java.util.TreeSet;

public class _1718_Construct_the_Lexicographically_Largest_Valid_Sequence {
    //1718. Construct the Lexicographically Largest Valid Sequence
    //https://leetcode.com/problems/construct-the-lexicographically-largest-valid-sequence/description/

    TreeSet<String> set = new TreeSet<>();
    int n;
    public int[] constructDistancedSequence(int n) {
        this.n = n;
        var ch = new char[n];
        Arrays.fill(ch, '_');
        f(new int[n], ch);
        int[] ar = new int[n];
        for (int i = 0; i < set.last().length(); i++) {
            ar[i] = set.last().charAt(i) - '0';
        }
        return ar;
    }

    private void f(int[] used, char[] s) {
        boolean finishSequence = true;

        for (int i = 0; i < s.length; i++) {
            if (s[i] == '_') {
                finishSequence = false;
            }
        }

        if (finishSequence) {
            set.add(new String(s));
            return;
        }

        for (int i = used.length - 1; i >= 0; i--) {
            if ((i == 1 && used[i] == 1) || used[i] == 2) continue;

            int curNum = i + 1;

            for (int j = 0; j < n; j++) {
                if (s[j] != '_') continue;

                for (int k = j; k < n && (
                        (curNum != 1 && used[i] < 2) || (curNum != 1 && used[i] < 1)) ; k += curNum) {
                    used[i]++;
                    s[k] = (char)(curNum + (int)('0'));
                    if (used[i] == 2) break;
                }
                f (used, s);
                for (int k = j; k < n && (
                        (curNum != 1 && used[i] < 2) || (curNum != 1 && used[i] < 1)) ; k += curNum) {
                    used[i]--;
                    s[k] = '_';
                    if (used[i] == 2) break;
                }
                used[i]--;
            }
        }
    }

    public static void main(String[] args) {
        var sol = new _1718_Construct_the_Lexicographically_Largest_Valid_Sequence();
        System.out.println(Arrays.toString(sol.constructDistancedSequence(3)));
    }
}
