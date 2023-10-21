package com.leetcode.easy.dp;

import java.util.HashMap;
import java.util.Map;

public class _343_Integer_Break {
    //343. Integer Break
    //https://leetcode.com/problems/integer-break/

    private Map<Integer, Integer> dp = new HashMap<>();
    private int n;

    public int integerBreak(int n) {
        this.n = n;
        dp.put(1, 1);
        return dfs(n);
    }

    private int dfs(int num) {
        //System.out.println("________");
        if (dp.containsKey(num)) return dp.get(num);

        int res = (num == n) ? 0 : num;
        for (int i = 1; i < num; i++) {

            int a = dfs(i);
            int b = dfs(num - i);
            //System.out.println("a = " + a);
            //System.out.println("b = " + b);
            int val = a * b;
            res = Math.max(res, val);
            //System.out.println("max = " + res);
            dp.put(num, res);
        }
        return res;
    }
}
