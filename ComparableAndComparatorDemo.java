import java.util.ArrayList;
import java.util.Collections;

public class ComparableAndComparatorDemo  implements Comparable<ComparableAndComparatorDemo>{

    private int age;
    private String name;


    public ComparableAndComparatorDemo(int age, String name) {
        this.age = age;
        this.name = name;
    }


    @Override
    public int compareTo(ComparableAndComparatorDemo o) {
       return Integer.compare(this.getAge(), o.getAge());
    }


    public int getAge() {
        return age;
    }


    @Override
    public String toString() {
        return "CACD [age=" + age + ", name=" + name + "]";
    }


    public void setAge(int age) {
        this.age = age;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public static void main(String[] args) {
        
        ArrayList<ComparableAndComparatorDemo>  list = new ArrayList<ComparableAndComparatorDemo>();
        
        list.add(new ComparableAndComparatorDemo(10, "mno"));
        list.add(new ComparableAndComparatorDemo(5, "jkl"));
        list.add(new ComparableAndComparatorDemo(15, "ghi"));
        list.add(new ComparableAndComparatorDemo(12, "def"));
        list.add(new ComparableAndComparatorDemo(20, "abc"));

       // Collections.sort(list);

        System.out.println(list);

        //Example of Comparator
        Collections.sort(list, (ComparableAndComparatorDemo c1, ComparableAndComparatorDemo c2) -> {
            return c1.getName().compareTo(c2.getName());
        });

        System.out.println(list);
    }
    
}
