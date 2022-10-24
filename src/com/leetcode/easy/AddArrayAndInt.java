package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AddArrayAndInt {
    public List<Integer> addToArrayForm(int[] num, int k) {
//        List<Integer> ar = new ArrayList<>();
//        int b = 1;
//        List<Integer> numList = new ArrayList<>();
//        while (k > 0) {
//            if (b == 1) {
//                numList.add(k % 10);
//                k = k - k % 10;
//            } else {
//                int temp = k / b % 10;
//                numList.add(temp);
//                k = k - temp * b;
//            }
//            b *= 10;
//        }
//
//        int[] objects = numList.toArray();
//
//        int r = 0;
//        int base = 0;
//        for (int i = num.length - 1; i >= 0; i--) {
//
//            for (int j = 0; j < num.length - i - 1; j++) {
//                base *= 10;
//            }
//
//            int digit = (base == 0) ? k % 10 : (k / base) % 10;
//            base = 1;
//
//            int value = num[i] + digit + r;
//            r = 0;
//            ar.add(value % 10);
//            if (value / 10 != 0) {
//                r = value / 10;
//            }
//        }
//
//        if (r > 0) {
//            ar.add(r);
//        }
//        Collections.reverse(ar);
//        return ar;

        List<Integer> ar = new ArrayList<>();
        List<Integer> listNum = new ArrayList<>();
        int base = 1;
        while (k > 0) {
            if (base == 1) {
                listNum.add(k % 10);
                k = k - k % 10;
            } else {
                int temp = k / base % 10;
                listNum.add(temp);
                k = k - temp * base;
            }
            base *= 10;
        }

        int[] num1 = new int[listNum.size()];
        for (int i =  listNum.size() - 1, j = 0; i >= 0; j++,  i--) {
            num1[j] = listNum.get(j);
        }

        int[] num2 = new int[num.length];

        for (int i = num.length - 1, j = 0; i >= 0; i--, j++) {
            num2[j] = num[i];
        }

        int r = 0;
        int max = Math.max(num2.length, num1.length);

        for (int i = 0; i < max; i++) {
            int x = num2.length > i ? num2[i] : 0;
            int y = num1.length > i ? num1[i] : 0;

            int value = x + y + r;
            r = 0;
            ar.add(value % 10);
            if (value / 10 != 0) {
                r = value / 10;
            }
        }

        if (r > 0) {
            ar.add(r);
        }
        Collections.reverse(ar);
        return ar;
    }

    public static void main(String[] args) {
        AddArrayAndInt v = new AddArrayAndInt();
//        int[] ar = {2,7,4};
//        System.out.println(v.addToArrayForm(ar, 181));
        //[1,2,0,0]
        //34
//        int[] ar = {1,2,0,0};
//        System.out.println(v.addToArrayForm(ar, 34));


        int[] ar = {0};
        System.out.println(v.addToArrayForm(ar, 23));
    }
}
