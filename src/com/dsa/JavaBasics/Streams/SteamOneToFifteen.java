package com.dsa.JavaBasics.Streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class SteamOneToFifteen {

        public static void main(String[] args) {
                // problem 1
                String s1 = "My name is alex";
                String largestWord = Arrays.asList(s1.split(" ")).stream().max(Comparator.comparing(String::length))
                                .get();
                System.out.println(largestWord);

                // problem 2
                String s2 = "dabcadefg";
                Arrays.stream(s2.split("")).distinct().forEach(System.out::print);
                // s2.chars().distinct().mapToObj(x -> (char) x).forEach(System.out::print);

                // Problem 3
                String secondHighestLen = Arrays.asList(s1.split(" ")).stream()
                                .sorted(Comparator.comparing(String::length).reversed()).skip(0).findFirst().get();
                System.out.println(secondHighestLen);

                // problem 4
                String sentence = "I am learning Stream in java using java";
                Map<String, Long> map = Arrays.asList(sentence.split(" ")).stream()
                                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
                System.out.println(map);

                // problem 5
                List<String> ls = Arrays.asList(sentence.split(" ")).stream()
                                .filter(word -> word.replace("[^aeiouAEIOU]", "").length() == 2)
                                .collect(Collectors.toList());

                System.out.println(ls);

                // problem 6
                int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
                List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

                List<List<Integer>> checkedMap = list.stream()
                                .collect(Collectors.groupingBy(x -> x % 2 == 0, Collectors.toList())).entrySet()
                                .stream()
                                .map(x -> x.getValue()).collect(Collectors.toList());
                System.out.println(checkedMap);

                // problem 7
                Map<String, Long> charMap = Arrays.stream(s2.split(""))
                                .collect(Collectors.groupingBy(ele -> ele, Collectors.counting()));
                System.out.println(charMap);

                // problem 9
                Arrays.stream(arr).mapToObj(x -> x).sorted().forEach(System.out::print);
                Arrays.stream(arr).mapToObj(x -> x).sorted(Collections.reverseOrder()).forEach(System.out::print);

                System.out.println(
                                "#####################################################################################");

                int res = Arrays.stream(arr).distinct().sum();
                System.out.println(res);

                // Problem 11 -> find first non Repeating character
                String hello = "Hello World";
                String ans = Arrays.stream(hello.split("")).filter(c -> hello.indexOf(c) == hello.lastIndexOf(c))
                                .findFirst().get();
                System.out.println(ans);

                char firstNonRepChar =

                                hello.chars().mapToObj(c -> (char) c)
                                                .collect(Collectors.groupingBy(ch -> ch, LinkedHashMap::new,
                                                                Collectors.counting()))
                                                .entrySet().stream().filter(entry -> entry.getValue() == 1)
                                                .map(m -> m.getKey()).findFirst().get();
                System.out.println(firstNonRepChar);

                // Problem 12
                String firstRepeatedChar = Arrays.stream(hello.split(""))
                                .filter(c -> hello.indexOf(c) != hello.lastIndexOf(c)).findFirst().get();

                System.out.println(firstRepeatedChar);

                firstRepeatedChar =

                                Arrays.stream(hello.split(""))
                                                .collect(Collectors.groupingBy(word -> word, LinkedHashMap::new,
                                                                Collectors.counting()))
                                                .entrySet()
                                                .stream().filter(entry -> entry.getValue() > 1).map(m -> m.getKey())
                                                .findFirst().get();

                System.out.println(firstRepeatedChar);

                // Problem 13
                int[] arrList = { 1, 3, 10, 14, 20, 24, 30, 34, 40, 44, 50, 54 };

                Map<Integer, List<Integer>> segMap = Arrays.stream(arrList).boxed().collect(Collectors.toList())
                                .stream()
                                .collect(Collectors.groupingBy(x -> x / 10 * 10, TreeMap::new, Collectors.toList()));
                System.out.println(segMap);

                // Problem 14
                String[] mixDigitsAndChars = { "abc", "123", "45D6", "xyx" };

                List<Integer> onlyNumbers = Arrays.stream(mixDigitsAndChars).filter(ele -> ele.matches("[0-9]+"))
                                .map(ele -> Integer.parseInt(ele)).collect(Collectors.toList());
                System.out.println(onlyNumbers);

                // Problem 15

                int[] firstTwoProduct = { 12, 5, 6, 7, 2, 4 };
                int firstTwoPick = Arrays.stream(firstTwoProduct).limit(2).reduce(1, (a, b) -> a * b);
                System.out.println(firstTwoPick);
        }

}
