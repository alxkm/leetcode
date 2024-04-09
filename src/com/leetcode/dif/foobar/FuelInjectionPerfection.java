package com.leetcode.dif.foobar;


public class FuelInjectionPerfection {
    private static java.util.Map<String, Integer> map = new java.util.HashMap<>();

    public static int solution(String x) {
        return count(x, 0);
    }

    public static int count(String x, int count) {
        if (x.equals("0")) return 1;
        if (x.equals("1")) return count;
        Integer a = map.get(x);
        if (a == null) {
            if ((x.charAt(x.length() - 1) - '0') % 2 == 0) {
                java.math.BigDecimal divide = new java.math.BigDecimal(x).divide(new java.math.BigDecimal(2));
                a = count(divide.toString(),  1);
            } else {
                java.math.BigDecimal plus = new java.math.BigDecimal(x).add(new java.math.BigDecimal(1));
                a = count(plus.toString(),  1);
                java.math.BigDecimal minus = new java.math.BigDecimal(x).subtract(new java.math.BigDecimal(1));
                var b  = count(minus.toString(), 1);
                a = Math.min(a, b);
            }
        }
        map.put(x, a);
        return a + count;
    }
    public static int minOperations(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int number = 15;
        int result = minOperations(number);
        System.out.println(result);
        System.out.println(FuelInjectionPerfection.solution("11"));
    }
}
