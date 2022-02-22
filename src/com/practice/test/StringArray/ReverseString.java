package com.practice.test.StringArray;

public class ReverseString {

    public static String reverse(String str){
        if(str.length()==0)
            return str;
       char[] c = str.toCharArray();
       int i=0;
       int j=c.length-1;
       char temp;
       while(i<j){
         temp= c[j] ;
         c[j]=c[i];
         c[i]=temp;
         i++;
         j--;
       }
       return new String(c);
    }

    public static void main(String s[]){
        System.out.println(reverse("hi my name is Andrei"));
    }
}
