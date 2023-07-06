package com.leetcode.top.top175;

public class _904_Fruit_Into_Baskets {
    //904. Fruit Into Baskets
    //https://leetcode.com/problems/fruit-into-baskets/

    public int totalFruit(int[] fruits) {
        int max = 1, id1 = fruits[0], id2 = -1, c1 = 1, c2 = 0;
        for (int i = 1; i < fruits.length; i++) {
            if (fruits[i] == id1 ) {
                c1++;
            } else if (fruits[i] == id2 || id2 == -1) {
                if (id2 == -1) {
                    id2 = fruits[i];
                }
                c2++;
            } else {
                max = Math.max(c1 + c2, max);
                if (fruits[i - 1] == id1) {
                    c1 = 1;
                    c2 = 1;
                    id2 = fruits[i];
                } else {
                    id1 = id2;
                    c1 = c2;
                    id2 = fruits[i];
                    c2 = 1;
                }

            }
            max = Math.max(c1 + c2, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {1,0,0,0,1,0,4,0,4};
        _904_Fruit_Into_Baskets solution = new _904_Fruit_Into_Baskets();
        System.out.println(solution.totalFruit(a));
    }
}
