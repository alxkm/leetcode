package com.leetcode.medium.design;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _341_Flatten_Nested_List_Iterator {
    //https://leetcode.com/problems/flatten-nested-list-iterator/

    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation
     * public interface NestedInteger {
     * <p>
     * // @return true if this NestedInteger holds a single integer, rather than a nested list.
     * public boolean isInteger();
     * <p>
     * // @return the single integer that this NestedInteger holds, if it holds a single integer
     * // Return null if this NestedInteger holds a nested list
     * public Integer getInteger();
     * <p>
     * // @return the nested list that this NestedInteger holds, if it holds a nested list
     * // Return empty list if this NestedInteger holds a single integer
     * public List<NestedInteger> getList();
     * }
     */
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public class NestedIterator implements Iterator<Integer> {
        //https://leetcode.com/problems/flatten-nested-list-iterator/
        //Flatten Nested List Iterator

        private List<Integer> list = new ArrayList<>();
        private int index = 0;

        public NestedIterator(List<NestedInteger> nestedList) {
            dfs(nestedList);
        }

        private void dfs(List<NestedInteger> l) {
            for (int i = 0; i < l.size(); i++) {
                if (l.get(i).isInteger()) {
                    list.add(l.get(i).getInteger());
                } else {
                    dfs(l.get(i).getList());
                }
            }
        }

        @Override
        public Integer next() {
            return list.get(index++);
        }

        @Override
        public boolean hasNext() {
            return list.size() > index;
        }
    }
}
