package com.creational.design.patterns;

public class SingletonDesignDemo {


    public static void main(String s[]){
        SingletonDesign instance = SingletonDesign.getSingletonInstance();
        SingletonDesign instance1 = SingletonDesign.getSingletonInstance();
        System.out.println(instance);
        System.out.println(instance1);

        //inner class approach
        SingletonDesign1 instance2 = SingletonDesign1.getSingletonInstanceInnerClass();

    }
}
