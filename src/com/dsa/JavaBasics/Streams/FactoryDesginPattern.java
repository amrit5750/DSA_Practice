package com.dsa.JavaBasics.Streams;

public class FactoryDesginPattern {

    public static Notification creNotification(String type) {
        if (type.equals("EMAIL")) {
            return new EMailNotification();
        } else if (type.equals("SMS")) {
            return new SMSNotification();
        }
        throw new IllegalArgumentException(type);

    }
}

class client {

    public static void main(String[] args) {

        Notification n1 = FactoryDesginPattern.creNotification("EMAIL");
        n1.nofifyUser();

    }
}

class EMailNotification implements Notification {
    public void nofifyUser() {
        System.out.println("EMAIL");
    }

}

class SMSNotification implements Notification {
    public void nofifyUser() {
        System.out.println("SMS");
    }

}

class Factory {

}

interface Notification {
    void nofifyUser();
}

class Singleton {

    private Singleton() {

    }

    private static class singletonHelper {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return singletonHelper.INSTANCE;

    }

}
