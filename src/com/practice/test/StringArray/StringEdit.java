package com.practice.test.StringArray;

public class StringEdit {


    public static boolean compare(String s1,String s2){
        int s1length=s1.length();
        int s2length=s2.length();
int unmatchedCount =0;
int replacemis=0;
        if(s1length==0 &&s2length==0) return true;
        else if(s1length-s2length >2 || s2length-s1length>2) return false;

        for(int i=0 ;i< (s1length< s2length? s1length :s2length);i++){

                if(s1.length()<s2.length() ){
                    if(s1.charAt(i) !=s2.charAt(i) && s1.charAt(i) !=s2.charAt(i+1)) {
                        unmatchedCount += 1;
                    }else if(s1.charAt(i) ==s2.charAt(i+1)) replacemis+=1;
            }else{
                    if( s2.charAt(i) !=s1.charAt(i) && ( i== s2.length()-1 || s2.charAt(i) !=s1.charAt(i+1))) {
                        unmatchedCount += 1;
                    }else if(i!=s2.length()-1 && s2.charAt(i) ==s1.charAt(i+1) && s2length ==s1length) replacemis+=1;
                }
        }
        if(unmatchedCount >1 || (unmatchedCount >0 && replacemis >0 )) return false;
        return true;
    }


    public static void main(String s[]){


     System.out.println(compare("amei","ameei"));



    }
}
