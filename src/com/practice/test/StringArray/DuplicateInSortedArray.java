package com.practice.test.StringArray;

public class DuplicateInSortedArray {
    public static int removeDuplicates(int[] nums) {
        if(nums.length<=1)
            return nums.length;
        int []temp = new int[nums.length];
        int j=0;
        for(int i=1;i< nums.length;i++){

            if(nums[i-1]!= nums[i]){
                temp[j++]= nums[i-1];
                //System.out.println("---"+j);
            }

        }
        temp[j]=nums[nums.length-1];

        for(int k=0;k<=j;k++){
            nums[k]=temp[k];
        }
        return j+1;
    }

    public static void main(String s[]){
        int [] nums = {1,1,2,3,3,4,5,6,7,7} ;

        int  k = removeDuplicates(nums)  ;

        for (int i = 0; i < k; i++) {
            System.out.println(nums[i]);
        }
    }
}
