package com.practice.test.sorting;

import java.util.Arrays;

public class SortingSelectionBubbleInsertion {

    public int[] bubbleSort(int [] array){
      int temp;
        for(int i=0; i<array.length;i++){
            for(int j=1;j<array.length;j++){
                if(array[j-1]> array[j]){
                    temp= array[j-1];
                    array[j-1]=array[j];
                    array[j]=temp;
                }
            }
        }
return array;
    }

    public int [] selectionSort(int [] array){
        int temp;
        int index;
        for(int i=0; i<array.length;i++){
            int lowestIndex=i;
            for(int j=i;j<array.length-1;j++){
                if(array[lowestIndex]>array[j+1]){
                    lowestIndex=j+1;

                }
            }
             temp= array[i];
                    array[i]=array[lowestIndex];
                    array[lowestIndex]=temp;
        }
return array;
    }

    /**
     * it is better when array/data is almost sort
     * @param array
     * @return
     */
    public int[] insertionSort(int[] array){
        for(int i =1; i< array.length;i++){
            int key = array[i];
            int j= i-1;
            while(j>=0 && array[j]> key){
            array[j+1]=array[j];
                j=j-1;
                }
               array[j+1] =key;
            }
        return array;
        }



    public static void main(String s[]){
        int[] array =new int[]{10,7,2,15};
        int[] array1 =new int[]{11,6,1,14,2};

        int[] array2 =new int[]{13,8,4,14,2};

       // Arrays.sort(array);
        Arrays.stream(new SortingSelectionBubbleInsertion().bubbleSort(array)).forEach(x->System.out.println(x));

        Arrays.stream(new SortingSelectionBubbleInsertion().selectionSort(array1)).forEach(x->System.out.println(x));
        Arrays.stream(new SortingSelectionBubbleInsertion().insertionSort(array2)).forEach(x->System.out.println(x));
    }
}
