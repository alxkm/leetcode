package com.leetcode.medium.prefix;

import java.util.ArrayList;
import java.util.List;

public class _1352_Product_of_the_Last_K_Numbers {
    //https://leetcode.com/problems/product-of-the-last-k-numbers/description/
    //1352. Product of the Last K Numbers

    class ProductOfNumbers {
        private List<Integer> prefix = new ArrayList<>();
        private int size = 0;

        public ProductOfNumbers() {
            prefix.add(1);
            size = 0;
        }

        public void add(int num) {
            if (num == 0) {
                prefix = new ArrayList<>();
                prefix.add(1);
                size = 0;
            } else {
                prefix.add(prefix.get(size) * num);
                size++;
            }
        }

        public int getProduct(int k) {
            if (k > size) return 0;

            return (prefix.get(size) / prefix.get(size - k));
        }
    }

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
}
