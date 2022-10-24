package com.leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _989_Add_to_Array_Form_of_Integer {
    class Solution {
        public List<Integer> addToArrayForm(int[] num, int k) {
            List<Integer> ar = new ArrayList<>();
            List<Integer> listNum = new ArrayList<>();
            int base = 1;
            while (k > 0) {
                if (base == 1) {
                    listNum.add(k % 10);
                    k = k - k % 10;
                } else {
                    int temp = k / base % 10;
                    listNum.add(temp);
                    k = k - temp * base;
                }
                base *= 10;
            }

            int[] num1 = new int[listNum.size()];
            for (int i =  listNum.size() - 1, j = 0; i >= 0; j++,  i--) {
                num1[j] = listNum.get(j);
            }

            int[] num2 = new int[num.length];

            for (int i = num.length - 1, j = 0; i >= 0; i--, j++) {
                num2[j] = num[i];
            }

            int r = 0;
            int max = Math.max(num2.length, num1.length);

            for (int i = 0; i < max; i++) {
                int x = num2.length > i ? num2[i] : 0;
                int y = num1.length > i ? num1[i] : 0;

                int value = x + y + r;
                r = 0;
                ar.add(value % 10);
                if (value / 10 != 0) {
                    r = value / 10;
                }
            }

            if (r > 0) {
                ar.add(r);
            }
            Collections.reverse(ar);
            return ar;
        }
    }

    /*
    *
    *
 int i=num.size()-1;
 auto carry=0;
 while(carry || k)
 {
     carry += k%10;
     if(i >= 0)
     {
         carry += num[i];
         num[i--] = carry%10;
     }
     else
         num.insert(num.begin(), carry%10);
     k = k/10;
     carry = carry/10;
 }

 return num;
    *
    *
    * */
}
