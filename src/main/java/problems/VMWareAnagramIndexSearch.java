package problems;

import java.util.*;

public class VMWareAnagramIndexSearch {


    public static void main(String[] args) {
        String s1 = "ababcba";
        String s2 = "ab";
        List<Integer> resIntegers = findAnagrams(s1, s2);
        for (Integer i : resIntegers) {
            System.out.println(i);
        }
    }

    private static List<Integer> findAnagrams(String s1, String s2) {
        List<Integer> results = new ArrayList<>();
        Set<Character> keySet = new HashSet<>();
        for (Character c : s2.toCharArray()) {
            keySet.add(c);
        }

        int s1Length = s1.length();
        int s2Length = s2.length();
        // System.out.println( "s1 len " + s1Length + "s2 len " + s2Length );

        Integer t = s1Length - s2Length+1;
        System.out.println("iter"+t);
        for (int i = 0; i < t; i++) {
            if (keySet.contains(s1.charAt(i))) {
                Integer p = i + s2Length;
                System.out.println(" index i: "+i +" p: "+ p);
                if (p > s1Length)
                    return results;

                if (isAnagram(s2, s1.substring(i, p))) {

                    System.out.println("adding " + i + " string "+ s1.substring(i, p));
                    results.add(i);
                }
            }
        }
        return results;
    }


    public static boolean isAnagram(String s1, String s2) {
        // edge cases
        System.out.println("S1 " + s1 + "S2" + s2);
        Map<Character, Integer> charCount = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            Character key = s1.charAt(i);
            if (charCount.containsKey(key)) {
                charCount.put(key, charCount.get(key) + 1);
            } else {
                charCount.put(key, 1);
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            Character key = s2.charAt(i);
            if (charCount.containsKey(key)) {
                charCount.put(key, charCount.get(key) - 1);
            } else {
                return false;
            }
        }

        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() != 0)
                return false;
        }

        return true;

    }
}
