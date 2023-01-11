package com.leetcode.easy.binarysearch;

import java.util.concurrent.ThreadLocalRandom;

public class _374_Guess_Number_Higher_or_Lower {
//    public int guessNumber(int n) {
//        int l = 1;
//        int r = n;
//        while (l <= r) {
//            int m = l + (r - l) / 2;
//            int x = guess(m);
//            if (x == 0) return m;
//            if (x == -1) {
//                r = m - 1;
//            } else {
//                l = m + 1;
//            }
//        }
//        return -1;
//    }
//
//    public int guessNumber1(int n) {
//        if (guess(n) == 0) return n;
//        int lo = 1;
//        int hi = n;
//        while (true) {
//            System.out.println(n);
//            n = ThreadLocalRandom.current().nextInt(lo, hi + 1);
//            int result = guess(n);
//            if (result == 0) break;
//
//            if (guess(lo + 1000) == -1 && guess(hi - 1000) == 1)  break;
//
//            if (result == -1) {
//                hi = n;
//            } else {
//                lo = n;
//            }
//        }
//
//        for (int i = lo; i <= hi; i++) {
//            if (guess(i) == 0) return i;
//        }
//        return n;
//    }
}
