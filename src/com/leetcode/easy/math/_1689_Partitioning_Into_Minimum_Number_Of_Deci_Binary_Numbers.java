package com.company.math;

public class _1689_Partitioning_Into_Minimum_Number_Of_Deci_Binary_Numbers {
   static public int minPartitions(String n) {
        int a = n.charAt(0);
        for (int i = 0; i < n.length(); i++) {
            int b = (int)n.charAt(i) - 48;
            a = Math.max(a, b);
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(minPartitions("32"));
    }
}
