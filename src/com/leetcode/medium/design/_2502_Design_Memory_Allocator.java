package com.leetcode.medium.design;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _2502_Design_Memory_Allocator {
    //https://leetcode.com/problems/design-memory-allocator/
    //2502. Design Memory Allocator

    public static class Allocator {
        private int[] memory;

        public Allocator(int n) {
            memory = new int[n];
        }

        public int allocate(int size, int mID) {
            for (int i = 0; i < memory.length; i++) {
                int end = i + size;
                if (end > memory.length) {
                    return -1;
                }

                if (memory[i] == 0 && memory[end - 1] == 0) {
                    int counter = 0;
                    for (int j = i; j < end; j++) {
                        if (memory[j] == 0) {
                            counter++;
                        }
                    }
                    if (counter == size) {
                        for (int j = i; j < end; j++) {
                            memory[j] = mID;
                        }
                        return i;
                    }
                } else if (memory[end - 1] != 0) {
                    i += (size - 1);
                }
            }
            return -1;
        }

        public int free(int mID) {
            int counter = 0;
            for (int i = 0; i < memory.length; i++) {
                if (memory[i] == mID) {
                    memory[i] = 0;
                    counter++;
                }
            }
            return counter;
        }
    }

    class Allocator1 {
        private int[] memory;
        private Map<Integer, Set<int[]>> map = new HashMap<>();

        public Allocator1(int n) {
            memory = new int[n];
        }

        public int allocate(int size, int mID) {
            for (int i = 0; i < memory.length; i++) {
                int end = i + size;
                if (end > memory.length) {
                    return -1;
                }

                if (memory[i] == 0 && memory[end - 1] == 0) {
                    int counter = 0;
                    for (int j = i; j < end; j++) {
                        if (memory[j] == 0) {
                            counter++;
                        }
                    }
                    if (counter == size) {
                        for (int j = i; j < end; j++) {
                            memory[j] = mID;
                        }
                        if (map.get(mID) == null) {
                            map.put(mID, new HashSet<>());
                        }
                        map.get(mID).add(new int[]{i, size});
                        return i;
                    }
                } else if (memory[end - 1] != 0) {
                    i += (size - 1);
                }
            }
            return -1;
        }

        public int free(int mID) {
            int counter = 0;
            Set<int[]> set = map.get(mID);

            if (set == null) return counter;

            for (int[] mem: set) {
                for (int i = mem[0]; i < mem[0] + mem[1]; i++) {
                    memory[i] = 0;
                    counter++;
                }
            }
            map.remove(mID);
            return counter;
        }
    }

    /**
     * Your Allocator object will be instantiated and called as such:
     * Allocator obj = new Allocator(n);
     * int param_1 = obj.allocate(size,mID);
     * int param_2 = obj.free(mID);
     */

    public static void main(String[] args) {
        //["Allocator","allocate","allocate","allocate","free","allocate","allocate","allocate","free","allocate","free"]
        //[[10],[1,1],[1,2],[1,3],[2],[3,4],[1,1],[1,1],[1],[10,2],[7]]
        Allocator a = new Allocator(10);
        a.allocate(1, 1);
        a.allocate(1, 2);
        a.allocate(1, 3);
        a.free(2);
        a.allocate(3, 4);
        a.allocate(1, 1);
        a.allocate(1, 1);
        a.free(1);
        a.allocate(10, 2);
        a.free(7);
        //[null,0,1,2,1,3,1,6,3,-1,0]

        //["Allocator","free","allocate","allocate","allocate","allocate","free","allocate","free"]
        //[[5],[4],[9,5],[5,8],[4,8],[3,2],[6],[9,9],[6]]
        Allocator a1 = new Allocator(5);
        a1.free(4);
        a1.allocate(9, 5);
        a1.allocate(5, 8);
        a1.allocate(4, 8);
        a1.allocate(3, 2);
        a1.free(6);
        a1.allocate(9, 9);
        a1.free(6);
        //[null,0,-1,0,-1,-1,0,-1,0]
    }

}
