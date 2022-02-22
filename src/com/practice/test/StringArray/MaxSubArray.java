package com.practice.test.StringArray;

public class MaxSubArray {
    public static  int maxSubArray(int[] nums) {
        if(nums.length==1)
            return nums[0];
        int max=nums[0];
        int sum=nums[0];

        for(int i=1;i<nums.length;i++){
            sum+=nums[i];
            if(nums[i]> sum){
                sum=nums[i];
            }
            if(sum>max){
                max=sum;

            }

        }

        return max;
    }


    public static void main(String s[]){
        int []array = new int[]{-5,-10};

        System.out.println(maxSubArray(array));
    }
}
