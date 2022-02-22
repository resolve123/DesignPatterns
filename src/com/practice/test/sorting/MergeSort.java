package com.practice.test.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeSort {
    public static void sort(int [] array , int n){
        if (n<2)
            return ;
        int mid = n/2;



        int left [] = new int[mid];
        int right [] = new int[n-mid];

        for (int i=0;i< mid;i++){
            left[i]= array[i];
        }

        for (int j=0;j< n-mid;j++){
        right[j]=array[mid+j];
        }
        System.out.println("left :");
        Arrays.stream(left).forEach(x->System.out.println(x));
        sort(left,mid);
        System.out.println("right :"+right);
        Arrays.stream(right).forEach(x->System.out.println(x));
        sort(right,n-mid);

        sortMerge(array,left,right,mid, n-mid);
    }

    private static void sortMerge(int [] array ,int[] l, int[] r, int left, int right){
        int i=0,j=0,k=0;
        while( i< left && j< right ){
            if(l[i]<= r[j]){
               array[k++] =l[i++];
            }else if (l[i]> r[j]){
                array[k++]=r[j++];
            }

        }
        /**
         * copy remain as it is without sort
         */
        while (i < left) {
            array[k++] = l[i++];
        }
        while (j < right) {
            array[k++] = r[j++];
        }

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=0;
        int j=0;

        while(i < nums1.length && j< nums2.length){

            if(nums1[i]<nums2[j]){
                i++;
            }else{
                int temp = nums1[i];
                nums1[i]=nums2[j];
                nums2[j]=temp;
                j++;
            }
        }



        int firstLength=nums1.length;
        int secLength = nums2.length;
        int totalLength=firstLength+secLength;
        int half = totalLength/2;
        double result =0.0d;
        if(totalLength % 2==0){


            if(firstLength > half){

                result= (nums1[half-1]+nums1[half])/2;
                return result;

            }else if(firstLength < half){


                result =(nums2[(secLength-firstLength)]+nums2[(secLength-firstLength)+1])/2;
                return result;
            }
            else{
                result= (nums1[(half-1)]+nums2[0])/2;
                return result;
            }
        }else{
            if(firstLength > half){

                return (nums1[half]);

            }else if(firstLength < half){

                result =(nums2[(secLength-firstLength)-1]);
                return result;

            }else{
                result = ((nums1[(half-1)]) +(nums2[0]))/2;
                return result;
            }
        }
    }
    public static void main(String s[]){
        List list = new ArrayList();
        List list1 = new LinkedList();
        int data[]= {5,3,10,1,2};
int[] num1=  new int[]{1,2};
        int[] num2=  new int[]{3,4};

       // findMedianSortedArrays(num1,num2);
        MergeSort.sort(data, data.length);

        //MergeSort.mergeSort(data, data.length);
Arrays.stream(data).forEach(x->  System.out.println(x));
       // System.out.println(data);
    }
}
