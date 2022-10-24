package com.company.alg;

public class BinarySearch {

    static public int binarySearch(int[] a, int x) {
        int l = 0;
        int r = a.length + 1;
        int m = 0;
        while (l + 1 < r) {
            m = (r + l) / 2;
            if (a[m] > x) {
                r = m;
            } else {
                l = m;
            }
        }
        return m;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9};

        System.out.println(binarySearch(a, 4));
    }
}
