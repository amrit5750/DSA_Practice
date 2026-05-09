package com.dsa.JavaBasics.POC;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Transient {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        User user = new User("alex", "123");

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("user.ser"));
        out.writeObject(user);
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("user.ser"));
        try {
            User user1 = (User) in.readObject();
            in.close();

            System.out.println(user1.name);
            System.out.println(user1.password);
        } catch (ClassNotFoundException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

class User implements Serializable {

    String name;
    transient String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

}
