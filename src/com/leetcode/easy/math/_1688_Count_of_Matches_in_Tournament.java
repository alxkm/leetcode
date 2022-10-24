package com.company.math;

public class _1688_Count_of_Matches_in_Tournament {
    public int numberOfMatches(int n) {
        int a = n;
        int counter = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                counter += n/2;
                n = n / 2;
                System.out.println(counter);
                System.out.println(n);
                System.out.println();
            } else {
                counter += ((n - 1) / 2);
                n = (n - 1) / (2 + 1);
                n++;
                System.out.println(counter);
                System.out.println(n);
                System.out.println();
            }
        }
        return a - 1;
    }
}
