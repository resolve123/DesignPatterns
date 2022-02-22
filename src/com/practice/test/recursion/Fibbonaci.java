package com.practice.test.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Fibbonaci {


    public int getFibonaci(int num){
        if(num==0)
            return 0;
        if(num==1)
            return 1;
       return  getFibonaci(num-1)+ getFibonaci(num-2);
    }

    public int getFibonaciIter(int num){
        int result =0;
        int first=0;
                int sec=1;
        if(num==0) {
            result = first;
        }if(num==1){
            result = sec;
        }
        for(int i=2;i<=num;i++){
         result = first+sec;
         first=sec;
         sec=result;
        }
        return result;
    }


    public int getFibonaciFibonaciMem(int num, List list){
        if(num==0)
            return 0;
        if(num==1)
            return 1;
        if(list.contains(num)){
            return num;
        }
        int result=  getFibonaci(num-1)+ getFibonaci(num-2);
        list.add(result);
        return result;
    }

    public static void main(String s[]){
        Fibbonaci fib = new Fibbonaci();
        System.out.println(fib.getFibonaci(9));
        System.out.println(fib.getFibonaciFibonaciMem(9,new ArrayList()));
    }
}
