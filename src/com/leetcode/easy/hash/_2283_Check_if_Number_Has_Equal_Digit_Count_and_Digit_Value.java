package com.company.hash;

import java.util.HashMap;
import java.util.Map;

public class _2283_Check_if_Number_Has_Equal_Digit_Count_and_Digit_Value {
    static public boolean digitCount(String num) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < num.length(); i++) {
            map.put(i, 0);
        }
        for (int i = 0; i < num.length(); i++) {
            Integer n = map.get(((int)num.charAt(i) - 48));
            if (n == null) {
                map.put(((int)num.charAt(i) - 48), 1);
            } else {
                map.put(((int)num.charAt(i) - 48), ++n);
            }
        }
        for (int i = 0; i < num.length(); i++) {
            Integer n = map.get(i);
            if (((int)num.charAt(i) - 48) > n) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(digitCount("030"));
    }
}
