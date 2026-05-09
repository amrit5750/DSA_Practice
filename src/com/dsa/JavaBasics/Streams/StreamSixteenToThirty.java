package com.dsa.JavaBasics.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamSixteenToThirty {

        public static void main(String[] args) {

                // Problem 16
                String[] strs = { "pat", "tap", "pan", "nap", "Team", "tree", "meat" };

                List<List<String>> ans = new ArrayList<>(

                                Arrays.asList(strs).stream()
                                                .collect(Collectors.groupingBy(x -> Arrays.stream(x.split(""))

                                                                .sorted()
                                                                .collect(Collectors.joining())))
                                                .values());

                System.out.println(ans);

                // Problem 17

                int[] arr = { 4, 5, 1, 7, 0, 2, 9, 2, 0, 0, 0, 0 };

                // Mutilply even indexes
                int product = IntStream.range(0, arr.length).filter(x -> x % 2 == 0)
                                .map(ele -> arr[ele])
                                .reduce(1, (a, b) -> a * b);
                System.out.println(product);

                // Problem 18
                IntStream.range(0, arr.length / 2).map(x -> arr[x] * arr[arr.length - x - 1])
                                .forEach(ele -> System.out.println(ele));

                // problem 19

                List<Integer> mixZeroOnes = Arrays.stream(arr).boxed().collect(Collectors.toList());

                List<Integer> zeros = mixZeroOnes.stream().filter(ele -> ele == 0).collect(Collectors.toList());
                List<Integer> Nonzeros = mixZeroOnes.stream().filter(ele -> ele != 0).collect(Collectors.toList());
                List<Integer> finalList = new ArrayList<>();
                finalList.addAll(zeros);
                finalList.addAll(Nonzeros);

                System.out.println(finalList);

                // Problem 20

                Map<Integer, Long> map = Arrays.stream(arr).boxed().collect(Collectors.toList()).stream()
                                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

                Collection<Long> View = map.values();

                boolean isDistict =

                                View.stream().noneMatch(x -> x > 1);
                System.out.println(isDistict);

                // anotherWayOut
                isDistict = Arrays.asList(arr).stream().distinct().count() == arr.length;

                // problem 21

                String[] groupByMiddle = { "ewe", "jji", "jhi", "kwk", "aha" };

                Map<Object, List<String>> ls = Stream.of(groupByMiddle)
                                .collect(Collectors.groupingBy(s -> s.toString()
                                                .substring(1, 2)));

                System.out.println(ls);

                // problem 22
                int sum = Arrays.stream(arr).sum();
                System.out.println(sum);
                // Arrays.asList(arr).stream().mapToInt(Integer::intValue).sum();

                // problem 23
                List<String> sortedList = Stream.of(groupByMiddle).sorted().collect(Collectors.toList());
                System.out.println(sortedList);

                // probem 24

                List<Integer> squares = Arrays.stream(arr).map(ele -> ele * ele).boxed()
                                .collect(Collectors.toList());
                System.out.println(squares);

                // probem 25

                List<Integer> distictOdd = Arrays.stream(arr).filter(ele -> ele % 2 == 1).boxed().distinct()
                                .collect(Collectors.toList());

                System.out.println(distictOdd);

                // Problem 26
                List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6);
                List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5, 6);
                List<Integer> union = Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toList());
                System.out.println(union);

                // problem 27

                int k = 3;
                int res = list1.stream().sorted().skip(k - 1).findFirst().get();
                System.out.println(res);

                // problem 28
                List<String> NonnumericString = Arrays.asList("c1b23", "1a2fr43", "123");
                List<String> numericString = NonnumericString.stream().map(ch -> ch.replaceAll("[^0-9]", ""))
                                .collect(Collectors.toList());
                System.out.println(numericString);

                // problem 29
                List<String> onlyDigits = NonnumericString.stream().filter(x -> x.matches("[0-9]+"))
                                .collect(Collectors.toList());
                System.out.println(onlyDigits);

                // problem 30
                List<String> uppercase = NonnumericString.stream().map(ele -> ele.toUpperCase())
                                .collect(Collectors.toList());
                System.out.println(uppercase);

        }

}
