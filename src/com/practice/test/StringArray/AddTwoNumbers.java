package com.practice.test.StringArray;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * find 2 number have sum target in array
 */
public class AddTwoNumbers {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        for(int j =0 ;j<nums.length;j++){

            if(map.containsKey(target-nums[j])){
                return new int[]{map.get(target-nums[j]), j};
            }
            map.put(nums[j],j);
        }
        return new int[]{0, 0};
    }

    /**
     * solution 2
     * @param s
     */

    public static int[] twoSum2(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {

            if (nums[i] + nums[j] == target) {
                return new int[]{i, j};
            } else if (nums[i] + nums[j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[]{-1,-1};
    }


    public static void main(String s[]){
        int[] result = twoSum(new int[]{-2,-5,-7},-12);
       System.out.println( result[0]+":"+result[1]);
       //Second solution
        int[] result1 = twoSum2(new int[]{2,5,7},12);
        System.out.println( result1[0]+":"+result1[1]);
    }
}
