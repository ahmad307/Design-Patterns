import java.io.File;

class Shape {
    public int length, width;
    protected String imagePath;
}

class Circle extends Shape {
    public File shapeImage;

    public Circle(String path, int width, int length) {
        this.imagePath = path;
        this.width = width;
        this.length = length;
        this.shapeImage = new File(imagePath);
    }
}

class CircleProxy extends Shape {
    /*
    * Place holder class for the circle object, containing
    * some data about the image.
    * Loads and returns the image itself only when needed.
    * */
    private Circle circle;

    public CircleProxy(String imagePath, int length, int width) {
        this.imagePath = imagePath;
        this.width = width;
        this.length = length;
    }

    public File loadImage() {
        if (circle == null)
            circle = new Circle(imagePath, width, length);
        return circle.shapeImage;
    }

    public File getImage() {
        if (circle == null)
            loadImage();
        return circle.shapeImage;
    }
}


public class Main {

    public static void main(String[] args) {
        // Create proxy object with basic data only
        CircleProxy circleProxy = new CircleProxy("/image/path", 2, 2);

        // Load and get the circle image when needed
        circleProxy.loadImage();
        File circleImage = circleProxy.getImage();
    }
}
 
