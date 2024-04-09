package com.leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

class Item1 {
    int weight;
    int value;

    public Item1(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

public class KnapsackBruteForce {
    public static List<Item> knapsack(int W, List<Item> items) {
        int n = items.size();
        int maxVal = 0;
        int maxWeight = 0;
        List<Item> result = new ArrayList<>();

        for (int i = 0; i < (1 << n); i++) {
            int totalWeight = 0;
            int totalValue = 0;
            List<Item> currentItems = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    totalWeight += items.get(j).weight;
                    totalValue += items.get(j).value;
                    currentItems.add(items.get(j));
                }
            }

            // Check if current combination is feasible and maximizes value
            if (totalWeight <= W && totalValue > maxVal) {
                maxVal = totalValue;
                maxWeight = totalWeight;
                result = new ArrayList<>(currentItems);
            }
        }

        System.out.println("Maximum value: " + maxVal);
        System.out.println("Total weight: " + maxWeight);
        return result;
    }

    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item(2, 12));
        items.add(new Item(1, 10));
        items.add(new Item(3, 20));
        items.add(new Item(2, 15));
        items.add(new Item(4, 25));

        int W = 8;
        List<Item> selectedItems = knapsack(W, items);

        System.out.println("Selected items:");
        for (Item item : selectedItems) {
            System.out.println("Weight: " + item.weight + ", Value: " + item.value);
        }
    }
}
