package com.practice.test.recursion;

public class SampleCode {

    public void testRecusrion(int n){
        if(n==0)
            return ;
         testRecusrion(n-1);
       System.out.println(n);
    }

    public static void main (String s[]){
       new SampleCode().testRecusrion(5);
    }
}
