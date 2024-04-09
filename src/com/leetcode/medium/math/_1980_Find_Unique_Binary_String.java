package com.leetcode.medium.math;

import java.util.HashSet;
import java.util.Set;

public class _1980_Find_Unique_Binary_String {
    //1980. Find Unique Binary String
    //https://leetcode.com/problems/find-unique-binary-string/

    public String findDifferentBinaryString(String[] nums) {
        if (nums.length == 1 && nums[0].equals("0")) return "1";
        if (nums.length == 1 && nums[0].equals("1")) return "0";
        Set<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (String s: nums) {
            int n = 0;

            for (int i = s.length() - 1, j = 0; i >= 0; i--, j++) {
                n += Math.pow(2, j) * (int)(s.charAt(i) - '0');
            }
            set.add(n);
            min = Math.min(n, min);
            max = Math.max(n, max);
        }
        if (!set.contains(0)) {
            StringBuilder sb = new StringBuilder();
            while (sb.length() != nums[0].length()) {
                sb.append("0");
            }
            return sb.toString();
        }
        for (int i = min; i <= max + 1; i++) {
            if (!set.contains(i)) {
                StringBuilder sb = new StringBuilder();
                while (i > 0) {
                    sb.append(i % 2);
                    i /= 2;
                    if (i < 2) {
                        sb.append(i);
                        break;
                    }
                }
                while (sb.length() < nums[0].length()) {
                    sb.append(0);
                }
                sb.reverse();
                return sb.toString();
            }
        }
        return nums[0];
    }

    //tricky
    public String findDifferentBinaryString1(String[] nums) {
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<nums.length;i++)
        {
            sb.append(nums[i].charAt(i) == '0'? "1": "0");
        }
        return new String(sb);
    }

    public static void main(String[] args) {
        //String[] s = {"01","10"};
        //String[] s = {"00","01"};
        String[] s = {"0"};
        //String[] s = {"111","011","001"};
        var sol = new _1980_Find_Unique_Binary_String();
        System.out.println(sol.findDifferentBinaryString(s));
    }
}
