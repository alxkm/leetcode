package com.leetcode.top;

public class _5_Longest_Palindromic_Substring {
    //5. Longest Palindromic Substring
    //https://leetcode.com/problems/longest-palindromic-substring/

    public String longestPalindrome(String s) {
        if (s == null && s.equals("") || isPalindrome(s)) return s;
        int n = s.length();
        char[] ss = s.toCharArray();
        String maxStr = s.substring(0, 1);
        for (int i = 0; i < n; i++) { //|| i + maxStr.length() > n - i
            int l = i, r = i;
            while (l >= 0 && r < n) {
                if (l - 1 >= 0 && r + 1 < n && ss[l - 1] == ss[r + 1]) {
                    r++;
                    l--;
                } else if (r + 1 < n && ss[l] == ss[r + 1] && isPalindrome(s.substring(l, r + 2))) {
                    r++;
                } else if (l - 1 >= 0 && ss[l - 1] == ss[r] && isPalindrome(s.substring(l - 1, r + 1))) {
                    l--;
                } else {
                    break;
                }
                if (r + 1 - l > maxStr.length()) {
                    maxStr = s.substring(l, r + 1);
                }
            }
        }
        return maxStr;
    }


    public String longestPalindrome1(String s) {
        if (s == null && s.equals("")) return s;
        int n = s.length();
        String maxStr = s.substring(0, 1);
        for (int i = n; i >= 2; i--) {
            for (int j = 0; j <= n - i; j++) {
                var str = s.substring(j, j + i);
                if (isPalindrome(str) && maxStr.length() < str.length()) maxStr = str;
                System.out.println(str);
            }
        }
        return maxStr;
    }

    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i != j && i <= j) {
            if (s.charAt(i++) == s.charAt(j--)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
