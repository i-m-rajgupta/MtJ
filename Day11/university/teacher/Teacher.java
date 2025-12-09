package university.teacher;

public class Teacher {
    String name;
    String subject;

    public Teacher(String name,String subject){
        this.name = name;
        this.subject = subject;
    }

    public void info(){
        System.out.println("---- Teacher Details -----");
        System.out.println(name+" teaches "+subject);
    }
}
