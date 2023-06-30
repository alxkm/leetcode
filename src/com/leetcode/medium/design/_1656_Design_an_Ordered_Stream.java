package com.leetcode.medium.design;

import java.util.ArrayList;
import java.util.List;

public class _1656_Design_an_Ordered_Stream {
    //https://leetcode.com/problems/design-an-ordered-stream/

    class OrderedStream {
        private String[] a;
        private int ptr;
        public OrderedStream(int n) {
            a = new String[n];
        }

        public List<String> insert(int idKey, String value) {
            a[idKey - 1] = value;
            List<String> l = new ArrayList<>();
            for (int i = ptr; i < a.length && a[i] != null; i++) l.add(a[i]);
            if (ptr == idKey - 1) {
                while (ptr < a.length && a[ptr] != null) ptr++;
            }
            return l;
        }
    }
}
