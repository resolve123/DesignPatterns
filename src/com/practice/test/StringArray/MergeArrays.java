package com.practice.test.StringArray;

public class MergeArrays {
    public static int[] merge(int[] array1, int[]array2){
        if((array1 == null || array1.length==0) && (array2 == null || array2.length==0)){
            return new int []{};
        }else if((array1 == null || array1.length==0) && (array2 != null || array2.length>0)){
            return array2;
        }else if((array2 == null || array2.length==0) && (array1 != null || array1.length>0)){
            return array1;
        }
  int [] mergerArray= new int[array1.length+array2.length];
        int i=0,j=0,k=0;
      while(i< array1.length && j<array2.length){

          if(array1[i]>array2[j]){
              mergerArray[k++]=array2[j++];

          }else{
              mergerArray[k++]=array1[i++];

          }

      }
      // if array1 is bigger than array2
      while(i< array1.length){
          mergerArray[k++]=array1[i++];
      }
      //if array2 bigger than array2
        while(j< array2.length){
            mergerArray[k++]=array2[j++];
        }
        for(int l=0;l< mergerArray.length;l++)
            System.out.println(mergerArray[l]);
        return mergerArray;
    }

    public static void main(String s[]){
   int array1[]= new int[]{0,3,4,31};
        int array2[]= new int[]{4,6,30};

        merge(array1,array2);
    }
}
