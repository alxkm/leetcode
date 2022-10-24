package com.company.string;

public class _2124_Check_if_All_A_s_Appears_Before_All_B_s {
    public boolean checkString(String s) {
        int a = -1;
        int b = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                a = i;
            }
            if (s.charAt(i) == 'b') {
                b = i;
            }

            if (a > b && b != -1) return false;
        }

        return true;
    }
}
