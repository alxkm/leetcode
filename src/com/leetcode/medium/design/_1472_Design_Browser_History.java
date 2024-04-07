package com.leetcode.medium.design;

import java.util.ArrayList;
import java.util.List;

public class _1472_Design_Browser_History {
    //https://leetcode.com/problems/design-browser-history/
    //1472. Design Browser History

    class BrowserHistory {
        private final List<String> sites = new ArrayList<>();
        private int cur = 0;

        public BrowserHistory(String homepage) {
            sites.add(homepage);
        }

        public void visit(String url) {
            for (int i = sites.size() - 1; i > cur; i--) {
                sites.remove(i);
            }
            sites.add(url);
            cur = sites.size() - 1;
        }

        public String back(int steps) {
            cur -= steps;
            if (cur < 0) {
                cur = 0;
            }
            return sites.get(cur);
        }

        public String forward(int steps) {
            cur += steps;
            if (cur >= sites.size()) {
                cur = sites.size() - 1;
            }
            return sites.get(cur);
        }
    }

    /**
     * Your BrowserHistory object will be instantiated and called as such:
     * BrowserHistory obj = new BrowserHistory(homepage);
     * obj.visit(url);
     * String param_2 = obj.back(steps);
     * String param_3 = obj.forward(steps);
     */
}
