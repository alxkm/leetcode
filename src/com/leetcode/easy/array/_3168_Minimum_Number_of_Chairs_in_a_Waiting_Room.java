package com.leetcode.easy.array;

public class _3168_Minimum_Number_of_Chairs_in_a_Waiting_Room {
    //3168. Minimum Number of Chairs in a Waiting Room
    //https://leetcode.com/problems/minimum-number-of-chairs-in-a-waiting-room/description/

    public int minimumChairs(String s) {
        int l = 0;
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'E') {
                if (l > 0) l--;
                else n++;
            } else if (s.charAt(i) == 'L') {
                l++;
            }
        }
        return n;
    }
}
