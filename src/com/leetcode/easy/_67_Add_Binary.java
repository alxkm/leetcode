package com.company;

public class _67_Add_Binary {
   static public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        int sum = 0;
        while (i >= 0 || j >= 0) {
            if (i >= 0 && (int)a.charAt(i) == 49) sum++;
            if (j >= 0 && (int)b.charAt(j) == 49) sum++;
            if (sum == 0) {
                sb.append("0");
            }
            if (sum == 1) {
                sb.append("1");
                sum = 0;
            }
            if (sum == 2) {
                sb.append("0");
                sum = 1;
            }
            if (sum == 3) {
                sb.append("1");
                sum = 1;
            }
            --i;
            --j;
        }
        if (sum == 1) sb.append("1");
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        String a = "1010", b = "1011";

        System.out.println(addBinary(a, b));;
    }
}
