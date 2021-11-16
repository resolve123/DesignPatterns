package com.structural.design.patterns;

/**
 * The implementation of bridge design pattern follows the notion to prefer Composition over inheritance.
 * example Shape and color interfaces and both have different implementaion. Shape contains color so bridge pattern provide color object to shape.
 * When to use Bridge Pattern ------------------
 *1.  When we want a parent abstract class to define the set of basic rules, and the concrete classes to add additional rules
 * 2. When we have an abstract class that has a reference to the objects, and it has abstract methods that will be defined in each of the concrete classes
 */
public class BridgePattern {
    public static void main(String[] args) {
        Shape2 tri = new Triangle2(new RedColor());
        tri.applyColor();

        Shape2 pent = new Pentagon2(new GreenColor());
        pent.applyColor();
    }

}

interface Color {

    public void applyColor();
}

/**
 * Shape2 class which consists a reference (bridge) to the Color object:
 */
abstract class Shape2 {
    //Composition - implementor
    protected Color color;

    //constructor with implementor as input argument
    public Shape2(Color c){
        this.color=c;
    }

    abstract public void applyColor();
}

class Triangle2 extends Shape2{

    public Triangle2(Color c) {
        super(c);
    }

    @Override
    public void applyColor() {
        System.out.print("Triangle filled with color ");
        color.applyColor();
    }

}

class Pentagon2 extends Shape2{

    public Pentagon2(Color c) {
        super(c);
    }

    @Override
    public void applyColor() {
        System.out.print("Pentagon filled with color ");
        color.applyColor();
    }

}

class RedColor implements Color{

    public void applyColor(){
        System.out.println("red.");
    }
}

class GreenColor implements Color{

    public void applyColor(){
        System.out.println("green.");
    }
}
