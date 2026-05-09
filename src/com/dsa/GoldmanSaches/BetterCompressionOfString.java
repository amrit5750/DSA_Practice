package com.dsa.GoldmanSaches;

import java.util.Map;
import java.util.TreeMap;

public class BetterCompressionOfString {

	public static void main(String[] args) {

		String s = "d4a3c2a2c5";

		System.out.println(CompressString(s));

	}

	public static String CompressString(String s) {

	    Map<Character, Integer> map = new TreeMap<>();
	    for (int i = 0; i < s.length(); i += 2) {
	        char ch = s.charAt(i);
	        int count = s.charAt(i + 1) - '0';

	        map.put(ch, map.getOrDefault(ch, 0) + count);
	    }

	    StringBuilder result = new StringBuilder();

	    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
	        result.append(entry.getKey());
	        result.append(entry.getValue());
	    }

	    return result.toString();
	}

}
