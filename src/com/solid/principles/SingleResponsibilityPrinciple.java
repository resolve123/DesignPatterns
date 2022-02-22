package com.solid.principles;

/**
 * 1. Every software component should have one and only one responsibilty
 *
 * 2. Cohesion : is the degree to which the various parts of software componenet are related.
 * example we have square class so method in that class should be related.Square class have calculate area and calculate parimeter but if we will add method
 * like draw square and rotate square then these are not related so we should keep these method in separate class.
 *
 * Coupling : level of inter dependency between various componenets. Example  in square class if you have save method and in that if you will keep code for database connection for MSSQL
 * then if you need to change the DB tomorrow you have to change this class with cause it tight coupling. So move the connection related code to repository class.
 */
public class SingleResponsibilityPrinciple {
}

class Square{
    int side;
    public Square(int side){
        this.side=side;
    }
    public int calculateArea(){
        return  this.side * this .side;
    }

    public int calculatePerimeter(){
        return  this.side * 4;
    }

    /**
     * This methos is not in Cohesion with above two methods so need to be moved out of this class to a new class
     */
    public void drawSquare(){

    }

    /**
     * database connection code make this class tighlt coupled MSSQL database so need to move database connection code out of this class to repository class.
     */
    public void save(){
        //MSSQL Database connection code
    }

}
