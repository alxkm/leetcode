package com.leetcode.easy.string;

public class _1758_Minimum_Changes_To_Make_Alternating_Binary_String {
    //1758. Minimum Changes To Make Alternating Binary String
    //https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/
    public int minOperations(String s) {
        char[] st = s.toCharArray();
        int n1 = 0, n2 = 0;
        char ch1 = '1';
        char ch2 = '0';

        for (char c : st) {
            if (c != ch1) n1++;
            if (c != ch2) n2++;

            ch1 = (ch1 == '1') ? '0' : '1';
            ch2 = (ch2 == '1') ? '0' : '1';
        }
        return Math.min(n1, n2);
    }

    public int minOperations1(String s) {
        int z=0,o=0;
        for(int i=0; i<s.length();i++) {
            if(i%2==0) {
                if(s.charAt(i) == '0') o++;
                else z++;
            } else {
                if(s.charAt(i) == '0') z++;
                else o++;
            }
        }

        return Math.min(z,o);

    }

    public static void main(String[] args) {
        var sol = new _1758_Minimum_Changes_To_Make_Alternating_Binary_String();
        sol.minOperations("0100");
    }
}
