package com.leetcode.dif.foobar;

import java.util.Arrays;

public class Solution {
    public static int[] solution1(int[] l, int t) {
        int start = -1, end = -1;
        int s = l[0];
        for (int i = 0, j = 0; i < l.length; ) {
            if (s == t && (j - i <= end - start || end == -1)) {
                if (j - i < end - start || end == -1) {
                    start = i;
                    end = j;
                } else {
                    int i1 = i, s1 = start;
                    while (i1 <= j) {
                        if (l[i1++] < l[s1++]) {
                            start = i;
                            end = j;
                            break;
                        } else {
                            break;
                        }
                    }
                }
            }
            if (s < t && j + 1 < l.length) {
                j++;
                s += l[j];
            } else {
                i++;
                s -= l[i - 1];
            }

            if (s == t && (j - i < end - start || end == -1)) {
                start = i;
                end = j;
            }
        }
        return new int[]{start, end};
    }

    public static int[] solution(int[] l, int t) {
        int start = -1, end = -1;
        int s = l[0];
        for (int i = 0, j = 0; i < l.length; ) {
            if (s == t) {
                start = i;
                end = j;
                break;
            }
            if (s < t && j + 1 < l.length) {
                j++;
                s += l[j];
            } else {
                i++;
                s -= l[i - 1];
            }

            if (s == t) {
                start = i;
                end = j;
                break;
            }
        }
        return new int[]{start, end};
    }

    public static void main(String[] args) {
        var sol = new Solution();

        //System.out.println(Arrays.toString(Solution.solution(new int[]{4, 3, 10, 2, 8}, 12)));
        System.out.println(Arrays.toString(Solution.solution(new int[]{3, 9, 0, 9, 3}, 12)));
        //System.out.println(Arrays.toString(Solution.solution(new int[]{1, 2, 3, 4}, 15)));
        //System.out.println(Arrays.toString(Solution.solution(new int[]{1, 1, 1, 3}, 3)));
        //System.out.println(Arrays.toString(Solution.solution(new int[]{1, 1, 1, 3}, 3)));
        //System.out.println(Arrays.toString(Solution.solution(new int[]{1}, 1)));
    }
}
