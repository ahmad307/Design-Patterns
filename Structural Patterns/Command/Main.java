
abstract class Shape {
	public abstract void draw();
}

class Circle extends Shape {
	public void draw() {
		System.out.println("Circle is drawn!");
	}
}


abstract class Command {
	/*
	 * An abstract class for creating commands and associating them
	 * with a certain object functionality.
	 * */
	protected Shape receiver;

	public abstract void execute();
}

class DrawCommand extends Command{
	/*
	 * A command class associated with a Shape object,
	 * it invokes the Shape draw method when execute
	 * method is called.
	 * */
	public DrawCommand(Shape receiver) {
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		receiver.draw();
	}
}


public class Main {
	public static void main(String[] args) {
	    Shape myShape = new Circle();

	    // Create a draw command associated with the created shape
	    Command draw = new DrawCommand(myShape);

	    // Draw the shape through the command object
	    draw.execute();
    }
}
 
