package com.leetcode.medium.string;

public class _468_Validate_IP_Address {
    public String validIPAddress(String queryIP) {
        String type = "Neither";
        char[] chars = queryIP.toCharArray();
        if (queryIP.contains(".")) {
            int dot = 0;
            for (char ch : chars) if (ch == '.') dot++;
            if (dot == 3) {
                int digits = 0;
                for (char ch : chars) if (Character.isDigit(ch)) digits++;

                if ((digits + dot) == queryIP.length()) {
                    String[] nums = queryIP.split("\\.");
                    if (nums.length != 4) return type;
                    for (String n : nums) {
                        if (n.equals("") || (n.length() > 1 && n.charAt(0) == '0') || n.length() > 3) return type;
                        int num = Integer.parseInt(n);
                        if (!(num >= 0 && num <= 255)) {
                            return type;
                        }
                    }
                    return "IPv4";
                }
            }
        } else {
            int colon = 0;
            for (char ch : chars) if (ch == ':') colon++;
            if (colon == 7) {
                int symbols = 0;
                String[] nums = queryIP.split(":");
                if (nums.length != 8) return type;
                for (String n : nums) {
                    if (n.equals("")) return type;
                    if (n.length() >= 1 && n.length() <= 4) {
                        for (char ch : n.toCharArray()) {
                            if (Character.isDigit(ch) || (ch >= 'a' && ch <= 'f') || (ch >= 'A' && ch <= 'F')) {
                                symbols++;
                            } else {
                                return "Neither";
                            }
                        }
                    } else {
                        return "Neither";
                    }
                }
                if (symbols <= 64) {
                    return "IPv6";
                }
            }
        }
        return type;
    }
}
