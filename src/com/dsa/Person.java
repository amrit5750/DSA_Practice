package com.dsa;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Person implements Serializable {

    private static class Helper {
        private static final Person INSTANCE = new Person();
    }

    public static Person getInstance() {
        return Helper.INSTANCE;
    }

    private static final long serialVersionUID = 1L;

    String name;
    int age;
    String email;

    Person() {

    }

    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (age != other.age)
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + age;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        return result;
    }

    public static void main(String[] args) {
        Person personObj1 = new Person("alex", 23, "alex@gmail.com");
        Person personObj2 = new Person("alex", 23, "alex@gmail.com");

        Map<Person, String> map = new HashMap<>();
        map.put(personObj1, "Record1");
        System.out.println(
                map.get(personObj2));

        personObj2.email = "alex";

    }

}
