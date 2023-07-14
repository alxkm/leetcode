package com.leetcode.medium.backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class _1286_Iterator_for_Combination {
    //https://leetcode.com/problems/iterator-for-combination/

    class CombinationIterator {
        private List<String> list;
        private int cur = 0;

        public CombinationIterator(String characters, int combinationLength) {
            Set<String> treeSet = new TreeSet<>();
            int n = combinationLength;
            f(treeSet, characters, combinationLength, 0, new StringBuilder());
            this.list = new ArrayList<>(treeSet);
            System.out.println(list);
        }

        public String next() {
            return list.get(cur++);
        }

        public boolean hasNext() {
            if (cur < list.size()) return true;
            return false;
        }

        private void f(Set<String> set, String s, int n, int start, StringBuilder sb) {
            if (n == 0){
                set.add(sb.toString());
                return;
            }
            for (int i = start; i <= s.length() - n; i++){
                sb.append(s.charAt(i));
                f(set, s, n - 1, i + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
