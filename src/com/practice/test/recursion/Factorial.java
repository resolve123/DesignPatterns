package com.practice.test.recursion;

public class Factorial {
    int result =1;

    public  int recursiveFctorial(int num){

        if(num ==2){
            return 2;
        }

       return  num * recursiveFctorial(--num);

    }


    public static void main(String s[]){

        Factorial fac= new Factorial();
        System.out.println(fac.recursiveFctorial(5));
    }
}
