interface State {
    public void alert();
}

class GeneralState implements State {
    @Override
    public void alert() {
        System.out.println("General!");
    }
}

class SilentState implements State {
    @Override
    public void alert() {
        System.out.println("Silent!");
    }
}

class Alarm {
    /*
    * An alarm having a variable state, with the
    * default state as GeneralState.
    * */
    private State myState;

    public Alarm()
    {
        myState = new GeneralState();
    }

    public void setState(State state)
    {
        myState = state;
    }

    public void alert()
    {
        myState.alert();
    }
}


public class Main {

    public static void main(String[] args) {
        Alarm myClass = new Alarm();
        myClass.alert();

        // Alter the class behaviour by changing its state.
        myClass.setState(new SilentState());
        myClass.alert();

        myClass.setState(new GeneralState());
        myClass.alert();
    }
}
 
