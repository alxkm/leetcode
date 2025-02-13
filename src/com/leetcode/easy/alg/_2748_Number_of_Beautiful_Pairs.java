package com.leetcode.easy.alg;

import com.leetcode.Pair;

import java.util.HashMap;
import java.util.Map;

public class _2748_Number_of_Beautiful_Pairs {
    //https://leetcode.com/problems/number-of-beautiful-pairs/description/
    //2748. Number of Beautiful Pairs

    public int countBeautifulPairs(int[] nums) {
        int counter = 0;
        Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                map.put(new Pair<>(i, j), gcd(i, j));
            }
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int a = (int)(Integer.valueOf(nums[i]).toString().charAt(0) - '0');
                int b = nums[j] % 10;
                if (map.get(new Pair<>(a, b)) == 1) {
                    counter++;
                }
            }
        }
        return counter;
    }


    int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
