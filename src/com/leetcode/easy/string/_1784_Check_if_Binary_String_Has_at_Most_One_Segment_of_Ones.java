package com.company.string;

public class _1784_Check_if_Binary_String_Has_at_Most_One_Segment_of_Ones {
    static public boolean checkOnesSegment(String s) {
        char prev = '0';
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (prev == '0' && s.charAt(i) == '1') {
                cnt++;
                prev = s.charAt(i);
            } else {
                prev = s.charAt(i);
            }
        }
        return  cnt <= 1;
    }

    public static void main(String[] args) {
        System.out.println(checkOnesSegment("1110"));
    }
}
