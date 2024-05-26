package com.leetcode.hard;

public class _552_Student_Attendance_Record_II {

    //552. Student Attendance Record II
    //https://leetcode.com/problems/student-attendance-record-ii/description/

    public static final int MOD = 1000000007;
    Long[][][] dp;

    public int checkRecord(int n) {
        dp = new Long[n + 1][2][3];

        return (int)f(n, 0, 0);
    }

    private long f(int n, int aCounter, int lCounter) {
        if (n == 0) return 1;

        Long curValue = dp[n][aCounter][lCounter];
        if (curValue != null) return curValue;

        long a = 0;
        if (aCounter == 0) {
            a = f(n - 1, 1, 0) % MOD;
        }

        long l = 0;
        if (lCounter != 2) {
            l = f(n - 1, aCounter, lCounter + 1) % MOD;
        }

        long p = f(n - 1, aCounter, 0) % MOD;

        curValue = ((a + l + p) % MOD);
        curValue %= MOD;

        dp[n][aCounter][lCounter] = curValue;
        return curValue;
    }

    public static void main(String[] args) {
        var sol = new _552_Student_Attendance_Record_II();
        System.out.println(sol.checkRecord(2));
    }
}
