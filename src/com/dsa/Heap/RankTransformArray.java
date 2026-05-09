package com.dsa.Heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//time complexity O(nlogn) and space complexity O(n)
// we will first create a copy of the input array and sort it and then we will create
// a map to store the rank of each element in the sorted array and then we will iterate through the input array and for each element we will get its rank from the map and store it in the result array and return the result array
// for example if we have the input array as [37, 12, 28, 9, 100, 56, 80, 5, 12] then we will first create a copy of the input array and sort it which will be [5, 9, 12, 12, 28, 37, 56, 80, 100] then we will create a map to store the rank of each element in the sorted array which will be {5=1, 9=2, 12=3, 28=4, 37=5, 56=6, 80=7, 100=8} then we will iterate through the input array and for each element we will get its rank from the map and store it in the result array which will be [5=1, 9=2, 12=3, 28=4, 37=5, 56=6, 80=7, 100=8] and return the result array which will be [5=1, 9=2, 12=3, 28=4, 37=5, 56=6, 80=7, 100=8]
// the time complexity of this approach is O(nlogn) because we are sorting the copy of the input array which takes O(nlogn) time and the space complexity of this approach is O(n) because we are creating a copy of the input array and a map to store the rank of each element in the sorted array which takes O(n) space
public class RankTransformArray {

    public static void main(String[] args) {

        int[] arr = { 37, 12, 28, 9, 100, 56, 80, 5, 12 };

        System.out.println(Arrays.toString(arrayRankTransform(arr)));

    }

    public static int[] arrayRankTransform(int[] arr) {

        int[] res = new int[arr.length];
        int[] arrCopy = arr.clone();
        Arrays.sort(arrCopy);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arrCopy.length; i++) {

            if (!map.containsKey(arrCopy[i])) {
                map.put(arrCopy[i], map.size() + 1);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            res[i] = map.get(arr[i]);
        }
        return res;
    }

}
