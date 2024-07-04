package com.leetcode.easy.string;

public class _2678_Number_of_Senior_Citizens {
    //2678. Number of Senior Citizens
    //https://leetcode.com/problems/number-of-senior-citizens/

    public int countSeniors(String[] details) {
        int counter = 0;
        for (String s: details) {
            if (Integer.valueOf(s.substring(11, 13)) > 60) {
                counter++;
            }
        }
        return counter;
    }
}
