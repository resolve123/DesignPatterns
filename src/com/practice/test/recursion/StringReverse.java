package com.practice.test.recursion;

import java.util.Arrays;

public class StringReverse {

   public String reverse(String s){
       if (s.length()==0 || s.length()==1)
           return s;
      // return (new String(reverseString(s.toCharArray(),0,s.length()-1)));
       return (new String(reverseString1(s.toCharArray(),0,s.length()-1)));
   }

   private char[] reverseString(char[] charArray,int start, int end){
       if(start >= end)
           return charArray;
       char temp= charArray[start];
       charArray[start]=charArray[end];
       charArray[end]=temp;
      return  reverseString(charArray,start+1,end-1);
   }

    /**
     * solution iterative
     * @param charArray
     * @param start
     * @param end
     * @return
     */

    private char[] reverseString1(char[] charArray,int start, int end){
      while(start < end) {
          char temp = charArray[start];
          charArray[start] = charArray[end];
          charArray[end] = temp;
          start=start + 1;
          end=end - 1;
      }
      return charArray;
    }
   public static void main(String s[]){
     System.out.println(new  StringReverse().reverse("amit"));
   }
}
