package org.exercises.designpatterns.FactoryPattern;

public class ShapeFactory {
    // This method takes a shape type as input and returns the appropriate Shape instance
    public Shape createShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }

        // Return the appropriate shape based on the input type
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }

        return null; // If no match found, return null
    }
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Square.");
    }
}

// Circle.java
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle.");
    }
}

interface Shape {
    void draw();
}
