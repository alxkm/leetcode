package com.leetcode.easy.alg;

import java.util.List;

public class Heap {
    private List<Integer> heap;

    private void heapify(Integer v) {

    }

    public void push(Integer v) {
        heap.add(v);
        for (int i = 0; i > 0; i++) {

        }
    }

    public Integer pop() {
        throw new IllegalStateException();
    }

    public Integer top() {
        if (heap.isEmpty()) return 0;
        return heap.get(0);
    }
}
