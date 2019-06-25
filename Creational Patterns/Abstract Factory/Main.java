interface Shape {
    public void draw();
}

class Square implements Shape {
    /* Implements a normal square Shape. */
    @Override
    public void draw() {
        System.out.println("Square");
    }
}

class RoundedSquare implements Shape {
    /* Implements a rounded square Shape. */
    @Override
    public void draw() {
        System.out.println("Rounded Square");
    }
}

class RoundedRectangle implements Shape {
    /* Implements a rounded rectangle Shape. */
    @Override
    public void draw() {
        System.out.println("Rounded Rectangle");
    }
}

interface AbstractFactory {
    /* Defines an interface for Shape factories. */
    public Shape getShape(String shape);
}

class ShapeFactory implements AbstractFactory {
    /*
     * Implements the factory associated with the normal shape family.
     * Returns a normal Shape object given its name.
     * */
    @Override
    public Shape getShape(String shape)
    {
        if (shape.equals("square")) {
            return new Square();
        }
        return null;
    }
}

class RoundedShapeFactory implements AbstractFactory {
    /*
    * Implements the factory associated with the rounded shape family.
    * Returns the appropriate rounded Shape given its name.
    * */
    @Override
    public Shape getShape(String shape) {
        if (shape.equals("square")) {
            return new RoundedSquare();
        }
        else if (shape.equals("rectangle")) {
            return new RoundedRectangle();
        }
        return null;
    }
}

class SuperFactory {
    /*
    * Returns the appropriate factory class matching
    * the Shape family given.
    * */
    public AbstractFactory getFactory(String factory){
        if (factory.equals("normal")) {
            return new ShapeFactory();
        }
        else if (factory.equals("round")) {
            return new RoundedShapeFactory();
        }
        return null;
    }
}


public class Main {

    public static void main(String[] args) {
	    SuperFactory superFactory = new SuperFactory();
        AbstractFactory normalFactory = superFactory.getFactory("normal");
	    AbstractFactory roundFactory = superFactory.getFactory("round");

        Shape shape1 = normalFactory.getShape("square");
	    Shape shape2 = roundFactory.getShape("square");

	    shape1.draw();
	    shape2.draw();
    }
}
 
