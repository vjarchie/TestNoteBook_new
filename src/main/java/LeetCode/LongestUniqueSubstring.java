package LeetCode;

import java.util.*;

public class LongestUniqueSubstring {

    public static void main(String args[]) {
        List<String> inputs = new ArrayList<>();
        inputs.add("abcabcabc");
        inputs.add("bbb");
        inputs.add("pewweks");
        inputs.add("b");
        inputs.add("dvdf");
        for (String str : inputs) {
            System.out.println(" ip: " + str + " max:" + lengthOfLongestSubstring(str));
        }

    }

    public static int lengthOfLongestSubstring(String s) {
//        Map<Character,Integer> characters = new HashMap<>();
//        char[] str = s.toCharArray();
//        int max = 0;
//        int curmax = 0;
//        int si=0;
//        for (int i = 0; i < s.length(); i++) {
//            curmax += 1;
//            if (characters.containsKey(str[i])) {
//                int ki = characters.get(str[i]);
//                if(ki>=si) {
//                    while(si<=ki){
//                        characters.remove(str[si++]);
//                    }
//                    curmax = i-si+1;
//                }
//            }
//            characters.put(str[i],i);
//            if (curmax > max) {
//                max = curmax;
//            }
//        }
//        return max;
        char[] chars = s.toCharArray();
        if (chars.length <= 1) return chars.length;
        int result = 1;

        int start = 0;
        // loop at each step forward
        for (int end = 1; end < chars.length; end++) {
            for (int i = start; i < end; i++) {
                if (chars[i] == chars[end]) {
                    start = i + 1;
                    break;
                }
            }
            result = Math.max(result, end - start + 1);
        }

        return result;
//        int ans =0;
//        if(s!=null && s.length()>0){
//            Map<Character, Integer> map = new HashMap<>();
//
//            int j=0, i=0;
//            while(i<s.length() && j<s.length()){
//                if(!map.containsKey(s.charAt(i))){
//                    map.put(s.charAt(i),i);
//                    ans = Math.max(ans, i-j+1);
//                    i++;
//                }else{
//                    map.remove(s.charAt(j));
//                    j++;
//                }
//
//            }
//
//        }
//        return ans;
    }
}
