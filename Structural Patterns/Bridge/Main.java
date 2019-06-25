interface ColoredShape {
    public void draw(int x, int y, int radius);
}

class RedCircle implements ColoredShape {
    public void draw(int x, int y, int radius) {
        System.out.println("Red Circle!, Radius " + radius);
    }
}

class GreenCircle implements ColoredShape {
    public void draw(int x, int y, int radius) {
        System.out.println("Green Circle!, Radius " + radius);
    }
}

abstract class Shape {
    protected ColoredShape myShape;

    public abstract void drawCircle();
    public abstract void drawBorderedCircle();
}

class Circle extends Shape {
    private int x, y, radius;

    public Circle(int x, int y, int radius, ColoredShape circle) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.myShape = circle;
    }

    public void drawCircle() {
        myShape.draw(x, y, radius);
    }
    public void drawBorderedCircle() {
        System.out.println("---");
        drawCircle();
        System.out.println("---");
    }
}


public class Main {

    public static void main(String[] args) {
        Shape greenCircle = new Circle(100, 100, 12, new GreenCircle());
        Shape redCircle = new Circle(100, 100, 10, new RedCircle());

        greenCircle.drawCircle();
        redCircle.drawBorderedCircle();
    }
}
 
