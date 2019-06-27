class Window {
    /*
    * Class applying the singleton pattern.
    * Class instance is retrieved through getInstance() where
    * the same class instance is always returned.
    * */
    private static Window baseObject;
    public int size;

    private Window() {};
    public static Window getInstance() {

        if (baseObject != null)
            return baseObject;
        else
            return baseObject = new Window();
    }
}


public class Main {

    public static void main(String[] args) {
        // Create two objects of Window class
        Window w1, w2;
        w1 = Window.getInstance();
        w2 = Window.getInstance();

        // Alter an attribute of one of the objects
        w1.size = 2;

        // Print the attribute of the other object
        // (should correspond to the same value of the first object)
        System.out.println(w2.size);
    }
} 
