package com.practice.test.StringArray;

public class ExcelIndex {
    public int titleToNumber(String columnTitle) {

       int result =0;

        char [] stringChar = columnTitle.toCharArray();

        if(stringChar.length==1){
           return  getIndex(stringChar[0]);

        }else{
            for(int i=0 ;i< stringChar.length;i++)
                result=  (26 *result + getIndex(stringChar[i]));

        }
        return result;
    }

    private  int getIndex(char c){
        char[] array = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','W','X','Y','Z'};
        for(int i=0 ;i<array.length;i++){
            if(c==array[i]) {
                System.out.println(i+1+": "+i +":"+array[i]);
                return (i + 1);
            }
        }
        return 0;
    }

    public static void main(String s[]){
      System.out.println( new  ExcelIndex().titleToNumber("ZY"));
    }

}
