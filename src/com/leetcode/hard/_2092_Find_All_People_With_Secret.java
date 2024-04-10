package com.leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _2092_Find_All_People_With_Secret {
    //2092. Find All People With Secret
    //https://leetcode.com/problems/find-all-people-with-secret/
    //union find

//    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
//        Map<Integer, Map<Integer, Set<Integer>>> gr = new HashMap<>();
//        int maxTime = Integer.MIN_VALUE;
//        Set<Integer> timeSet = new HashSet<>();
//        int minTime = Integer.MAX_VALUE;
//        for (int[] m : meetings) {
//            gr.computeIfAbsent(m[2], k -> new HashMap<>());
//            gr.get(m[2]).computeIfAbsent(m[0], k -> new HashSet<>()).add(m[1]);
//            gr.get(m[2]).computeIfAbsent(m[1], k -> new HashSet<>()).add(m[0]);
//            maxTime = Math.max(maxTime, m[2]);
//            timeSet.add(m[2]);
//
//            if (m[0] == firstPerson || m[1] == firstPerson || m[0] == 0 || m[1] == 0) {
//                minTime = Math.min(m[2], minTime);
//            }
//        }
//        List<Integer> defaultAnswer = List.of(0, firstPerson);
//        List<Integer> time = new ArrayList<>(timeSet);
//        if (!time.contains(minTime)) return defaultAnswer;
//        Collections.sort(time);
//        Set<Integer> know = new HashSet<>(defaultAnswer);
//
//        for (int i = time.indexOf(minTime); i < time.size(); i++) {
//            Map<Integer, Set<Integer>> cur = gr.get(time.get(i));
//            for (Map.Entry<Integer, Set<Integer>> entry : cur.entrySet()) {
//                for (Integer p : entry.getValue()) {
//                    if (know.contains(p)) {
//                        know.addAll(entry.getValue());
//                        know.add(entry.getKey());
//                        break;
//                    }
//                }
//            }
//        }
//        return new ArrayList<>(know);
//    }
//
//
//    public List<Integer> findAllPeople1(int n, int[][] meetings, int firstPerson) {
//        //Arrays.sort(meetings, (x, y) -> x[2] - y[2]);
//
//        Map<Integer, Map<Integer, Set<Integer>>> gr = new HashMap<>();
//        int maxTime = Integer.MIN_VALUE;
//        Set<Integer> timeSet = new HashSet<>();
//        int minTime = Integer.MAX_VALUE;
//        for (int[] m : meetings) {
//            gr.computeIfAbsent(m[2], k -> new HashMap<>());
//            gr.get(m[2]).computeIfAbsent(m[0], k -> new HashSet<>()).add(m[1]);
//            gr.get(m[2]).computeIfAbsent(m[1], k -> new HashSet<>()).add(m[0]);
//            maxTime = Math.max(maxTime, m[2]);
//            timeSet.add(m[2]);
//
//            if (m[0] == firstPerson || m[1] == firstPerson || m[0] == 0 || m[1] == 0) {
//                minTime = Math.min(m[2], minTime);
//            }
//        }
//        List<Integer> defaultAnswer = List.of(0, firstPerson);
//        List<Integer> time = new ArrayList<>(timeSet);
//        if (!time.contains(minTime)) return defaultAnswer;
//        Collections.sort(time);
//        Set<Integer> know = new HashSet<>(defaultAnswer);
//
//        for (int i = time.indexOf(minTime); i < time.size(); i++) {
//            Map<Integer, Set<Integer>> cur = gr.get(time.get(i));
//            boolean[] used = new boolean[n];
//
//            //o(n) find corresponding first elements
//            //add all elements which presented in cur time and it intersection with know;
//            // after that dfs on each element;
//            Set<Integer> from = new HashSet<>();
//            for (Map.Entry<Integer, Set<Integer>> entry : cur.entrySet()) {
//                for (Integer p : entry.getValue()) {
//                    if (know.contains(p)) {
//                        from.add(p);
//                        from.add(entry.getKey());
//                    }
//                }
//            }
//
//            for (Integer v : from) {
//                dfs(cur, know, used, v);
//            }
//        }
//
//        return new ArrayList<>(know);
//    }
//
//    private void dfs(Map<Integer, Set<Integer>> gr, Set<Integer> know, boolean[] used, Integer v) {
//        if (used[v]) return;
//        used[v] = true;
//
//        know.add(v);
//        Set<Integer> edges = gr.get(v);
//        if (edges == null) return;
//
//        for (Integer vertex : edges) {
//            dfs(gr, know, used, vertex);
//        }
//    }

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Map<Integer, Map<Integer, Set<Integer>>> gr = new HashMap<>();
        int maxTime = Integer.MIN_VALUE;
        Set<Integer> timeSet = new HashSet<>();
        int minTime = Integer.MAX_VALUE;
        for (int[] m : meetings) {
            gr.computeIfAbsent(m[2], k -> new HashMap<>());
            gr.get(m[2]).computeIfAbsent(m[0], k -> new HashSet<>()).add(m[1]);
            gr.get(m[2]).computeIfAbsent(m[1], k -> new HashSet<>()).add(m[0]);
            maxTime = Math.max(maxTime, m[2]);
            timeSet.add(m[2]);

            if (m[0] == firstPerson || m[1] == firstPerson || m[0] == 0 || m[1] == 0) {
                minTime = Math.min(m[2], minTime);
            }
        }
        List<Integer> defaultAnswer = List.of(0, firstPerson);
        List<Integer> time = new ArrayList<>(timeSet);
        if (!time.contains(minTime)) return defaultAnswer;
        Collections.sort(time);
        Set<Integer> know = new HashSet<>(defaultAnswer);

        for (int i = time.indexOf(minTime); i < time.size(); i++) {
            Map<Integer, Set<Integer>> cur = gr.get(time.get(i));
            boolean[] used = new boolean[n];

            Set<Integer> from = new HashSet<>();
            for (Map.Entry<Integer, Set<Integer>> entry : cur.entrySet()) {
                for (Integer p : entry.getValue()) {
                    if (know.contains(p)) {
                        from.add(p);
                        from.add(entry.getKey());
                    }
                }
            }
            for (Integer v : from) {
                dfs(cur, know, used, v);
            }
        }
        return new ArrayList<>(know);
    }

    private void dfs(Map<Integer, Set<Integer>> gr, Set<Integer> know, boolean[] used, Integer v) {
        if (used[v]) return;
        used[v] = true;

        know.add(v);
        Set<Integer> edges = gr.get(v);
        if (edges == null) return;

        for (Integer vertex : edges) {
            dfs(gr, know, used, vertex);
        }
    }

    public static void main(String[] args) {
        int n1 = 6;
        int[][] meetings1 = {{1, 2, 5}, {2, 3, 8}, {1, 5, 10}};
        int firstPerson1 = 1;


//        int n = 200;
//        int firstPerson = 1;
//        int[][] meetings = {
//                {199,73,600},{198,135,609},{198,97,618},{198,66,627},{196,154,636},{195,15,645},
//                {194,177,654},{194,168,663},{194,149,672},{194,43,681},{193,173,690},{193,76,699},
//                {191,147,708},{190,185,717},{190,105,726},{190,0,735},{189,140,744},{189,105,753},
//                {188,76,762},{187,167,771},{187,18,780},{186,157,789},{186,64,798},{185,172,807},
//                {185,26,816},{185,16,825},{184,64,834},{183,120,843},{183,46,852},{182,169,861},
//                {182,13,870},{181,51,879},{179,170,888},{179,134,897},{178,158,906},{177,162,915},
//                {177,118,924},{177,22,933},{176,126,942},{175,70,951},{174,145,960},{174,56,969},
//                {174,47,978},{174,11,987},{173,167,996},{173,113,1005},{173,48,1014},{173,31,1023},
//                {172,132,1032},{172,97,1041},{168,104,1050},{166,106,1059},{165,150,1068},{165,95,1077},
//                {164,48,1086},{163,39,1095},{163,33,1104},{163,32,1113},{161,153,1122},{161,129,1131},
//                {160,138,1140},{160,64,1149},{158,3,1158},{157,137,1167},{157,67,1176},{156,92,1185},
//                {155,148,1194},{155,130,1203},{155,118,1212},{155,37,1221},{155,4,1230},{154,79,1239},
//                {154,8,1248},{153,150,1257},{153,109,1266},{153,24,1275},{152,29,1284},{151,142,1293},
//                {151,133,1302},{151,83,1311},{150,75,1320},{149,90,1329},{148,118,1338},{148,89,1347},
//                {147,41,1356},{146,77,1365},{146,9,1374},{145,139,1383},{145,71,1392},{145,15,1401},
//                {144,49,1410},{143,62,1419},{142,79,1428},{142,18,1437},{140,134,1446},{140,126,1455},
//                {139,104,1464},{139,90,1473},{139,69,1482},{138,85,1491},{138,37,1500},{137,124,1509},
//                {137,75,1518},{136,27,1527},{135,42,1536},{134,119,1545},{134,31,1554},{133,42,1563},
//                {133,40,1572},{131,53,1581},{129,128,1590},{129,14,1599},{128,92,1608},{128,85,1617},
//                {128,81,1626},{128,76,1635},{128,42,1644},{127,34,1653},{126,96,1662},{126,79,1671},
//                {126,62,1680},{121,94,1689},{121,31,1698},{120,78,1707},{120,21,1716},{120,10,1725},
//                {120,2,1734},{119,81,1743},{118,69,1752},{118,57,1761},{117,94,1770},{116,54,1779},
//                {116,31,1788},{116,12,1797},{114,14,1806},{113,80,1815},{112,48,1824},{111,93,1833},
//                {111,76,1842},{111,65,1851},{111,4,1860},{110,24,1869},{108,102,1878},{107,58,1887},
//                {106,78,1896},{106,50,1905},{106,18,1914},{105,46,1923},{105,0,1932},{104,66,1941},
//                {104,1,1950},{103,97,1959},{95,30,1968},{93,89,1977},{93,55,1986},{92,71,1995},
//                {92,7,2004},{90,74,2013},{89,46,2022},{89,31,2031},{85,56,2040},{85,7,2049},{85,2,2058},
//                {82,74,2067},{81,63,2076},{79,37,2085},{76,10,2094},{74,5,2103},{73,69,2112},{72,42,2121},
//                {71,64,2130},{71,43,2139},{71,13,2148},{70,48,2157},{70,37,2166},{70,34,2175},{70,31,2184},
//                {68,46,2193},{66,59,2202},{66,56,2211},{65,33,2220},{64,45,2229},{64,33,2238},{59,45,2247},
//                {56,45,2256},{56,37,2265},{53,51,2274},{51,11,2283},{49,41,2292},{47,38,2301},{44,30,2310},
//                {42,11,2319},{35,14,2328},{32,30,2337},{32,13,2346},{31,7,2355},{24,23,2364},{24,4,2373},
//                {22,20,2382},{17,1,2391}
//        };
        int n = 10010;
        int[][] meetings = {
                {2, 1, 1}, {3, 2, 1}, {4, 3, 1}, {5, 4, 1}, {6, 5, 1}, {7, 6, 1}, {8, 7, 1}, {9, 8, 1}, {10, 9, 1}, {11, 10, 1}, {12, 11, 1}, {13, 12, 1}, {14, 13, 1}, {15, 14, 1}, {16, 15, 1}, {17, 16, 1}, {18, 17, 1}, {19, 18, 1}, {20, 19, 1}, {21, 20, 1}, {22, 21, 1}, {23, 22, 1}, {24, 23, 1}, {25, 24, 1}, {26, 25, 1}, {27, 26, 1}, {28, 27, 1}, {29, 28, 1}, {30, 29, 1}, {31, 30, 1}, {32, 31, 1}, {33, 32, 1}, {34, 33, 1}, {35, 34, 1}, {36, 35, 1}, {37, 36, 1}, {38, 37, 1}, {39, 38, 1}, {40, 39, 1}, {41, 40, 1}, {42, 41, 1}, {43, 42, 1}, {44, 43, 1}, {45, 44, 1}, {46, 45, 1}, {47, 46, 1}, {48, 47, 1}, {49, 48, 1}, {50, 49, 1}, {51, 50, 1}, {52, 51, 1}, {53, 52, 1}, {54, 53, 1}, {55, 54, 1}, {56, 55, 1}, {57, 56, 1}, {58, 57, 1}, {59, 58, 1}, {60, 59, 1}, {61, 60, 1}, {62, 61, 1}, {63, 62, 1}, {64, 63, 1}, {65, 64, 1}, {66, 65, 1}, {67, 66, 1}, {68, 67, 1}, {69, 68, 1}, {70, 69, 1}, {71, 70, 1}, {72, 71, 1}, {73, 72, 1}, {74, 73, 1}, {75, 74, 1}, {76, 75, 1}, {77, 76, 1}, {78, 77, 1}, {79, 78, 1}, {80, 79, 1}, {81, 80, 1}, {82, 81, 1}, {83, 82, 1}, {84, 83, 1}, {85, 84, 1}, {86, 85, 1}, {87, 86, 1}, {88, 87, 1}, {89, 88, 1}, {90, 89, 1}, {91, 90, 1}, {92, 91, 1}, {93, 92, 1}, {94, 93, 1}, {95, 94, 1}, {96, 95, 1}, {97, 96, 1}, {98, 97, 1}, {99, 98, 1}, {100, 99, 1}, {101, 100, 1}, {102, 101, 1}, {103, 102, 1}, {104, 103, 1}, {105, 104, 1}, {106, 105, 1}, {107, 106, 1}, {108, 107, 1}, {109, 108, 1}, {110, 109, 1}, {111, 110, 1}, {112, 111, 1}, {113, 112, 1}, {114, 113, 1}, {115, 114, 1}, {116, 115, 1}, {117, 116, 1}, {118, 117, 1}, {119, 118, 1}, {120, 119, 1}, {121, 120, 1}, {122, 121, 1}, {123, 122, 1}, {124, 123, 1}, {125, 124, 1}, {126, 125, 1}, {127, 126, 1}, {128, 127, 1}, {129, 128, 1}, {130, 129, 1}, {131, 130, 1}, {132, 131, 1}, {133, 132, 1}, {134, 133, 1}, {135, 134, 1}, {136, 135, 1}, {137, 136, 1}, {138, 137, 1}, {139, 138, 1}, {140, 139, 1}, {141, 140, 1}, {142, 141, 1}, {143, 142, 1}, {144, 143, 1}, {145, 144, 1}, {146, 145, 1}, {147, 146, 1}, {148, 147, 1}, {149, 148, 1}, {150, 149, 1}, {151, 150, 1}, {152, 151, 1}, {153, 152, 1}, {154, 153, 1}, {155, 154, 1}, {156, 155, 1}, {157, 156, 1}, {158, 157, 1}, {159, 158, 1}, {160, 159, 1}, {161, 160, 1}, {162, 161, 1}, {163, 162, 1}, {164, 163, 1}, {165, 164, 1}, {166, 165, 1}, {167, 166, 1}, {168, 167, 1}, {169, 168, 1}, {170, 169, 1}, {171, 170, 1}, {172, 171, 1}, {173, 172, 1}, {174, 173, 1}, {175, 174, 1}, {176, 175}};
        int firstPerson = 10000;

        var sol = new _2092_Find_All_People_With_Secret();
        sol.findAllPeople(n, meetings, firstPerson);
    }
}
