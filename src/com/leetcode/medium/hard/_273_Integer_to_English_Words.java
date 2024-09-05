package com.leetcode.medium.hard;

public class _273_Integer_to_English_Words {
    //273. Integer to English Words
    //https://leetcode.com/problems/integer-to-english-words/description/
    //not own

    private static final String[] LESS_THAN_20 = {
            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    private static final String[] TENS = {
            "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    private static final String[] THOUSANDS = {
            "", "Thousand", "Million", "Billion"
    };

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        if (num < 20) return LESS_THAN_20[num];

        StringBuilder sb = new StringBuilder();

        int pos = 0;
        while (num > 0) {
            int s = num % 1000;
            int tho = s / 100;
            s %= 100;
            int tens = s / 10;
            s %= 10;
            int less = s;
            String str = "";
            if (tho > 0) {
                str += LESS_THAN_20[tho] + " Hundred";
            }
            if (tens > 0) {
                if (str != "") str += " ";
                str += TENS[tens];
            }
            if (less > 0) {
                if (str != "") str += " ";
                str += LESS_THAN_20[less];
            }
            if (str != "") {
                str += " ";
                str += THOUSANDS[pos];
            }
            num /= 1000;
            str = str.trim();
            sb.insert(0, str);
            pos++;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        var sol = new _273_Integer_to_English_Words();
        //System.out.println(sol.numberToWords(123));
        System.out.println(sol.numberToWords(12345));
    }
}
