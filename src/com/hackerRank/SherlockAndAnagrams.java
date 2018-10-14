package com.hackerRank;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SherlockAndAnagrams {
	
	private static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
       
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            System.out.println("Shelock Anagrams: " + sherlockAnagrams(s));
            
        }

        scanner.close();
    }
	
	
	static int sherlockAnagrams(String str){
		Map<String, Integer> keyCount = new HashMap<String, Integer>();
		for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
            		String key = generateKey(str.substring(i, j));
            		if (!keyCount.containsKey(key)) {
                        keyCount.put(key, 0);
                }
                keyCount.put(key, keyCount.get(key) + 1);
            }
         }
		return keyCount.values().stream().mapToInt(count -> count * (count - 1) / 2).sum();
	}
	
	static String generateKey(String str) {
        return str.chars().sorted().mapToObj(letter -> String.valueOf((char) letter)).collect(Collectors.joining());
    }
}
