package practice.oops;

public class basics {
    //declaring the datatype
    public static class Student{
        String name;
        int id;
        double percentage;
        StringBuilder dept;
    }
    static void change(Student x)// passing class(user defined datatype) i.e.,-- student to the method change();
    {
        x.name="Rahul";
    }

    public static void main(String[] args) {
        Student first = new Student();
            first.name="paras";
            first.id=59661;
//            first.percentage=96;
        System.out.println(first.name);
        change(first);
        System.out.println(first.name);
        // hence object of class are passed by reference;

        System.out.println(first.percentage);
        System.out.println(first.dept);
    }
}
