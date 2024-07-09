package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ArrayUtil {
    public static int[] of(int... a) {
        return a;
    }

    public static char[] of(char... a) {
        return a;
    }

    public static Integer[] ofInteger(Integer... a) {
        return a;
    }

    public static String[] of(String... a) {
        return a;
    }

    public static int[][] to2d(int... a) {
        int[][] ar = new int[a.length / 2][2];
        for (int i = 0, j = 0; i < a.length; i++, j++) {
            ar[j][0] = a[i];
            ar[j][1] = a[++i];
        }
        return ar;
    }

    public static int[][] to2d(String input) {
        input = input.substring(1, input.length() - 1);

        String[] elements = input.split("\\],\\[");

        List<int[]> list = new ArrayList<>();

        for (String element : elements) {
            element = element.replace("[", "").replace("]", "");

            String[] numbers = element.split(",");
            int[] array = new int[numbers.length];

            for (int i = 0; i < numbers.length; i++) {
                array[i] = Integer.parseInt(numbers[i]);
            }

            list.add(array);
        }

        int[][] result = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
