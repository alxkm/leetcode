package com.company.string;

public class _1859_Sorting_the_Sentence {
    static     public String sortSentence(String s) {
        String[] a = s.split(" ");
        StringBuilder sb = new StringBuilder();

        int min = 1;
        for (int i = 0; i < a.length; i++) {
            for (String w : a) {
                int index = 0;
                for (int k = 0; k < w.length(); k++) {
                    if (Character.isDigit(w.charAt(k))) {
                        index = k;
                        break;
                    }
                }
                int n = Integer.parseInt(w.substring(index));
                if (n == min) {
                    String s1 = w.substring(0, index);
                    sb.append(s1);
                    min++;
                    break;
                }
            }
            if (i != a.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(sortSentence("is2 sentence4 This1 a3"));
    }
}
