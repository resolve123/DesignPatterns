package com.structural.design.patterns;

import java.util.ArrayList;
import java.util.List;

/**
 * This pattern consist of 3 type of objects
 * Base Component : top label interface or abstract class
 * Leaf: These implements base object
 * Composite :  It consists of leaf elements and implements the operations in base component.
 *
 * Basicaly this pattern is used when you want to apply same operation on couple of objects which implement same interface.
 */
public class CompositePattern {

    public static void main(String[] args) {
        Shape tri = new Triangle();
        Shape tri1 = new Triangle();
        Shape cir = new Circle();
//Composite object contains other leaf objects
        Drawing drawing = new Drawing();
        drawing.add(tri1);
        drawing.add(tri1);
        drawing.add(cir);

        drawing.draw("Red");
//Helper method in composite object
        drawing.clear();

        drawing.add(tri);
        drawing.add(cir);
        drawing.draw("Green");
    }
}

/**
 * This is the base component
 */
interface Shape {

    public void draw(String fillColor);
}

/**
 * This is one of the leaf object
 */
class Triangle implements Shape {

    @Override
    public void draw(String fillColor) {
        System.out.println("Drawing Triangle with color "+fillColor);
    }

}


/**
 * This is one of the leaf object
 */
class Circle implements Shape {

@Override
public void draw(String fillColor) {
        System.out.println("Drawing Circle with color "+fillColor);
        }
}


/**
 * This is the composite object implements base object as well as contains leaf objects
 * A composite object contains group of leaf objects and we should provide some helper methods to add or delete leafs from the group.
 * We can also provide a method to remove all the elements from the group.
 */

class Drawing implements Shape{

    //collection of Shapes (Leaf objects)
    private List<Shape> shapes = new ArrayList<Shape>();

    @Override
    public void draw(String fillColor) {
        for(Shape sh : shapes)
        {
            sh.draw(fillColor);
        }
    }

    //adding shape to drawing
    public void add(Shape s){
        this.shapes.add(s);
    }

    //removing shape from drawing
    public void remove(Shape s){
        shapes.remove(s);
    }

    //removing all the shapes
    public void clear(){
        System.out.println("Clearing all the shapes from drawing");
        this.shapes.clear();
    }
}