package LeetCode;

public class LeetCodeTest {

    public static void main(String args[]){
        int[] nums = {1,1,1};
        int result = subarraySum(nums,2);
        System.out.println("result = "+result);
    }
    // to calculate total number of continuous sumarrays which equal to a sum.
    public static int subarraySum(int[] nums, int k) {
        int result =0;
        int length = nums.length;
        int[] sumArray = new int[length];
        int tsum = 0;
        for(int i=0;i<length;i++){
            tsum += nums[i];
            sumArray[i]=tsum;
        }
        for(int i=0;i<length;i++){
            System.out.println("arr "+i+" = "+sumArray[i]);
        }

        for(int i=0;i<length;i++){
            for(int j=i;j<length;j++){
                int sum = sumArray[j];
                if(i-1>=0) {
                   sum = sum - sumArray[i-1];
                }
                if(sum==k){
                    result++;
                }
            }
        }
        return result;
    }
}
