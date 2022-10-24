package com.company.sort;

import java.util.Arrays;
import java.util.Comparator;

public class _1356_Sort_Integers_by_The_Number_of_1_Bits {
    static public int[] sortByBits(int[] arr) {
        int[][] a = new int[arr.length][2];
        boolean one = true;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            int n = arr[i];

            while (n != 0) {
                sum += n % 2;
                n /= 2;
            }
            if (sum != 1) one = false;
            a[i][0] = arr[i];
            a[i][1] = sum;
        }
        if (one) {
            Arrays.sort(arr);
            return arr;
        }

        Arrays.sort(a, (b, c) -> {
            if (b[1] != c[1]) {
                return b[1] - c[1];
            }
            if (b[0] < c[0]) return -1;

            return 1;
        });

        for (int i = 0; i < arr.length; i++) {
            arr[i] = a[i][0];
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] a = {1024,512,256,128,64,32,16,8,4,2,1};
        int[] a1 = {1111,7644,1107,6978,8742,1,7403,7694,9193,4401,377,8641,5311,624,3554,6631};

        System.out.println(Arrays.toString(sortByBits(a1)));
    }
}
