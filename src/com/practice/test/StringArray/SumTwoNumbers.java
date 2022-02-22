package com.practice.test.StringArray;

import java.util.ArrayList;
import java.util.List;

public class SumTwoNumbers {

    public static void print(int remain){
        print(remain,"");
    }

    public static void print(int remain,String prefix){
        if(remain==0){
            System.out.print(prefix);
        }else{
            for (char c='a';c<='b';c++){
              print(remain-1,prefix+c)  ;
            }
        }
    }


    public static void main(String s[]){
        ArrayList l = new ArrayList();
        l.add("amit");
        l.add("sharma");

        StringBuilder build = new StringBuilder();


System.out.println(  build.capacity());
build.append("amit sharma working1");
        System.out.println(  build.capacity());





    }
}
