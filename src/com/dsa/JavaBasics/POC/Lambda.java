package com.dsa.JavaBasics.POC;

public class Lambda {

    public static void main(String[] args) {

        Add add = (a, b) -> a + b;
        int res = add.addiiton(1, 22);
        System.out.println(res);

    }

}

/**
 * Add
 */
interface Add {
    int addiiton(int a, int b);
}
