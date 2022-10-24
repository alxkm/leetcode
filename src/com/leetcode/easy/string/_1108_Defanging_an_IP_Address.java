package com.leetcode.easy.string;

public class _1108_Defanging_an_IP_Address {
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}
