import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import static java.lang.Math.PI;

public class Main {
    public class Jedi {
        /* Constructor A */
        Jedi(String name, String species){
            this(name,species, false);
        }
      
        /* Constructor B */
        Jedi(String name, String species, boolean followsTheDarkSide){}
      }


      public static void main(String[] args) {
        // List<Boolean> list = new ArrayList<>();
        // list.add(true);
        // list.add(Boolean.parseBoolean("FalSe"));
        // list.add(Boolean.TRUE);
        // System.out.print(list.size());
        // System.out.print(list.get(1) instanceof Boolean);


        // System.out.println("nifty".getClass().getSimpleName() == "String");

        // String[] array = {"abc", "2", "010", "0", "100", "20", "001", "a"};
        // List<String> list = Arrays.asList(array);
        // Collections.sort(list);
        // System.out.println(Arrays.toString(array));
        // System.out.println(PI);

        // String[] array = new String[]{"A", "B", "C"};
        // List<String> list1 = Arrays.asList(array);
        // List<String> list2 = new ArrayList<>(Arrays.asList(array));
        // List<String> list3 = new ArrayList<>(Arrays.asList("A", new String("B"), "C"));
        // System.out.print(list1.equals(list2));
        // System.out.print(list1.equals(list3));

        // ArrayList<String> words = new ArrayList<String>(Arrays.asList("Hello", "World"));

        // StringBuilder sb = new StringBuilder("hello");
        // sb.deleteCharAt(0).insert(0, "H");
        // System.out.println(sb);
        

        // Function<Integer, Integer> squareLambda = x -> x *x;
        // BiFunction addition = (x,y) -> x + y;

        // List<Integer> numbers = List.of(1,2,3,4);
        // Integer total = 0;

        // total = numbers
        //     .stream()
        //     .filter(x -> x%2 == 0)
        //     .map(x -> x*x)
        //     .reduce(0, (a,b) -> a + b);

        int mask = 0x000F;
        int value = 0x2222;
        System.out.println(value & mask);
        String abc = "leetscode";
    }
}


