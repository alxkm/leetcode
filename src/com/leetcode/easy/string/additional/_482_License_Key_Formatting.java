package com.leetcode.easy.string.additional;

public class _482_License_Key_Formatting {
    static public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int j = 0;
        int i = s.length() - 1;
        while (i >= 0) {
            if (s.charAt(i) == '-') {
                i--;
                continue;
            }
            if (j == k) {
                j = 0;
                sb.append("-");
            }
            sb.append(Character.toUpperCase(s.charAt(i)));
            i--;
            j++;
        }
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "5F3Z-2e-9-w";
        int k = 4;
    }
}
