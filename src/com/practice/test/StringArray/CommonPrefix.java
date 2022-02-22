package com.practice.test.StringArray;

public class CommonPrefix {

    public static String getPrefix(String s[]){
        int len= s.length;
        String prefix=s[0];
        for(int i=1; i<s.length;i++){
            while(s[i].indexOf(prefix)!= 0){
                prefix= prefix.substring(0,prefix.length()-i);
                if (prefix.isEmpty()) return "";
            }

        }
        return prefix;
    }
    public static void main(String s[]) {
        String str[] = new String[]{"amit", "amie", "amite"};
System.out.println(getPrefix(str));

      System.out.println( "Amit".substring(0,"Amit".length()-1));
    }

}
