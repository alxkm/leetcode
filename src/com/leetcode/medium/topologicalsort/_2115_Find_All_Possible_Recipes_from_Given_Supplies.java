package com.leetcode.medium.topologicalsort;

import com.leetcode.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class _2115_Find_All_Possible_Recipes_from_Given_Supplies {
    //https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/submissions/1581266385/?envType=daily-question&envId=2025-03-21
    //2115. Find All Possible Recipes from Given Supplies

    public static List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
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

    public static void main(String[] args) {
        System.out.println(findAllRecipes(ArrayUtil.of("bread"), List.of(List.of("yeast","flour")), ArrayUtil.of("yeast","flour","corn")));
    }

    class Solution {
        String rootRecipe = "";
        public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
            Set<String> supplySet = new HashSet<>(Arrays.asList(supplies));

            Map<String, Integer> recipeIdx = new HashMap<>();
            for(int i=0;i<recipes.length;i++){
                recipeIdx.put(recipes[i],i);
            }

            List<String> result = new ArrayList<>();
            Map<String, Boolean> visited = new HashMap<>();
            Set<String> visitedRecipes = new HashSet<>();
            for(int i=0;i<recipes.length;i++){
                rootRecipe = recipes[i];
                if(dfs(recipes[i], ingredients, supplySet, recipeIdx, visited, visitedRecipes)){
                    result.add(recipes[i]);
                }
            }
            return result;
        }

        private boolean dfs(String recipe, List<List<String>> ingredients,
                            Set<String> supplySet,  Map<String, Integer> recipeIdx,
                            Map<String, Boolean> visited, Set<String> visitedRecipes){
            if(visited.containsKey(recipe)) return visited.get(recipe);
            if(visitedRecipes.contains(recipe)) return false;
            visitedRecipes.add(recipe);
            List<String> recipeIngredients = ingredients.get(recipeIdx.get(recipe));
            // boolean canCreate = true;
            for(String ingredient : recipeIngredients){
                if(recipeIdx.containsKey(ingredient)){
                    if(!dfs(ingredient, ingredients, supplySet, recipeIdx, visited, visitedRecipes)){
                        visited.put(ingredient,false);
                        return false;
                    }
                }
                else if(!supplySet.contains(ingredient)){
                    return false;
                }
            }
            visited.put(recipe,true);
            return true;
        }
    }
}
