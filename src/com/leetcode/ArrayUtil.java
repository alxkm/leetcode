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

    /**
     * Parses a string representation of an array of single-character strings and converts it to an array of chars.
     *
     * @param arrayString a string representation of an array of single-character strings
     * @return an array of chars
     */
    public static char[] parseAndConvertToCharArray(String arrayString) {
        if (arrayString == null || arrayString.length() == 0) {
            return new char[0];
        }

        // Remove square brackets and quotes, then split by comma
        arrayString = arrayString.replaceAll("[\\[\\]\"]", "");
        String[] stringArray = arrayString.split(",");

        // Convert the array of single-character strings to an array of chars
        char[] charArray = new char[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i].length() != 1) {
                throw new IllegalArgumentException("All elements in the array must be single characters");
            }
            charArray[i] = stringArray[i].charAt(0);
        }

        return charArray;
    }

    /**
     * Parses a string representation of an array of integers and returns the array of ints.
     *
     * @param arrayString a string representation of an array of integers
     * @return an array of ints
     */
    public static int[] parseAndConvertToIntArray(String arrayString) {
        if (arrayString == null || arrayString.length() == 0) {
            return new int[0];
        }

        // Remove square brackets and spaces, then split by comma
        arrayString = arrayString.replaceAll("[\\[\\] ]", "");
        String[] stringArray = arrayString.split(",");

        // Convert the array of strings to an array of ints
        int[] intArray = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
        }

        return intArray;
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
                array[i] = Integer.parseInt(numbers[i].trim());
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
