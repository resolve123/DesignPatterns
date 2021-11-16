package com.creational.design.patterns;

/**
 * client will pass factory as input parameter and based on type of factory it will return type of item
 *
 * This pattern is used when The system consists of multiple families of objects, and these families are designed to be used together. Like computer ,animal,colors
 *
 * Factory pattern is used when we have just one family of objects while abstarct is used when we have multiple families of objects
 */
public class AbstractFactoryDesignPattern {

    public static void main(String s[]){
    AbstractFactory<Animal> provide = FactoryProvider.getFactory("Animal");
        AbstractFactory<Computer1> provide1 = FactoryProvider.getFactory("Computer");
    }

}

/**
 * Super class for product like PC and Server
 */
abstract class Computer1 {

    public abstract String getRAM();
    public abstract String getHDD();
    public abstract String getCPU();

    @Override
    public String toString(){
        return "RAM= "+this.getRAM()+", HDD="+this.getHDD()+", CPU="+this.getCPU();
    }
}

class PC1 extends Computer1 {

    private String ram;
    private String hdd;
    private String cpu;

    public PC1(String ram, String hdd, String cpu){
        this.ram=ram;
        this.hdd=hdd;
        this.cpu=cpu;
    }
    @Override
    public String getRAM() {
        return this.ram;
    }

    @Override
    public String getHDD() {
        return this.hdd;
    }

    @Override
    public String getCPU() {
        return this.cpu;
    }

}

 class Server1 extends Computer1 {

    private String ram;
    private String hdd;
    private String cpu;

    @Override
    public String getRAM() {
        return this.ram;
    }

    @Override
    public String getHDD() {
        return this.hdd;
    }

    @Override
    public String getCPU() {
        return this.cpu;
    }

     public Server1(String ram, String hdd, String cpu){
         this.ram=ram;
         this.hdd=hdd;
         this.cpu=cpu;
     }

}

/**
 * Interface for Factories
 * Notice that createComputer() method is returning an instance of super class Computer.
 * Now our factory classes will implement this interface and return their respective sub-class
 */
 interface AbstractFactory<T> {

    public T create(String objectType);

}


class ComputerFactory implements AbstractFactory<Computer1> {



    public ComputerFactory(){

    }
    @Override
    public Computer1 create(String objectType) {

        if("PC".equalsIgnoreCase(objectType))
        return new PC1("512","hdd","dual");
        else return new Server1("512","hdd","dual");
    }

}



//======================================Another family of objects================

 interface Animal {
    String getAnimal();
    String makeSound();
}

 class Duck implements Animal {

    @Override
    public String getAnimal() {
        return "Duck";
    }

    @Override
    public String makeSound() {
        return "Squeks";
    }
}


class Dog implements Animal {

    @Override
    public String getAnimal() {
        return "Dog";
    }

    @Override
    public String makeSound() {
        return "Dog";
    }
}

//==============Another factory=================

class AnimalFactory implements  AbstractFactory<Animal> {
     @Override
     public  Animal create(String animalType){
         if("Duck".equalsIgnoreCase(animalType)) return new Duck();
         else return new Dog();
     }
}


 class FactoryProvider {
    public static AbstractFactory getFactory(String choice){

        if("Animal".equalsIgnoreCase(choice)){
            return new AnimalFactory();
        }
        else if("Computer".equalsIgnoreCase(choice)){
            return new ComputerFactory();
        }

        return null;
    }
}





