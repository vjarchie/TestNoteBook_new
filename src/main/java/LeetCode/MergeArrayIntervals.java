package LeetCode;

import java.util.*;

public class MergeArrayIntervals {

    public static void main(String args[]){
        int[] ip1= new int[]{1,2,2,4};
        int[] ip2= new int[]{2,2};
        int[] res = intersect(ip1,ip2);
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+ " ");
        }
    }

    public static int[] intersect(int[] nums1,int[] nums2){
        Map<Integer,Integer> hmap1 = new HashMap<>();
        Map<Integer,Integer> hmap2 = new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            if(hmap1.containsKey(nums1[i])){
                hmap1.put(nums1[i],hmap1.get(nums1[i])+1);
            }else {
                hmap1.put(nums1[i],1);
            }
        }
        for(int i=0;i<nums2.length;i++){
            if(hmap2.containsKey(nums2[i])){
                hmap2.put(nums2[i],hmap2.get(nums2[i])+1);
            }else {
                hmap2.put(nums2[i],1);
            }
        }
        List<Integer> result = new ArrayList<>();
        for(Integer key:hmap1.keySet()){
            if(hmap2.containsKey(key)){
                int times = Math.min(hmap1.get(key),hmap2.get(key));
                for(int t=0;t<times;t++){
                    result.add(key);
                }
            }
        }
        return result.stream().mapToInt(i->i).toArray();
    }

}
