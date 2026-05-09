package com.dsa.dailyDigest;

//time complexity is O(n) and space complexity is O(n)
// ../we will use the concept of diagonal to find the different binary string
// we will iterate through the array of binary strings and for each string we will check the character at the diagonal position and we will flip it and add it to the result string
// for example if we have the array of binary strings as ["01", "10"] then we will check the character at the diagonal position which is 0 for the first string and 1 for the second string and we will flip it and add it to the result string which will be "11" in this case
// we will return the result string as the different binary string
public class FindDifferentBinaryString {

    public static void main(String[] args) {

        String[] nums = { "01", "10" };

        System.out.println(findDifferentBinaryString(nums));

    }

    public static String findDifferentBinaryString(String[] nums) {

        char[] result = new char[nums.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = nums[i].charAt(i) == '0' ? '1' : '0';
        }

        return new String(result);

    }

}
