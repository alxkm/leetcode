package com.leetcode.easy.string;

import java.util.HashSet;
import java.util.Set;

public class _1805_Number_of_Different_Integers_in_a_String {
    static public int numDifferentIntegers(String word) {
        Set<String> s = new HashSet<>();

        for (int i = 0; i < word.length(); i++) {
            StringBuilder sb = new StringBuilder();
            while (i < word.length() && Character.isDigit(word.charAt(i))) {
                sb.append(word.charAt(i++));
            }
            if (!sb.toString().equals("")) {
                int j = 0;
                if (sb.length() != 1) {
                    while (j < sb.length() && sb.charAt(j) == '0') j++;
                }
                if (j == sb.length()) {
                    s.add("0");
                } else {
                    s.add(sb.substring(j));
                }
            }
        }
        return s.size();
    }

    public static void main(String[] args) {
        String a1b01c001 = "a1b01c001";
        String b = "xtimt5kqkz9osexe56ezwwninlyeeqsq5m99904os3ygs12t31n1et4uwzmt5kvv6teisobuxt10k33v1aaxysg4y8nsivxdp3fo9dr7x58m8uc4ofm41ai77u8cvzr5r3s97f5otns59ubqk57xwl00xsp9w2oodt6yxcbscloyr9c2su8gca1ly6rrjufm25luhxhesxwn7bk1as9na4cbabxk";
        String word = "0a0";
        String word1 = "0i00e";
        System.out.println(numDifferentIntegers(word1));
        String a =         "2393706880236110407059624696967828762752651982730115221690437821508229419410771541532394006597463715513741725852432559057224478815116557380260390432211227579663571046845842281704281749571110076974264971989893607137140456254346955633455446057823738757323149856858154529105301197388177242583658641529908583934918768953462557716z97438020429952944646288084173334701047574188936201324845149110176716130267041674438237608038734431519439828191344238609567530399189316846359766256507371240530620697102864238792350289978450509162697068948604722646739174590530336510475061521094503850598453536706982695212493902968251702853203929616930291257062173c79487281900662343830648295410";
    }
}
