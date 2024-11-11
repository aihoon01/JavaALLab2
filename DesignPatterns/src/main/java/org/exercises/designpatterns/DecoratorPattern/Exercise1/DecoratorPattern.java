package org.exercises.designpatterns.DecoratorPattern.Exercise1;


public class DecoratorPattern {
    public static void main(String[] args) {
        // Basic shapes
        Shape circle = new Circle();
        Shape rectangle = new Rectangle();

        // Circle with a red border
        Shape redBorderedCircle = new ColoredBorderDecorator(circle, "red");

        // Rectangle with 50% transparency
        Shape transparentRectangle = new TransparencyDecorator(rectangle, 0.5);

        // Circle with both a blue border and 75% transparency
        Shape decoratedCircle = new TransparencyDecorator(new ColoredBorderDecorator(circle, "blue"), 0.75);

        // Drawing shapes with decorations
        System.out.println("Drawing basic circle:");
        circle.draw();

        System.out.println("\nDrawing circle with red border:");
        redBorderedCircle.draw();

        System.out.println("\nDrawing rectangle with 50% transparency:");
        transparentRectangle.draw();

        System.out.println("\nDrawing circle with blue border and 75% transparency:");
        decoratedCircle.draw();
    }
}

// Concrete decorator to add transparency
class TransparencyDecorator extends ShapeDecorator {
    private double transparency;

    public TransparencyDecorator(Shape decoratedShape, double transparency) {
        super(decoratedShape);
        this.transparency = transparency;
    }

    @Override
    public void draw() {
        decoratedShape.draw(); // Original draw behavior
        setTransparency(transparency); // Additional behavior
    }

    private void setTransparency(double transparency) {
        System.out.println("Setting transparency level to " + (transparency * 100) + "%");
    }
}

// Concrete decorator to add colored border
class ColoredBorderDecorator extends ShapeDecorator {
    private String borderColor;

    public ColoredBorderDecorator(Shape decoratedShape, String borderColor) {
        super(decoratedShape);
        this.borderColor = borderColor;
    }

    @Override
    public void draw() {
        decoratedShape.draw(); // Original draw behavior
        setBorderColor(borderColor); // Additional behavior
    }

    private void setBorderColor(String color) {
        System.out.println("Adding a " + color + " border to the shape");
    }
}

