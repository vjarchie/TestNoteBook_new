package LeetCode;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args){
        int[] input = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> result = threeSum(input);
        for(List<Integer>  i:result){
            System.out.println(i);
        }
        System.out.printf("Result"+ consequtiveMax(input));


    }

    public static int consequtiveMax(int[] A) {
        // write your code in Java SE 8
        if(A ==null )
            return 0;
        if(A.length <= 1){
            return A.length;
        }
        int max = 0;
        int si=0,ei=0;
        for(int i=1;i<A.length;i++){
            if(Math.abs(A[i]-A[i-1])==1){
                ei+=1;
            }else{
                int tmax = ei-si+1;
                if(tmax>max){
                    max = tmax;
                }
                si= i;
                ei=i;
            }
        }
        Stack<String> res = new Stack<>();
        return max>(ei-si+1)?max:(ei-si+1);

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        // This wont work as losing the track of third index!!
//        Set<Integer> keys = new HashSet<>();
//        for(int i=0;i<nums.length;i++){
//            keys.put();
//        }
//        for(int i=0;i<nums.length;i++){
//            for(int j=i+1;j<nums.length;j++){
//                if(keys.contains(0-(nums[i]+nums[j]))){
//                    List<Integer> res = Arrays.asList(nums[i],nums[j],0-(nums[i]+nums[j]));
//                    result.add(res);
//                }
//            }
//        }
        // --i- shuttle <<j>> -- k---
        // This works but results are not entirely unique
//        for(int i=0;i<nums.length-2;i++){
//            for(int k=i+2;k<nums.length;k++){
//                for(int j=i+1;j<k;j++){
//                    if(nums[i]+nums[j]+nums[k] == 0){
//                        result.add(Arrays.asList(nums[i],nums[j],nums[k]));
//                    }
//                }
//            }
//        }
        for(int i=0;i<nums.length && nums[i] <=0;i++){
            if (i == 0 || nums[i - 1] != nums[i])
                twoSum(nums, i, result);
        }


        return result;
    }

    public static void twoSum(int[] nums,int i,List<List<Integer>> res){
        int lo=i+1, hi=nums.length-1;
        while(lo<hi){
            int sum = nums[lo] + nums[hi] +nums[i];
            if(sum <0 || (lo > i + 1 && nums[lo] == nums[lo - 1]))
                lo++;
            else if(sum>0||(hi<nums.length-1 && nums[hi]==nums[hi+1]))
                hi--;
            else
                res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
        }

    }


}
