package com.practice.test.StringArray;

public class AddBinaryNumber {

    public static String addBinary(String a, String b) {
        String temp ="";
        int carryForward =0;

        int length = a.length()> b.length()-1 ? a.length(): b.length();
        int j= a.length()-1< b.length()-1 ? a.length()-1: b.length()-1;
        for (int i = length-1;i>=0 ;i--){
            int firstString = 0;
            int secString =0;
            if(a.length()== length){
                firstString = a.charAt(i)-'0';
            }
            else if(j>=0){

                    firstString = a.charAt(j--)-'0';
            }

            if(b.length()== length){
                secString = b.charAt(i)-'0';
            }
            else{
                if(j>=0)
                    secString = b.charAt(j--)-'0';
            }

System.out.println(i+"------>"+firstString +""+secString);
            if(firstString+secString ==2){
                if(carryForward==0){
                    temp = 0+temp;
                    carryForward =1;
                }else if(carryForward==1){
                    temp =1+temp;
                    carryForward =1;
                }

            }else if (firstString+secString ==1){
                if(carryForward==0){
                    temp = 1+temp;
                }
                else {
                    temp = 0+temp;
                    carryForward =1;
                }
            }
            else{
                if(carryForward==0) {
                    temp= 0+temp;
                }
                else {
                    temp = 1 + temp;
                    carryForward=0;
                }
            }
        }
        if(carryForward != 0)
            return 1+temp;
        else  return temp;
    }



    public static void main(String s[]){
        System.out.println(addBinary("100", "110010"));
    }
}
