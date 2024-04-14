package com.leetcode.medium.math;

public class _1759_Count_Number_of_Homogenous_Substrings {
    //https://leetcode.com/problems/count-number-of-homogenous-substrings/
    //1759. Count Number of Homogenous Substrings

    public int countHomogenous(String s) {
        long ans = 0;
        int mod = 1000000007;

        for (int i = 0; i < s.length();) {
            char ch = s.charAt(i);
            long count = 0;

            while (i < s.length() && s.charAt(i) == ch) {
                count++;
                i++;
            }

            ans += ((count * (count + 1)) / 2) % mod;
        }

        return (int)(ans % mod);
    }
}
