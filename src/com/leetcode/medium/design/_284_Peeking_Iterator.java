package com.leetcode.medium.design;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _284_Peeking_Iterator {
    //284. Peeking Iterator
    //https://leetcode.com/problems/peeking-iterator/


    // Java Iterator interface reference:
    // https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

    class PeekingIterator implements Iterator<Integer> {
        private List<Integer> l = new ArrayList<>();
        private int i = 0;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            while (iterator.hasNext()) {
                l.add(iterator.next());
            }
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return l.get(i);
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            return l.get(i++);
        }

        @Override
        public boolean hasNext() {
            return i < l.size();
        }
    }

    class PeekingIterator1 implements Iterator<Integer> {
        private Iterator<Integer> it;
        private Integer next = null;

        public PeekingIterator1(Iterator<Integer> iterator) {
            // initialize any member here.
            it = iterator;
            if (it.hasNext()) next = it.next();
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return next;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            Integer temp = next;
            next = (it.hasNext()) ? it.next() : null;
            return temp;

        }

        @Override
        public boolean hasNext() {
            return next != null;
        }
    }
}
