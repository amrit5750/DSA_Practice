package com.dsa.JavaBasics.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamFourtySixToSixtyTwo {

    public static void main(String[] args) {

        // problem 46
        List<String> names = Arrays.asList("Apple", "Banana", "Amla", "Berries");

        Map<String, Long> map = names.stream().filter(ele -> ele.startsWith("A"))
                .collect(Collectors.groupingBy(ele -> ele, Collectors.counting()));

        System.out.println(map);

        // problem 47
        Stream<Integer> infiniteStream = Stream.iterate(1, x -> x + 1).limit(10);

        infiniteStream.forEach(ele -> System.out.println(ele));

        List<Person> persons = new ArrayList<>();

        Map<Object, Double> map2 = persons.stream()
                .collect(Collectors.groupingBy(ele -> ele.gender, Collectors.averagingInt(ele -> ele.age)));
        System.out.println(map2);

        // problem 52
        names.stream().map(ele -> {
            int length = ele.length();
            if (length % 2 != 0) {
                return String.valueOf(ele.charAt(length / 2)); // Odd length: single middle character
            } else {
                return String.valueOf(ele.charAt(length / 2 - 1)) + ele.charAt(length / 2); // Even length: two middle
                                                                                            // characters
            }
        }).collect(Collectors.toList());

        List<Integer> ls = Arrays.asList(12, 34, 11, 54, 121, 5645);

        ls.stream().collect(Collectors.groupingBy(ele -> ele, Collectors.counting())).entrySet().stream()
                .filter(entry -> entry.getValue() > 1).map(entry -> entry.getKey()).collect(Collectors.toList());

        ls.stream().distinct().filter(ele -> String.valueOf(ele).startsWith("1"))
                .sorted((a, b) -> b - a).collect(Collectors.toList()).forEach(ele -> System.out.println(ele));

        // Problem 51

        persons.stream().sorted(Comparator.comparing(Person::getFirstName).thenComparing(Person::getLastName))
                .collect(Collectors.toList());

        String s = "bbyebyebyte";
        String check = "bye";
        long ans = IntStream.range(0, s.length() - 2).filter(x -> s.substring(x, x + 3).equals(check)).count();
        System.out.println(ans);

    }

}

class Person {

    String firstName;
    String lastName;
    int age;
    String email;
    String gender;

    public Person(String firstName, String lastName, int age, String email, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.gender = gender;

    }

    // Getter and Setter for firstName
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter and Setter for lastName
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getter and Setter for age
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Getter and Setter for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and Setter for gender
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null || getClass() != this.getClass()) {
            return false;
        }

        Person person = (Person) obj;
        return age == person.age &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(email, person.email) &&
                Objects.equals(gender, person.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, age, email, gender);
    }

}
