package com.leetcode.easy.string;

public class _1678_Goal_Parser_Interpretation {
    static public String interpret(String command) {
        StringBuilder sb = new StringBuilder();

        while(!command.equals("")) {
            if (command.startsWith("G")) {
                sb.append("G");
                command = command.substring(1);
            } else if (command.startsWith("()")) {
                sb.append("o");
                command = command.substring(2);
            } else if (command.startsWith("(al)")) {
                sb.append("al");
                command = command.substring(4);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(interpret("G()()()()(al)"));
    }
}
