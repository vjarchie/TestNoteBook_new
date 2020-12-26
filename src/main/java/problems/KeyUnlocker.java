package problems;

/**
 Given are two strings, both of length N. The characters are digits ranging from “1” to “9”. The first string is the current state of a bike's combination lock and the other describes the needed combination for opening the lock.

 Please write a function returning the smallest number of turns needed, until the bicycle lock becomes open.
 */
import java.util.*;

public class KeyUnlocker {

    public static void main(String[] args) {
        // please feel free to change anything you want and come up
        // with your own structure and test calls
        testCases();

    }

    public static int mininumDiff(String s1,String s2){

        int len = s1.length();
        int minRotate = 0;
        for(int i=0;i<len;i++){
            minRotate +=  calculate(s1.charAt(i)-'0',s2.charAt(i)-'0');
        }
        return minRotate;
    }

    public static int calculate(Integer i1,Integer i2){

        int diff = Integer.MIN_VALUE;
        if(i2 <i1)
        {
            Integer temp = i2;
            i2 = i1;
            i1 = temp;
        }
        System.out.println(" i1= "+i1+" i2="+i2);
        if(i1<6 && i2>=6) {
            diff =  Math.min(Math.abs(i1 - i2), Math.abs(i1 + 9 - i2));
        }else {
            diff = Math.abs(i1 - i2);
        }
        System.out.println( " diff= "+ diff);
        return diff;

    }

    public static void testCases(){
        List<String> sources = Arrays.asList("12345","12345");
        List<String> dests = Arrays.asList("12345","67899");
        List<Integer> results = Arrays.asList(0,20);


        for(int i=0;i<sources.size();i++){
            int result = mininumDiff(sources.get(i),dests.get(i));
            System.out.println("result = "+result);
            if(result==results.get(i)){
                System.out.println("test passed");

            }else{
                System.out.println("test failed");
            }
        }


    }
}