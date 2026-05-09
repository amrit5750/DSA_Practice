package com.dsa.Heap;

import java.util.TreeMap;

//time complexity O(nlogn) and space complexity O(n)
// we will use a TreeMap to store the frequency of each card in the hand and we will iterate through the TreeMap and for each card we will check if we can form a group of consecutive cards of size groupSize starting from that card and if we can form a group then we will decrease the frequency of those cards in the TreeMap and if we can not form a group then we will return false and if we can form groups for all the cards then we will return true
// for example if we have the hand as [1, 2, 3, 6, 2, 3, 4, 7, 8] and groupSize as 3 then we will first count the frequency of each card in the TreeMap which will be {1=1, 2=2, 3=2, 4=1, 6=1, 7=1, 8=1} then we will iterate through the TreeMap and for the first card which is 1 we will check if we can form a group of consecutive cards of size groupSize starting from that card which is [1, 2, 3] and we can form that group so we will decrease the frequency of those cards in the TreeMap which will be {1=0, 2=1, 3=1, 4=1, 6=1, 7=1, 8=1} then we will move to the next card which is 2 and we will check if we can form a group of consecutive cards of size groupSize starting from that card which is [2, 3, 4] and we can form that group so we will decrease the frequency of those cards in the TreeMap which will be {1=0, 2=0, 3=0, 4=0, 6=1, 7=1, 8=1} then we will move to the next card which is 3 and we will check if we can form a group of consecutive cards of size groupSize starting from that card which is [3, 4, 5] and we can not form that group because there is no card with value 5 in the TreeMap so we will return false but if we had a card with value 5 in the TreeMap then we would have decreased the frequency of those cards in the TreeMap and moved to the next card until we have checked all the cards in the TreeMap and if we have checked all the cards in the TreeMap then we would have returned true
// the time complexity of this approach is O(nlogn) because we are using a TreeMap to store the frequency of each card in the hand and we are iterating through the TreeMap which takes O(nlogn) time and the space complexity of this approach is O(n) because we are using a TreeMap to store the frequency of each card in the hand which takes O(n) space
// the space complexity of this approach is O(n) because we are using a TreeMap to store the frequency of each card in the hand which takes O(n) space
public class HandofStraights {
    public static void main(String[] args) {

        int[] hand = { 1, 2, 3, 6, 2, 3, 4, 7, 8 };
        int groupSize = 3;

        System.out.println(isNStraightHand(hand, groupSize));

    }

    public static boolean isNStraightHand(int[] hand, int groupSize) {

        if (hand.length % groupSize != 0)
            return false;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < hand.length; i++) {
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }
        while (!map.isEmpty()) {
            int first = map.firstKey();

            for (int i = 0; i < groupSize; i++) {
                int key = first + i;
                if (!map.containsKey(key)) {
                    return false;
                }
                map.put(key, map.get(key) - 1);
                if (map.get(key) == 0) {
                    map.remove(key);
                }
            }
        }
        return true;
    }

}
