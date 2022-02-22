package com.practice.test.StringArray;

public class StringPermutation {
    public static void getPermutation(String s, String prefix){
        boolean alpha[] = new boolean[26];
        if(s.length()==0) {
            System.out.println(prefix);
            return ;
        }
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
           if(alpha[ch-'a']==false)
               getPermutation(s.substring(0,i)+s.substring(i+1),prefix+ch);
            alpha[ch - 'a'] = true;
        }
    }

    public static void main(String s[]){
        getPermutation("cab","");
    }
}
