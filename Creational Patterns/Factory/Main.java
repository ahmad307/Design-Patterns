interface Shape {
    public void draw();
}

class Rectangle implements Shape {
    public void draw(){
        System.out.println("Rectangle Drawn");
    }
}

class Circle implements Shape{
    public void draw(){
        System.out.println("Circle Drawn");
    }
}

enum ShapeTypes {
    /*
    * Defines Shape choices client can choose from.
    * */
    circle, rectangle;
}

class Drawer
{
    /*
     * Handles retreiving appropriate class that matches users's input.
     * Acts as factory class.
     * */
    Shape drawShape(ShapeTypes shapeName)
    {
        /* Returns the shape matching the given ShapeTypes choice. */
        Shape myShape = null;

        if (shapeName == ShapeTypes.circle) {
            myShape = new Circle();
        } else if (shapeName == ShapeTypes.rectangle) {
            myShape = new Rectangle();
        }

        return myShape;
    }
}


public class Main {

    public static void main(String[] args) {
        Drawer drawer = new Drawer();

        // Client chooses the desired shape
        Shape myShape = drawer.drawShape(ShapeTypes.rectangle);
        myShape.draw();
    }
}
 
