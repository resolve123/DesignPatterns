package com.practice.test.StringArray;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BigSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int start=0;
        int end=0;
        int j=0;
        int count=0;
        int lastCount=0;
        List<String> l = new ArrayList<>();

        for(int i=1; i<= s.length();i++){

            if(l.contains(s.substring(i-1,i))){

                if(lastCount< count){
                    lastCount=count;
                    start=j;
                    end=i-1;
                }
                j++;
                l.clear();
                i=j;
                count=0;

            }else{
                l.add(s.substring(i-1,i));
                count+=1;
            }
        }

        if(count> lastCount){
            return s.length()-j;
        }else {
            return end-start;
        }
    }

    public static void main(String s[]){
      System.out.println(lengthOfLongestSubstring("abcabcbb"));
        Queue<Character> queue = new LinkedList<>();
       
    }
}
