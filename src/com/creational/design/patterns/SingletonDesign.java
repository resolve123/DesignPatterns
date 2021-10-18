package com.creational.design.patterns;

/**
 * Singleton pattern is used for logging, drivers objects, caching and thread pool.
 * Singleton design pattern is also used in other design patterns like Abstract Factory, Builder, Prototype, Facade etc.
 * Singleton design pattern is used in core java classes also, for example java.lang.Runtime, java.awt.Desktop.
 */
public class SingletonDesign {

    private static volatile SingletonDesign  instance = null;

    private SingletonDesign(){
        // This will avoid creating instance using reflection
if(instance != null){
    throw new RuntimeException("Use getSingletonInstance");
}

    }
public static SingletonDesign getSingletonInstance (){
        if(instance == null){
            synchronized (SingletonDesign.class){
                if(instance == null){
                    return new SingletonDesign();
                }
            }
        }
    return instance;
}

    /**
     * This is another approach where you can create singleton using inner static class
     * it is also lazy approach
     *
     * Notice the private inner static class that contains the instance of the singleton class. When the singleton class is loaded,
     * InnerSingleton class is not loaded into memory and
     * only when someone calls the getSingletonInstanceInnerClass method, this class gets loaded and creates the Singleton class instance.
     */


    public static class InnerSingleton{
        private static final SingletonDesign singletonInstance = new SingletonDesign();
    }

    public static SingletonDesign getSingletonInstanceInnerClass (){

        return InnerSingleton.singletonInstance;
    }

}
