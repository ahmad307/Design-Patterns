class Employee implements Cloneable {
    /*
    * Employee class providing clone feature.
    */
    public String name;
    public int age;

    public Employee(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}


public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {

        Employee e1 = new Employee("Mike", 32);
        Employee e2 = (Employee) e1.clone();

        System.out.println(e2.name + " " + e2.age);
    }
}
