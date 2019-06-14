interface Shape {
	public void draw();
}

class Circle implements Shape{
	@Override
	public void draw()
	{
		System.out.println("My circle\n");
	}
}

class Rectangle implements Shape {
	@Override
	public void draw() { System.out.println("My Rectangle"); }
}

abstract class ShapeDecorator implements Shape {
	Shape shape;

	public ShapeDecorator(Shape shape)	{
		this.shape = shape;
	}
	public abstract void draw();
}

class RedShapeDecorator extends ShapeDecorator {
	/*
	* Adds (Decorates) a red border to any given shape object.
	* Acts as normal Shape with a red border.
	* */
	public RedShapeDecorator(Shape shape) { super(shape); }

	public void draw() {
		drawBorder();
		this.shape.draw();
	}

	private void drawBorder() { System.out.println("Red Border"); }
}


public class Main {

    public static void main(String[] args) {
    	// Create normal circle
	    Shape circle = new Circle();

	    // Create shapes with red border
	    Shape redCircle = new RedShapeDecorator(new Circle());
	    Shape redRectangle = new RedShapeDecorator(new Rectangle());

	    System.out.println("Circle with Normal Border:");
	    circle.draw();

	    System.out.println("Circle of red border:");
	    redCircle.draw();

	    System.out.println("Rectangle of red border:");
	    redRectangle.draw();
    }
}
 
