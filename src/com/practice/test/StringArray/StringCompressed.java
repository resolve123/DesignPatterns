package com.practice.test.StringArray;

public class StringCompressed {

    public static String getCompressedString(String s){
        int count=1;
       boolean isSameLength=true;
        String latest="";
        for (int i=1; i<s.length();i++){

            if(s.charAt(i)==s.charAt(i-1)){
                count +=1;
                if(count >2) isSameLength=false;
            }else{
                latest= latest+s.toCharArray()[i-1]+count;

                if(count >2) isSameLength=false;
                count=1;
            }
        }
        latest=latest+s.toCharArray()[(s.length()-1)]+count;
    /*   if(isSameLength){
           return s;}else{ latest=latest+s.toCharArray()[(s.length()-1)]+count;
       return latest;*/
       return s.length()<=latest.length() ?s:latest;
       }


    public static void main(String s[]){
        System.out.println(getCompressedString("aacccbbccc"));
    }
}
