package university.student;

public class Students {
    String name;
    static int count = 101;
    int rollNo ;

    public Students(String name){
        this.name = name;
        this.rollNo = count++;
    }

    public void display(){
                System.out.println("------ Student Details ------");
        System.out.println(name+ " and rollNo is "+rollNo);
    }
}
