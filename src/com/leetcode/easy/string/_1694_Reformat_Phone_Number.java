package com.company.string;

public class _1694_Reformat_Phone_Number {
    static public String reformatNumber(String number) {
        number = number.replaceAll(" ", "");
        number = number.replaceAll("-", "");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < number.length(); i++) {
            if (number.length() - 4 == i) { // 4 left
                var a = number.substring(number.length() - 4);
                sb.append(a.charAt(0))
                  .append(a.charAt(1))
                  .append("-")
                  .append(a.charAt(2))
                  .append(a.charAt(3));
                i = number.length();
            } else if (number.length() - 3 == i) { // 3 left
                sb.append(number.substring(number.length() - 3));
                i = number.length();
            } else if (number.length() - 2 == i) { // 3 left
                sb.append(number.substring(number.length() - 2));
                i = number.length();
            } else {
                sb.append(number, i, i + 3).append("-");
                i += 2;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reformatNumber("123 4-5678"));
    }
}
