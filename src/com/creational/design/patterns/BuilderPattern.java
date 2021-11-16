package com.creational.design.patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * Builder Pattern is use to create immutable object. We create it using inner static class
 * Once object is created you can not modify it
 * This pattern help you to create object with different combination of parameters.Used when some parameters are optional.
 * You need not to create constructor for different parameters combination
 *it provide Immutable
 * Inner static class (you can also use external class also
 * use to avoid complex constructor
 */
public class BuilderPattern {

    public static class Builder {
        //optional param
        private String bread;
        private String dressing;
        private String meat;

        public Builder(){

        }

        public Builder bread(String bread){
            this.bread=bread;
            return this;
        }

        public Builder dressing(String dressing){
            this.dressing=dressing;
            return this;
        }
        public Builder meat(String meat){
            this.meat=meat;
            return this;
        }
        public Builder (String dressing,String meat){
            this.dressing=dressing;
            this.meat=meat;

        }

        public BuilderPattern build(){
          return  new BuilderPattern(this);
        }
    }

    public BuilderPattern(Builder builder){
        this.bread =builder.bread;
        this.dressing = builder.dressing;
        this.meat = builder.meat;
    }

    private String bread;
    private String dressing;
    private String meat;

    public static void main (String s[]){
        //So we are making bread as optional
        BuilderPattern  builderPattern = new BuilderPattern.Builder("Mayo","Wheat").build();
       // builder.bread("Wheat").dressing("Mayo");

        //BuilderPattern order = new BuilderPattern(builder);

     System.out.println(builderPattern.bread);
        System.out.println(builderPattern.dressing);
        StringBuilder builder ;

    }

}
