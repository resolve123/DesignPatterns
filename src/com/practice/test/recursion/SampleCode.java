package com.practice.test.recursion;

public class SampleCode {

    public int testRecusrion(int n){
        if(n==0)
            return 0;
       return  testRecusrion(n-1)+1;
    }

    public static void main (String s[]){
        System.out.println(new SampleCode().testRecusrion(5));
    }
}
