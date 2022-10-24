package com.company.string;

public class _2299_Strong_Password_Checker_II {
    static public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) return false;
        boolean lowercase = false;
        boolean uppercase = false;
        boolean digit = false;
        boolean special = false;
        boolean doubleCheck = false;
        String specials = "!@#$%^&*()-+";

        for (var ch : password.toCharArray()) {
            if (48 <= ch && ch <= 57) digit = true;

            if (97 <= ch && ch <= 122) {
                lowercase = true;
                String s = String.valueOf(ch) + ch;
                char newChar = (char)(ch - 97 + 65);
                String s1 = String.valueOf(newChar) + ch;
                String s2 = String.valueOf(ch) + newChar;
                if (password.contains(s) || password.contains(s1) || password.contains(s2)) doubleCheck = true;
            }

            if (65 <= ch && ch <= 90) {
                uppercase = true;
                String s = String.valueOf(ch) + ch;
                char newChar = (char)(ch - 65 + 97);
                String s1 = String.valueOf(newChar) + ch;
                String s2 = String.valueOf(ch) + newChar;
                if (password.contains(s) || password.contains(s1) || password.contains(s2)) doubleCheck = true;
            }

            if (specials.indexOf(ch) != -1) special = true;
        }
        return lowercase && uppercase && digit && special && !doubleCheck;
    }

    public static void main(String[] args) {
        System.out.println(strongPasswordCheckerII("11A!A!Aa"));
        System.out.println(strongPasswordCheckerII("aA0!bB1@@3rbHkB8Puvl"));
        System.out.println(strongPasswordCheckerII("0Aa!a!a!"));
    }
}
