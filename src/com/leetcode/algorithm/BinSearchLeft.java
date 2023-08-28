package com.leetcode.algorithm;

public class BinSearchLeft {
    private int binSearch(int[] ar, int a) {
        int l = 0;
        int r = ar.length - 1;
        while (l + 1 < r) {
            int m = (l + r) / 2;

            if (ar[m] >= a) {
                r = m;
            } else {
                l = m;
            }
        }
        return ar[l + 1] == a ? l + 1 : -1;
    }

    private int binSearchMostRight(int[] ar, int a) {
        int l = 0;
        int r = ar.length - 1;
        while (l + 1 < r) {
            int m = (l + r) / 2;

            if (ar[m] > a) {
                r = m;
            } else {
                l = m;
            }
        }
        return ar[l] == a ? l : -1;
    }

    public static void main(String[] args) {
        var bs = new BinSearchLeft();
        int[] a = new int[] {1, 2, 3, 4, 5, 5, 5, 6, 7, 9};
        System.out.println(bs.binSearch(a, 5));
        int[] a1 = new int[] {5, 5, 6, 7, 9};
        System.out.println(bs.binSearchMostRight(a1, 5));
    }
}
