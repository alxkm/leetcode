package com.leetcode.top.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _402_Remove_K_Digits {
    //https://leetcode.com/problems/remove-k-digits/description/
    //402. Remove K Digits

    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        for (char ch: num.toCharArray()) {
            while (k > 0 && !st.isEmpty() && st.peek() > ch) {
                st.pop();
                k--;
            }
            st.push(ch);
        }
        while (k > 0) {
            st.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        for (char ch: st) {
            if (sb.length() == 0 && ch == '0') continue;
            sb.append(ch);
        }

        return (sb.length() == 0) ? "0" : sb.toString();
    }

    public int trap(int[] height) {
        int l = 0, r = 1;
        int n = height.length;
        int sum = 0;
        while (l < n) {
            boolean found = false;
            int next = l + 1;
            for (int maxHeight = height[l]; maxHeight > 0 && !found; maxHeight--) {
                int s = 0;
                for (int j = l + 1; j < n; j++) {
                    if (height[j] >= maxHeight) {
                        found = true;
                        next = j;
                        break;
                    }
                    s += maxHeight - height[j];
                }
                if (found) {
                    sum += s;
                    l = next;
                } else {
                    break;
                }
            }

            if (!found) l++;
        }
        return sum;
    }

    public int maximalRectangle(char[][] matrix) {
        int[] height = new int[matrix[0].length];
        int max = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') height[j]++;
                else height[j] = 0;
            }
            max = Math.max(max, getMaxHistogram(height));
        }
        return max;
    }

    private int getMaxHistogram(int[] histogram) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        int n = histogram.length;
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && (i == n || histogram[st.peek()] >= histogram[i])) {
                int height = histogram[st.peek()];
                st.pop();
                int width;
                if (st.isEmpty()) width = i;
                else width = i - st.peek() - 1;
                maxArea = Math.max(maxArea, width * height);
            }
            st.push(i);
        }
        return maxArea;
    }



    public int maximalRectangle1(char[][] matrix) {
        if (matrix.length == 0)
            return 0;

        int result = 0;
        int[] hist = new int[matrix[0].length];

        for (char[] row : matrix) {
            for (int i = 0; i < row.length; ++i)
                hist[i] = row[i] == '0' ? 0 : hist[i] + 1;
            result = Math.max(result, largestArea(hist));
        }

        return result;
    }

    private int largestArea(int[] hist) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= hist.length; ++i) {
            while (!stack.isEmpty() && (i == hist.length || hist[stack.peek()] > hist[i])) {
                int m = hist[stack.peek()];
                stack.pop();
                int v = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, m * v);
            }
            stack.push(i);
        }

        return maxArea;
    }

    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> l = new ArrayList<>();
        int[] max = new int[26];
        for (String s : words2) {
            int[] curCounter = new int[26];
            for (char c : s.toCharArray()) {
                int i = (c - 'a');
                max[i] = Math.max(++curCounter[i], max[i]);
            }
        }

        for (String value : words1) {
            int[] curCounter = new int[26];
            for (char c : value.toCharArray()) {
                curCounter[c - 'a']++;
            }

            boolean includesAll = true;
            for (int i = 0; i < curCounter.length; i++) {
                if (curCounter[i] < max[i]) {
                    includesAll = false;
                    break;
                }
            }
            if (includesAll) l.add(value);
        }
        return l;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0}
        };
        var sol = new _402_Remove_K_Digits();
        String[] w1 = new String[]{"amazon","apple","facebook","google","leetcode"};
        String[] w2 = new String[]{"lo","eo"};
        System.out.println(sol.wordSubsets(w1, w2));

        char[][] charMatrix = new char[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                charMatrix[i][j] = matrix[i][j] == 1 ? '1' : '0';
            }
        }
        /////System.out.println(sol.maximalRectangle(charMatrix));
        //System.out.println(sol.trap(ArrayUtil.of(0,1,0,2,1,0,1,3,2,1,2,1)));
    }

}
