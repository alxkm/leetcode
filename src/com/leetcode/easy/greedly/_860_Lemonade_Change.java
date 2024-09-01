package com.leetcode.easy.greedly;

public class _860_Lemonade_Change {
    //860. Lemonade Change
    //https://leetcode.com/problems/lemonade-change/
    //todo todo

    public boolean lemonadeChange(int[] bills) {
        int fifth = 0;
        int ten = 0;
        for (int n: bills) {
            if (n == 5) {
                fifth++;
            } else if (n == 10) {
                ten++;
                if (fifth > 0) {
                    fifth--;
                } else {
                    return false;
                }
            } else {
                if (fifth > 0) {
                    fifth--;
                } else {
                    return false;
                }
                if (ten > 0) {
                    ten--;
                } else {
                    if (fifth >= 2) {
                        fifth -= 2;
                    } else {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public boolean lemonadeChange1(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int n: bills) {
            if (n == 5) {
                five++;
            } else if (n == 10) {
                if (five == 0) return false;
                five--;
                ten++;
            } else {
                if (ten == 0) {
                    if (five < 3) return false;
                    five -= 3;
                } else {
                    ten--;
                    if (five < 1) return false;
                    five--;
                }
            }
        }
        return true;
    }
}
