package com.practice.test.StringArray;

public class StringUniqueCharacter {


    public static  void worst(String s){
        String tempString ="Amit Shar";
        char []temp1= tempString.toLowerCase().toCharArray();
        for (int i=0; i<temp1.length;i++){
            for (int j=i+1; j<temp1.length;j++){
                if(temp1[i]==temp1[j]){
                    System.out.println(false);
                    return;
                }
            }

            if(i==temp1.length-1){
                System.out.println(true);
            }
        }
    }

    /**
     *
     * @param s
     * @return
     */
    public static boolean Best(String s){
        int checker =0;
        for (int i=0; i<s.length()-1;i++){
            int position = s.charAt(i) -'a';// position of character corresponding to a 96 so b it will be 97-96=1
            // clear all bit except position(00000001)
          if((checker & (1 << position))>0) return false;// bitwise operator to shift 1 to no of positions
            // set bit in checker
            checker= checker |(1 << position);
        }
        return true;
    }


    public static void main(String s[]){
   System.out.println( Best("cbcdc"));
    }
}
