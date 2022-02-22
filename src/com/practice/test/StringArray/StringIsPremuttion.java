package com.practice.test.StringArray;

public class StringIsPremuttion {

    public static boolean compare(String s1, String s2){
        int []character= new int[25];

        for( int i=0;i< s1.length();i++){
            int charIndex =Character.getNumericValue(s1.charAt(i));
            System.out.println(s1.charAt(i)- (int)'a');
        }

        return true;
    }

    public static void main(String s[]){
        compare("amitzA","");
    }
}
