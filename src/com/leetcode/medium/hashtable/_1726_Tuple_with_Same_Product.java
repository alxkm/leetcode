package com.leetcode.medium.hashtable;

import java.util.HashMap;
import java.util.Map;

public class _1726_Tuple_with_Same_Product {
    //https://leetcode.com/problems/tuple-with-same-product/description/
    //1726. Tuple with Same Product

    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int product = nums[i] * nums[j];
                var cur = map.getOrDefault(product, 0);
                map.put(product, map.getOrDefault(product, 0) + 1);
                size += cur;
            }
        }
        return size * 8;
    }
}
