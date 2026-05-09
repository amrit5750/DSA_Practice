package com.dsa;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TopThreeSquare {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 2, 6, null, 8, 8);

        List<Integer> filteredList = list.stream().filter(ele -> ele != null && ele % 2 == 0)
                .distinct().map(ele -> ele * ele)
                .collect(Collectors.toList());

        Collections.sort(filteredList.reversed());

        filteredList.stream().limit(3).forEach(ele -> System.out.println(ele));

    }

}
