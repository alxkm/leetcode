package com.leetcode.top.top175;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _17_Letter_Combinations_of_a_Phone_Number {
    //https://leetcode.com/problems/letter-combinations-of-a-phone-number/

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        List<String> alp = new ArrayList<>();

        for (char ch: digits.toCharArray()) {
            alp.add(map.get((int)(ch - '0')));
        }
        f(list, alp, digits.length(), new StringBuilder(), 0);
        return list;
    }

    private void f(List<String> result, List<String> alp, int size, StringBuilder sb, int i) {
        if (sb.length() == size) {
            result.add(sb.toString());
            return;
        }
        if (i >= alp.size()) return;

        for (int j = 0; j < alp.get(i).length(); j++) {
            sb.append(alp.get(i).charAt(j));
            f(result, alp, size, sb, i + 1);
            sb.setLength(sb.length() - 1);
        }
    }


    public List<String> letterCombinations1(String digits) {
        List<String> list = new ArrayList<>();
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        StringBuilder alphabet = new StringBuilder();
        for (char ch: digits.toCharArray()) {
            alphabet.append(map.get((int)(ch - '0')));
        }
        f1(list, alphabet, digits.length(), new StringBuilder(), 0, new boolean[alphabet.length()]);
        return list;
    }

    private void f1(List<String> result, StringBuilder alphabet, int size, StringBuilder sb, int i, boolean[] visited) {
        if (sb.length() == size) {
            result.add(sb.toString());
            return;
        }
        if (i < alphabet.length())

        if (visited[i]) return;

        for (int j = i; j < alphabet.length(); j++) {
            visited[j] = true;
            sb.append(alphabet.charAt(j));
            f1(result, alphabet, size, sb, j + 1, visited);
            sb.setLength(sb.length() - 1);
            visited[j] = false;
        }
    }

    public static void main(String[] args) {
        String a = "23";

        _17_Letter_Combinations_of_a_Phone_Number solution = new _17_Letter_Combinations_of_a_Phone_Number();
        System.out.println(solution.letterCombinations(a));
    }
}
