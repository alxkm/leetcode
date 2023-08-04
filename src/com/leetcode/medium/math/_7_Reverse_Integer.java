package com.leetcode.medium.math;

public class _7_Reverse_Integer {
    static public int reverse(int x) {
        boolean plus = x >= 0;
        String str = (!plus) ? String.valueOf(x).substring(1) : String.valueOf(x);
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        long value = Long.parseLong(plus ? sb.toString() : "-" + sb);
        if (value > Integer.MAX_VALUE || value < Integer.MIN_VALUE) return 0;
        return Math.toIntExact(value);
    }

    public int reverse1(int x) {

        long r = 0;
        while(x != 0){
            r = r*10 + x%10;
            x /= 10;
        }
        if(r >= Integer.MIN_VALUE && r <= Integer.MAX_VALUE)
            return (int)r;
        else
            return 0;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1));
    }
}
