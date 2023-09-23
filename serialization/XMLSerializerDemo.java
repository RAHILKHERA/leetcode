package serialization;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
//import java.util.List;

import student_model.College;
import student_model.Student;


public class XMLSerializerDemo {
    public static void main(String[] args) {

        File students = new File("students.xml");
        serialize(createData(), students);
        ArrayList<Student> listofStudents = deserialize(students);
        for(Student student : listofStudents) {
            System.out.println(student);
        }
        
    }


    private static College createData() {

        Student s0 = new Student();
        s0.setRollno(101);
        s0.setName("Rahil");

        Student s1 = new Student();
        s1.setRollno(102);
        s1.setName("Farz");

        ArrayList<Student> students = new ArrayList<Student>();
        students.add(s0);
        students.add(s1);

        College c = new College();
        c.setStudents(students);

        return c;
    }

    private static  void serialize(College c, File dataFile) {
        XMLEncoder xml = null;
        try {
                xml = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(dataFile)));
                xml.writeObject(c);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                xml.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    private static ArrayList<Student> deserialize(File dataFile) {
        XMLDecoder xml = null;
        ArrayList<Student> students = null;
        try {
            xml = new XMLDecoder(new BufferedInputStream(new FileInputStream(dataFile)));
            College c = (College)xml.readObject();
            students =  (ArrayList<Student>) c.getStudents();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }
}


// class College {

//     private List<Student> students;

//     public College() {
//     }

//     @Override
//     public String toString() {
//         return "College [students=" + students + "]";
//     }

//     public List<Student> getStudents() {
//         return students;
//     }

//     public void setStudents(List<Student> students) {
//         this.students = students;
//     }

// }

//  class Student {
//     private int rollno;
//     private String name;
    
//     public Student() {
//     }
//     public int getRollno() {
//         return rollno;
//     }
//     public void setRollno(int rollno) {
//         this.rollno = rollno;
//     }
//     public String getName() {
//         return name;
//     }
//     public void setName(String name) {
//         this.name = name;
//     }


//     @Override
//     public String toString() {
//         return "Student [rollno=" + rollno + ", name=" + name + "]";
//     }
// }
