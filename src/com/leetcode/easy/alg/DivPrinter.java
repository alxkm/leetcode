package com.leetcode.easy.alg;

public class DivPrinter {

    public int findAndPrintDivisors(int n) {
        int maxD = (int) Math.sqrt(n);
        int counter = 0;
        for (int i = 1; i <= maxD; i++) {
            if (n % i == 0) {
                if (n / i == i) {
                    System.out.print(i);
                    counter++;
                } else {
                    System.out.print(i + " ");
                    System.out.print(n / i + " ");
                    counter++;
                    counter++;
                }
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        DivPrinter solution = new DivPrinter();
        int andPrintDivisors = solution.findAndPrintDivisors(9);
        System.out.println();
        System.out.println(andPrintDivisors);
    }
}
