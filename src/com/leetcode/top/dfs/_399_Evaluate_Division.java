package com.leetcode.top.dfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _399_Evaluate_Division {
    //https://leetcode.com/problems/evaluate-division/
    //FOREIGN_SOLUTION
    //TOP

    public void dfs(
            String node, String dest, Map<String, Map<String, Double>> gr,
            Set<String> visited, double[] ans, double temp) {
        if (visited.contains(node))
            return;

        visited.add(node);
        if (node.equals(dest)) {
            ans[0] = temp;
            return;
        }

        for (Map.Entry<String, Double> entry : gr.get(node).entrySet()) {
            String ne = entry.getKey();
            double val = entry.getValue();
            dfs(ne, dest, gr, visited, ans, temp * val);
        }
    }

    public Map<String, Map<String, Double>> buildGraph(
            List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> gr = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String dividend = equations.get(i).get(0);
            String divisor = equations.get(i).get(1);
            double value = values[i];

            gr.putIfAbsent(dividend, new HashMap<>());
            gr.putIfAbsent(divisor, new HashMap<>());

            gr.get(dividend).put(divisor, value);
            gr.get(divisor).put(dividend, 1.0 / value);
        }

        return gr;
    }

    public double[] calcEquation(
            List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, Map<String, Double>> gr = buildGraph(equations, values);
        double[] finalAns = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String dividend = queries.get(i).get(0);
            String divisor = queries.get(i).get(1);

            if (!gr.containsKey(dividend) || !gr.containsKey(divisor)) {
                finalAns[i] = -1.0;
            } else {
                Set<String> vis = new HashSet<>();
                double[] ans = {-1.0};
                double temp = 1.0;
                dfs(dividend, divisor, gr, vis, ans, temp);
                finalAns[i] = ans[0];
            }
        }

        return finalAns;
    }
}
