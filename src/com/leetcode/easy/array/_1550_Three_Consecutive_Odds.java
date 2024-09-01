package com.leetcode.easy.array;

public class _1550_Three_Consecutive_Odds {
    //1550. Three Consecutive Odds
    //https://leetcode.com/problems/three-consecutive-odds/description/

    public boolean threeConsecutiveOdds(int[] arr) {
        if (arr.length <= 2) return false;
        int a = arr[0] + arr[1] + arr[2];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i - 2] % 2 != 0
                    && arr[i - 1] % 2 != 0
                    && arr[i] % 2 != 0) {
                return true;
            }
        }
        return false;
    }

    public boolean threeConsecutiveOdds1(int[] arr) {
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] % 2 != 0 && arr[i - 1] % 2 != 0 && arr[i - 2] % 2 != 0) return true;
        }
        return false;
    }
}
