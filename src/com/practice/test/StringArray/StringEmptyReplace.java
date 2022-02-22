package com.practice.test.StringArray;

public class StringEmptyReplace {
    public static void main(String s[]){
        String str ="Amit sharma is";
        int spaceCount =0;


        char[] characters=str.toCharArray();
       for (int i =0;i< str.length();i++){
           if(characters[i]==' '){
               spaceCount +=1;
           }
       }
        char[] dummyArray = new char[str.length()+spaceCount*3-1];
        for (int i=0,j =0;i< str.length();i++){
            if(characters[i]==' '){

                dummyArray[j+2]='0';
                dummyArray[j+1]='2';
                dummyArray[j]='%';
                j=j+3;

            }else{
                dummyArray[j]=characters[i];
                j++;
            }
        }

        System.out.println(dummyArray);
        System.out.println(dummyArray.length);
    }
}
