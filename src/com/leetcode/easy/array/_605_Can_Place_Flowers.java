package com.leetcode.easy.array;

public class _605_Can_Place_Flowers {
    static public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        if (flowerbed.length == 1) return (flowerbed[0] == 0 && n == 1);

        for (int i = 0; i < flowerbed.length; i++) {
            if (n == 0) break;
            if (flowerbed[i] == 1) continue;

            if (i == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                n--;
                i++;
                continue;
            }
            if ((i == flowerbed.length - 1) && flowerbed[i] == 0 && flowerbed[i - 1] == 0) {
                n--;
                break;
            }
            if ((i == 0 && flowerbed[i] == 1) || (i != 0 && flowerbed[i - 1] == 1)) continue;
            if ((i == 0 && flowerbed[i + 1] == 1)) continue;

            if (flowerbed[i - 1] == 0 && flowerbed[i] == 0 && (i + 1 < flowerbed.length) && flowerbed[i + 1] == 0) {
                n--;
                i++;
            }
        }
        return n == 0;
    }

    public static void main(String[] args) {
        //int[] a = {1,0,0,0,1};
        //int[] a = {1,0,0,0,0,1}; // false 2
        //int[] a = {1,0,0,0,0,0,1}; // true 2
        //int[] a = {1,0,0,0,1,0,0};
        //int[] a = {1,0};
        //int[] a = {0, 1, 0};
        //int[] a = {1,0,0,0,1,0,0};
        //int n = 2;
        //int[] a = {1,0,0,0,0};
        //int n = 2;
        int[] a = {0,0,1,0,0};
        int n = 2;
        System.out.println(canPlaceFlowers(a, n));
    }
}
