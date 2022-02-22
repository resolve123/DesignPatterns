package com.design.pattern.behavioral;

/**
 * This pattern provide template method which will be used by subclass as is. Like while building a house there are certain fixed steps
 * need for all type of house .So base class will provide that method.
 *
 * Jdk have below examples
 * All non-abstract methods of java.io.InputStream, java.io.OutputStream, java.io.Reader and java.io.Writer.
 * All non-abstract methods of java.util.AbstractList, java.util.AbstractSet and java.util.AbstractMap
 */
public class TemplateMethodDesignPattern {
    public static void main(String[] args) {

        HouseTemplate houseType = new WoodenHouse();

        //using template method
        houseType.buildHouse();
        System.out.println("************");

        houseType = new GlassHouse();

        houseType.buildHouse();
    }
}

/**
 * buildHouse method is the template method all subclasses will use it as is.
 * Since we want some of the methods to be implemented by subclasses, we have to make our base class as abstract class.
 */
abstract class HouseTemplate {

    //template method, final so subclasses can't override
    public final void buildHouse(){
        buildFoundation();
        buildPillars();
        buildWalls();
        buildWindows();
        System.out.println("House is built.");
    }

    //default implementation
    private void buildWindows() {
        System.out.println("Building Glass Windows");
    }

    //methods to be implemented by subclasses
    public abstract void buildWalls();
    public abstract void buildPillars();

    private void buildFoundation() {
        System.out.println("Building foundation with cement,iron rods and sand");
    }
}


class WoodenHouse extends HouseTemplate {

    @Override
    public void buildWalls() {
        System.out.println("Building Wooden Walls");
    }

    @Override
    public void buildPillars() {
        System.out.println("Building Pillars with Wood coating");
    }

}



class GlassHouse extends HouseTemplate {

    @Override
    public void buildWalls() {
        System.out.println("Building Glass Walls");
    }

    @Override
    public void buildPillars() {
        System.out.println("Building Pillars with glass coating");
    }

}