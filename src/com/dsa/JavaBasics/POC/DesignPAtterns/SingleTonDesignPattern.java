package com.dsa.JavaBasics.POC.DesignPAtterns;

public class SingleTonDesignPattern {

    public static void main(String[] args) {

        SingleTon x = SingleTon.getInstace();
        SingleTon y = SingleTon.getInstace();
        SingleTon z = SingleTon.getInstace();

        System.out.println(x.hashCode());
        System.out.println(y.hashCode());
        System.out.println(z.hashCode());

    }

}

class SingleTon {
    String s;

    public static SingleTon instance;

    private SingleTon() {
        s = "Amriot";
    }

    public static synchronized SingleTon getInstace() {

        if (instance == null) {
            instance = new SingleTon();
        }
        return instance;
    }

}
