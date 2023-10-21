package com.leetcode.medium.design;

import java.util.HashMap;
import java.util.Map;

public class _2043_Simple_Bank_System {
    //https://leetcode.com/problems/simple-bank-system/
    //2043. Simple Bank System

    class Bank {
        private Map<Integer, Long> accountToMoney = new HashMap<>();

        public Bank(long[] balance) {
            for (int i = 1; i <= balance.length; i++) {
                accountToMoney.put(i, balance[i - 1]);
            }
        }

        public boolean transfer(int account1, int account2, long money) {
            Long m1 = accountToMoney.get(account1);
            Long m2 = accountToMoney.get(account2);

            if (m1 == null || m2 == null) return false;
            if (m1 < money) return false;

            if (account1 == account2) return true;
            accountToMoney.put(account1, m1 - money);
            accountToMoney.put(account2, m2 + money);
            return true;
        }

        public boolean deposit(int account, long money) {
            if (money < 0) return false;
            Long accountMoney = accountToMoney.get(account);
            if (accountMoney == null) return false;
            accountToMoney.put(account, accountMoney + money);
            return true;
        }

        public boolean withdraw(int account, long money) {
            Long accountMoney = accountToMoney.get(account);
            if (accountMoney == null) return false;
            if (accountMoney < money) return false;
            accountToMoney.put(account, accountMoney - money);
            return true;
        }
    }

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */

}