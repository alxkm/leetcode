package com.leetcode.dif;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueExample {
    PriorityQueue<Food> queueExample = new PriorityQueue<>((x, y) -> {
        if (x.rating == y.rating) {
            return x.name.compareTo(y.name);
        }
        return y.rating - x.rating;
    });

    class Food implements Comparable<Food> {
        String name;
        int rating;

        public Food(String name, int rating) {
            this.name = name;
            this.rating = rating;
        }

        @Override
        public int compareTo(Food o) {
            if (rating == o.rating) {
                return name.compareTo(o.name);
            }
            return o.rating - rating;
        }

        @Override
        public String toString() {
            return "Food name " + name + ", rating " + rating;
        }
    }

    private static void printPriorityQueue(PriorityQueue<Food> pq) {
        var p = new PriorityQueue<>(pq);
        while(!p.isEmpty()) System.out.println(p.poll());
        //pq.forEach(food -> System.out.println(food.));
    }

    public void changeElementsAndRemoveUsingIterator() {
        System.out.println("changeElementsAndRemoveUsingIterator");
        PriorityQueue<Food> pq = new PriorityQueue<>();
        pq.add(new Food("miso", 12));
        pq.add(new Food("sushi", 8));
        pq.add(new Food("ramen", 14));

        Food food = null;
        var it = pq.iterator();
        System.out.println("BEFORE");
        printPriorityQueue(pq);
        while (it.hasNext()) {
            var foundFood = it.next();
            if (foundFood.name.equals("sushi")) {
                foundFood.rating = 16;
                food = foundFood;
                it.remove();
                break;
            }
        }
        pq.add(food);
        //now it removed and order should be sushi ramen miso
        System.out.println("AFTER");
        printPriorityQueue(pq);
    }

    public void changeElementsAndRemoveObjectFromQueueSushi() {
        System.out.println("changeElementsAndRemoveObjectFromQueueSushi");
        PriorityQueue<Food> pq = new PriorityQueue<>();
        pq.add(new Food("miso", 12));
        pq.add(new Food("sushi", 8));
        pq.add(new Food("ramen", 14));
        System.out.println("BEFORE");
        printPriorityQueue(pq);
        Food food = null;
        for (Food foundFood : pq) {
            if (foundFood.name.equals("sushi")) {
                foundFood.rating = 16;
                food = foundFood;
                break;
            }
        }
        pq.remove(food);
        pq.add(food);
        //now it removed and order should be sushi ramen miso
        System.out.println("AFTER");
        printPriorityQueue(pq);
    }

    public void changeElementsAndRemoveObjectFromQueueSushiRamen() {
        System.out.println("changeElementsAndRemoveObjectFromQueueSushiRamen");
        PriorityQueue<Food> pq = new PriorityQueue<>();
        pq.add(new Food("miso", 12));
        pq.add(new Food("sushi", 8));
        pq.add(new Food("ramen", 14));

        System.out.println("BEFORE");
        printPriorityQueue(pq);

        Food food = null;
        for (Food foundFood : pq) {
            if (foundFood.name.equals("sushi")) {
                foundFood.rating = 16;
                food = foundFood;
                break;
            }
        }
        pq.remove(food);
        pq.add(food);
        printPriorityQueue(pq);
        for (Food foundFood : pq) {
            if (foundFood.name.equals("ramen")) {
                foundFood.rating = 16;
                food = foundFood;
                break;
            }
        }
        pq.remove(food);
        pq.add(food);
        //now it removed and order should be sushi ramen miso
        System.out.println("AFTER");
        printPriorityQueue(pq);
    }

    public void changeRatingOfSushiRamenThenReassignAllQueue() {
        System.out.println("changeRatingOfSushiRamenThenReassignAllQueue");
        PriorityQueue<Food> pq = new PriorityQueue<>();
        pq.add(new Food("miso", 12));
        pq.add(new Food("sushi", 8));
        pq.add(new Food("ramen", 14));

        for (Food foundFood : pq) {
            if (foundFood.name.equals("sushi")) {
                foundFood.rating = 16;
                break;
            }
        }
        for (Food foundFood : pq) {
            if (foundFood.name.equals("ramen")) {
                foundFood.rating = 16;
                break;
            }
        }
        System.out.println("BEFORE");
        printPriorityQueue(pq);

        List<Food> tempList = new ArrayList<>();
        while (!pq.isEmpty()) {
            tempList.add(pq.poll());
        }
        pq.clear();
        pq.addAll(tempList);
        System.out.println("AFTER");
        printPriorityQueue(pq);
        //pq.remove(food);
        //pq.add(food);
        //now it removed and order should be sushi ramen miso
    }

    public static void main(String[] args) {
        PriorityQueueExample ex = new PriorityQueueExample();

        ex.changeElementsAndRemoveUsingIterator();
        ex.changeElementsAndRemoveObjectFromQueueSushi();
        ex.changeElementsAndRemoveObjectFromQueueSushiRamen();
        ex.changeRatingOfSushiRamenThenReassignAllQueue();

//        PriorityQueue<Food> pq = new PriorityQueue<>((x, y) -> {
//            if (x.rating == y.rating) {
//                return x.name.compareTo(y.name);
//            }
//            return y.rating - x.rating;
//        });
//
//
//        //then i put
//
//        pq.add(new Food("miso", 12));
//        pq.add(new Food("sushi", 8));
//        pq.add(new Food("ramen", 14));
//
//        //than
//        //do next
//
//        Food f = null;
//        var it = pq.iterator();
//        while (it.hasNext()) {
//            var el = it.next();
//            if (el.name.equals("sushi")) {
//                f = el;
//                it.remove();
//                break;
//            }
//        }
//        f.rating = 16;
//        pq.add(f);
//
//        List<Food> tempList = new ArrayList<>();
////        while (!pq.isEmpty()) {
////            tempList.add(pq.poll());
////        }
//        // tempList.add(f);
//        //tempList.add(new Food(f.name, 16));
//        tempList.forEach(pq::add);
//
//        //and get
//        //Food name sushi, rating 16
//        //Food name miso, rating 12
//        //Food name ramen, rating 14
//        PriorityQueue<Food> newPq = new PriorityQueue<>((x, y) -> {
//            if (x.rating == y.rating) {
//                return x.name.compareTo(y.name);
//            }
//            return y.rating - x.rating;
//        });
//        newPq.add(new Food("sushi", 16));
//        newPq.add(new Food("ramen", 14));
//        newPq.add(new Food("miso", 12));
//        System.out.println(pq);
//
//        //but i want to get another order
//        //Food name sushi, rating 16
//        //Food name ramen, rating 14
//        //Food name miso, rating 12
    }
}
