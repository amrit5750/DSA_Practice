package com.dsa.JavaBasics.Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsPractice {

        public static void main(String[] args) {

                List<String> str = Arrays.asList("apple", "bananna");
                int largestlength = str.stream().mapToInt(String::length).max().orElse(0);
                System.out.println(largestlength);

                List<Integer> integers = Arrays.asList(3, 8, 15, 10, 12, 35);
                Optional<Integer> res = integers.stream().sorted((a, b) -> b.compareTo(a)).skip(1).findFirst();
                res.ifPresent(System.out::println);
                Set<Integer> oddSet = integers.stream().filter(ele -> ele % 2 == 1).collect(Collectors.toSet());
                System.out.println(oddSet);

                boolean allOdd = integers.stream().allMatch(ele -> ele % 2 == 1);
                System.out.println(allOdd);

                integers.stream().mapToDouble(Integer::intValue).average().orElse(0);

                Optional<Integer> secondSmallest = integers.stream().sorted().skip(1).findFirst();
                secondSmallest.ifPresent(System.out::println);

                str.stream().filter(ele -> {
                        StringBuilder item = new StringBuilder(ele);
                        item.reverse();
                        return ele.equals(item.toString());
                }).collect(Collectors.toList());
                List<Integer> ls = Stream.iterate(new int[] { 0, 1 }, f -> new int[] { f[1], f[0] + f[1] }).limit(10)
                                .map(f -> f[0])
                                .collect(Collectors.toList());

                String string = "Saurbh";
                Optional<Object> ch = Arrays.stream(string.split(""))
                                .collect(Collectors.groupingBy(ele -> ele, Collectors.counting()))
                                .entrySet().stream().filter(ele -> ele.getValue() == 1).findFirst()
                                .map(ele -> ele.getKey());

                Optional<Integer> maxProduct = integers.stream().flatMap(i -> integers.stream()
                                .filter(j -> !(i.equals(j))).map(j -> j * i))
                                .max(Integer::compareTo);

                List<Integer> list = Arrays.asList(1, 2, 3, 5, 6, 1);
                List<Integer> subList = Arrays.asList(1, 2, 3);

                Set<Integer> set = new HashSet<>(list);
                boolean ans = subList.stream().allMatch(ele -> set.contains(ele));
                System.out.println(ans);

                int target = 7;
                int closeValue = list.stream()
                                .min((a, b) -> Integer.compare(Math.abs(a - target), Math.abs(b - target)))
                                .orElse(0);

                System.out.println(closeValue);

                str.stream().max((a, b) -> Integer.compare(a.length(), b.length())).orElse("");
                str.stream().flatMapToInt(String::chars).filter(ch1 -> "AEIOUaeiou".indexOf(ch1) != -1).count();
                Set<Character> vowels = Set.of('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u');

                long count = str.stream()
                                .flatMapToInt(String::chars)
                                .filter(ch3 -> vowels.contains((char) ch3))
                                .count();
                String shortest = str.stream().min((a, b) -> Integer.compare(a.length(), b.length())).get();
                System.out.println(shortest);
                Integer number = list.stream()
                                .collect(Collectors.groupingBy(ele -> ele, LinkedHashMap::new, Collectors.counting()))
                                .entrySet()
                                .stream().filter(entry -> entry.getValue() > 1).map(entry -> entry.getKey()).findFirst()
                                .get();
                List<String> sortedByLastElement = str.stream()
                                .sorted(Comparator.comparingInt(word -> word.charAt(word.length() - 1)))
                                .collect(Collectors.toList());

                List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
                List<Integer> list2 = Arrays.asList(3, 4, 5, 6, 7);
                List<Integer> difference = list1.stream().filter(ele -> !list2.contains(ele))
                                .collect(Collectors.toList());
                List<String> reversedList = str.stream().map(ele -> new StringBuilder(ele).reverse().toString())
                                .collect(Collectors.toList());

                System.out.println(reversedList);
                String concat = str.stream().collect(Collectors.joining(" "));
                System.out.println(concat);
                List<Character> distictChars = concat.chars().mapToObj(c -> (char) c).filter(c -> c != ' ').distinct()
                                .collect(Collectors.toList());
                System.out.println(distictChars);
                // String longestPalindrome = str.stream().filter(ele -> new
                // StringBuilder(ele).reverse().equals(ele))
                // .max(Comparator.comparing(String::length)).get();

                list.stream().map(ele -> fact(ele)).collect(Collectors.toList());

                Double ans32 = str.stream().mapToDouble(ele -> ele.length()).average().getAsDouble();

                list.stream().collect(Collectors.groupingBy(ele -> ele, Collectors.counting()))
                                .entrySet().stream().sorted(Map.Entry.comparingByValue())
                                .findFirst().map(entry -> entry.getValue());

                String seed = "bvdhjbvjfk134323";
                seed = seed.replaceAll("^[0-9]", "");
                System.out.println(seed.length());
                long re = seed.chars().filter(Character::isDigit).count();

                List<String> ls1 = Arrays.asList("a", "b", "c");
                List<String> ls2 = Arrays.asList("1", "2", "3");

                Iterator<String> it = ls2.iterator();

                Map<String, String> map = ls1.stream()
                                .collect(Collectors.toMap(k -> k, v -> it.next()));

                Map<Integer, List<String>> newMap = ls2.stream().collect(Collectors.groupingBy(ele -> ele.length()));

        }

        public static Integer fact(int n) {
                if (n == 0) {
                        return 1;

                }
                return n * fact(n - 1);
        }

}
