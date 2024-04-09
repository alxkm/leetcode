package com.leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

class Item {
    int weight;
    int value;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

public class KnapsackDP {
    public static List<Item> knapsack(int W, List<Item> items) {
        int n = items.size();
        int[][] dp = new int[n + 1][W + 1];

        // Initialize the dp table
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (items.get(i - 1).weight <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - items.get(i - 1).weight] + items.get(i - 1).value);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Retrieve selected items
        List<Item> selectedItems = new ArrayList<>();
        int i = n, j = W;
        while (i > 0 && j > 0) {
            if (dp[i][j] != dp[i - 1][j]) {
                selectedItems.add(items.get(i - 1));
                j -= items.get(i - 1).weight;
            }
            i--;
        }

        return selectedItems;
    }

    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item(2, 12));
        items.add(new Item(1, 10));
        items.add(new Item(3, 20));
        items.add(new Item(2, 15));
        items.add(new Item(4, 25));

        int W = 8; // Knapsack capacity
        List<Item> selectedItems = knapsack(W, items);

        System.out.println("Selected items:");
        for (Item item : selectedItems) {
            System.out.println("Weight: " + item.weight + ", Value: " + item.value);
        }
    }
}