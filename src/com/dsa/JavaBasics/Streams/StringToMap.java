package com.dsa.JavaBasics.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StringToMap {

    public static void main(String[] args) {

        String text = "hello world hello java world";

        Map<String, Long> freMap =

                Arrays.stream(text.split(" ")).collect(Collectors.groupingBy(word -> word,
                        Collectors.counting()));

        System.out.println(freMap);

        List<Person> persons = new ArrayList<>();

        persons.add(new Person("alex", 20, Arrays.asList("Java", "python", "AWS")));
        persons.add(new Person("adam", 20, Arrays.asList("Java", "Spring", "AWS", null)));

        List<String> topSkills =

                persons.stream().flatMap(p -> p.getSkills().stream()).filter(ele -> ele != null)
                        .map(ele -> ele.toLowerCase())
                        .collect(Collectors.groupingBy(word -> word,
                                Collectors.counting()))
                        .entrySet().stream().sorted((a, b) -> Long.compare(b.getValue(), a.getValue())).limit(3)
                        .map(Map.Entry::getKey).collect(Collectors.toList());

        System.out.println(topSkills);

    }

}

class Person {

    String name;
    int age;
    List<String> skills;

    Person(String name, int age, List<String> skills) {
        this.name = name;
        this.age = age;
        this.skills = skills;

    }

    public List<String> getSkills() {
        return skills;
    }

}
