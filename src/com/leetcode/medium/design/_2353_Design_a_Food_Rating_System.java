package com.leetcode.medium.design;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _2353_Design_a_Food_Rating_System {
    //2353. Design a Food Rating System
    //https://leetcode.com/problems/design-a-food-rating-system/

    static class FoodRatings {
        private class Food {
            String name;
            String cuisine;
            int rating;
            public Food(String name, String cuisine, int rating) {this.name = name; this.cuisine = cuisine; this.rating = rating;}
        }

        private Map<String, PriorityQueue<Food>> map = new HashMap<>();
        private Map<String, Food> foodMap = new HashMap<>();

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            for (int i = 0; i < foods.length; i++) {
                var pq = map.get(cuisines[i]);
                if (pq == null) {
                    pq = new PriorityQueue<>((x, y) -> {
                        if (x.rating == y.rating) {
                            return x.name.compareTo(y.name);
                        }
                        return y.rating - x.rating;
                    });
                }
                var food = new Food(foods[i], cuisines[i], ratings[i]);
                pq.offer(food);
                map.put(cuisines[i], pq);
                foodMap.put(foods[i], food);
            }
        }

        public void changeRating(String food, int newRating) {
            var prev = foodMap.get(food);
            var newFood = new Food(food, prev.cuisine, newRating);
            foodMap.put(food, newFood);
            prev.name = "";
            map.get(prev.cuisine).add(newFood);
        }

        public String highestRated(String cuisine) {
            while(map.get(cuisine).peek().name.equals("")) {
                map.get(cuisine).remove();
            }
            return map.get(cuisine).peek().name;
        }
    }

    /**
     * Your FoodRatings object will be instantiated and called as such:
     * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
     * obj.changeRating(food,newRating);
     * String param_2 = obj.highestRated(cuisine);
     */


    public static void main(String[] args) {

        String[] foods = {  "kimchi",     "miso",     "sushi",    "moussaka", "ramen",    "bulgogi"};
        String[] cuisines = {"korean", "japanese", "japanese", "greek",     "japanese", "korean"};
        int[] ratings = {9, 12, 8, 15, 14, 7};

        var sol = new FoodRatings(foods, cuisines, ratings);

        //["korean"], ["japanese"], ["sushi", 16], ["japanese"], ["ramen", 16], ["japanese"]
        //["FoodRatings", "highestRated", "highestRated", "changeRating", "highestRated", "changeRating", "highestRated"]
        //[null,"bulgogi","sushi",null,"sushi",null,"sushi"]

        System.out.println(sol.highestRated("korean"));
        System.out.println(sol.highestRated("japanese"));
        sol.changeRating("sushi", 16);
        System.out.println(sol.highestRated("japanese"));
        sol.changeRating("ramen", 16);
        System.out.println(sol.highestRated("japanese"));
    }
}
