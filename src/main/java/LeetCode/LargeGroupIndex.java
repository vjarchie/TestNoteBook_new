package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


/**
 * Additional : check if extended words can relate to any dictionary word
 */
public class LargeGroupIndex {

    public static void main(String args[]) {
        String input = "heeello";
        List<List<Integer>> result = largeGroupPositions(input);
        for (List<Integer> sub : result) {
            for (Integer i : sub) {
                System.out.print(i + " ");
            }
            System.out.println(" ");
        }

    }

    public List<String> possibleWords(List<List<Integer>> repeats, String str) {
        List<String> results = new ArrayList<>();
        int i = 0;
//        if(!repeats.isEmpty()){
//            // Needs recursion!!!!
//            for(List<Integer> sub:repeats){
//                int s = sub.get(0);
//                int e = sub.get(1);
//                char c = str.charAt(s);
//                if(s-1 >= 0) {
//                    StringBuffer stringBuffer = new StringBuffer();
//                    stringBuffer.append(str.substring(i,))
//                }
//            }
//
//        }else {
//            results.add(str);
//        }
        return results;
    }

    public void possibleWordsUtil(List<List<Integer>> repeats, String str, HashSet<String> results) {
//TODO : not yet completed
        if (!repeats.isEmpty()) {
            for (List<Integer> sub : repeats) {
                int s = sub.get(0);
                int e = sub.get(1)+1;
                char c = str.charAt(s);
                String target = str.substring(s,e);
                List<String> repChars = Arrays.asList(String.valueOf(c),String.valueOf(new char[]{c,c}));
                StringBuffer stringBuffer = new StringBuffer(str);

                for(String sp:repChars){
                    String temp = str.replaceAll(target,sp);
                    results.add(temp);

                }
            }

        } else {
            results.add(str);
        }
    }

    public static List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> results = new ArrayList<>();
        Integer slimit = 2;
//        Character curr = null;
        int len = s.length();
        int start = 0;
        char[] chars = s.toCharArray();
        if (s != null) {
            for (int i = 0; i < len; ++i) {
                if (i == len - 1 || chars[i] != chars[i + 1]) {
                    if ((i - start + 1) > slimit) {
                        List<Integer> sub = new ArrayList<>(Arrays.asList(start, i));
                        results.add(sub);
                    }
                    start = i + 1;
                }
            }
        }

        return results;

    }

    public static List<List<Integer>> largeGroupPositionsOptimized(String S) {
        List<List<Integer>> ans = new ArrayList<>();
        char[] chars = S.toCharArray();
        int i = 0, j = 0;
        while (j < chars.length) {
            if (chars[i] != chars[j]) {
                if (j - i >= 3) {
                    ans.add(Arrays.asList(i, j - 1));
                }
                i = j;
            }
            j++;
        }
        if (j - i >= 3) {
            ans.add(Arrays.asList(i, j - 1));
        }
        return ans;
    }

//    public List<List<Integer>> largeGroupPositions(String S) {
//        List<List<Integer>> ans = new ArrayList();
//        int i = 0, N = S.length(); // i is the start of each group
//        for (int j = 0; j < N; ++j) {
//            if (j == N-1 || S.charAt(j) != S.charAt(j+1)) {
//                // Here, [i, j] represents a group.
//                if (j-i+1 >= 3)
//                    ans.add(Arrays.asList(new Integer[]{i, j}));
//                i = j + 1;
//            }
//        }
//
//        return ans;
//    }
}
