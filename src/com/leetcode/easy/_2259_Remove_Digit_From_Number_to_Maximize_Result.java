package com.leetcode.easy;

public class _2259_Remove_Digit_From_Number_to_Maximize_Result {
    static public String removeDigit(String number, char digit) {
        int index = number.lastIndexOf(digit) ;
        for (int i = 0; i < number.length() - 1; i++) {
            if (digit == number.charAt(i) && number.charAt(i + 1) > digit) {
                index = i;
                break;
            }
        }
        return number.substring(0, index) + number.substring(index + 1);
    }

    public static void main(String[] args) {
        //91919

        String x = removeDigit("8878", '7');
        System.out.println(x);
        System.out.println();
    }
}
