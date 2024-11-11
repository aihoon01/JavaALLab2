package org.exercises.designpatterns.FactoryPattern;

public class Exercise1 {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        // Get a Circle instance and call its draw method
        Shape circle = shapeFactory.createShape("CIRCLE");
        if (circle != null) circle.draw();

        // Get a Square instance and call its draw method
        Shape square = shapeFactory.createShape("SQUARE");
        if (square != null) square.draw();


        // Attempt to create a non-existent shape
        Shape unknown = shapeFactory.createShape("TRIANGLE");
        if (unknown == null) System.out.println("Shape type not recognized.");

    }
}

