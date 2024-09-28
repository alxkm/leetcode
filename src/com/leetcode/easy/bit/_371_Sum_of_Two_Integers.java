package com.leetcode.easy.bit;

public class _371_Sum_of_Two_Integers {
    //https://leetcode.com/problems/sum-of-two-integers/
    //371. Sum of Two Integers
    //FOREIGN_SOLUTION

    public int getSum(int a, int b) {
        if(a==0 || b==0) return a!=0?a:b;
        int c=b,s=0;
        while(c!=0){
            s=a^b;
            c=(a&b)<<1;
            a=s;
            b=c;
        }
        return s;
    }
}
