package com.company.list;

public class Main {
    public static void main(String[] args) {

        ListNode listNode = new ListNode();

        test(listNode, ListNode.class);

	// write your code here
    }

    public static void test(Object list, Class clazz) {

        System.out.println(list.getClass());
        System.out.println(clazz);
    }
}
