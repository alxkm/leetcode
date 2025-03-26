package com.leetcode.medium.graph_hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class _2115_Find_All_Possible_Recipes_from_Given_Supplies {
    //2115. Find All Possible Recipes from Given Supplies
    //https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/description/

    public List<String> findAllRecipes(String[] recipes,
                                        List<List<String>> ingredients, String[] supplies) {
        List<String> created = new ArrayList<>();

        boolean[] checked = new boolean[recipes.length];

        Map<String, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) {
            String r = recipes[i];
            for (String ingredient : ingredients.get(i)) {
                map.computeIfAbsent(ingredient, k -> new HashSet<>()).add(i);
            }
        }

        Set<String> suppliesSet = new HashSet<>();
        Collections.addAll(suppliesSet, supplies);
        Queue<String> q = new LinkedList<>();
        Collections.addAll(q, supplies);

        while (!q.isEmpty()) {
            String ingridient = q.poll();

            for (var i : map.getOrDefault(ingridient, new HashSet<>())) {
                if (!checked[i]) {
                    String r = recipes[i];
                    boolean containsAll = true;
                    for (String subIngredient : ingredients.get(i)) {
                        if (!suppliesSet.contains(subIngredient)) {
                            containsAll = false;
                            break;
                        }
                    }
                    if (containsAll) {
                        checked[i] = true;
                        created.add(r);
                        suppliesSet.add(r);
                        q.offer(r);
                    }
                }
            }

        }

        return created;
    }
}
