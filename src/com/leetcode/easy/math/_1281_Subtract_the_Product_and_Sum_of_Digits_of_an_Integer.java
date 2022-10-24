package com.company.math;

public class _1281_Subtract_the_Product_and_Sum_of_Digits_of_an_Integer {
    static public int subtractProductAndSum(int n) {
        int sub = 0, mul = 1;
        String s = "100000";
        while (n != 0) {
            int r = Integer.parseInt(s);
            int d = n / r;
            n -= r * d;
            s = s.substring(0, s.length() - 1);
            if (r <= n) {
                sub += d;
                mul *= d;
            }
        }
        return mul - sub;
    }

    public int subtractProductAndSum1(int n) {
        int sub = 0, mul = 1;
        String s = String.valueOf(n);
        for (int i = 0; i < s.length(); i++) {
            sub += (int)s.charAt(i) - 48;
            mul *= (int)s.charAt(i) - 48;
        }
        return mul - sub;
    }

    public int subtractProductAndSum2(int n) {
        int sum = 0, product = 1;

        while(n > 0){
            sum += n % 10;
            product *= n % 10;
            n /= 10;
        }
        return product - sum;
    }

    public static void main(String[] args) {
        System.out.println(subtractProductAndSum(705));
    }
}
