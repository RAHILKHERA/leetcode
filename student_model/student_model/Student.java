package student_model;

public class Student {
    private int rollno;
    private String name;
    
    public Student() {
    }
    public int getRollno() {
        return rollno;
    }
    public void setRollno(int rollno) {
        this.rollno = rollno;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Student [rollno=" + rollno + ", name=" + name + "]";
    }
}
