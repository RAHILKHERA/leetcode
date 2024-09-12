import static org.junit.Assert.assertEquals;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

import org.junit.Test;

public class LeetCode_726_NumberofAtoms {

    @Test
    public void test1() {
        assertEquals("H2O", countOfAtoms("H2O"));
    }

    @Test
    public void test2() {
        assertEquals("H2MgO2", countOfAtoms("Mg(OH)2"));
    }

    @Test
    public void test3() {
        assertEquals("K4N2O14S4", countOfAtoms("K4(ON(SO3)2)2"));
    }

    @Test
    public void test4() {
        assertEquals("Be32", countOfAtoms("Be32"));
    }

    public String countOfAtoms(String formula) {

        char[] formulaArray = formula.toCharArray();
        int n = formula.length();
        Stack<TreeMap<String, Integer>> stack = new Stack<>();
        stack.push(new TreeMap<>());
        int index = 0;
        while (index < n) {

            if (formulaArray[index] == '(') {
                stack.push(new TreeMap<>());
                index++;
            } else if (formulaArray[index] == ')') {
                TreeMap<String, Integer> current = stack.pop();
                index++;

                StringBuilder multiplier = new StringBuilder();
                while (index < n && Character.isDigit(formulaArray[index])) {
                    multiplier.append(formulaArray[index]);
                    index++;
                }

                if (multiplier.length() != 0) {
                    int multi = Integer.parseInt(multiplier.toString());
                    for (Map.Entry<String, Integer> entry : current.entrySet()) {
                        current.put(entry.getKey(), entry.getValue() * multi);
                    }
                }

                for (Map.Entry<String, Integer> entry : current.entrySet()) {
                    String key = entry.getKey();
                    Integer value = entry.getValue();
                    TreeMap<String, Integer> top = stack.peek();
                    if (top.containsKey(key)) {
                        top.put(key, value + top.get(key));
                    } else {
                        top.put(key, value);
                    }
                }
            } else {
                StringBuilder element = new StringBuilder();
                element.append(formulaArray[index]);
                index++;
                while (index < n && Character.isLowerCase(formulaArray[index])) {
                    element.append(formulaArray[index]);
                    index++;
                }

                StringBuilder value = new StringBuilder();

                while (index < n && Character.isDigit(formulaArray[index])) {
                    value.append(formulaArray[index]);
                    index++;
                }

                int currentCount = value.length() == 0 ? 1 : Integer.parseInt(value.toString());

                TreeMap<String, Integer> top = stack.peek();
                if (top.containsKey(element.toString())) {
                    top.put(element.toString(), currentCount + top.get(element.toString()));
                } else {
                    top.put(element.toString(), currentCount);
                }

            }
        }

        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> entry : stack.peek().entrySet()) {

            result.append(entry.getKey());
            if (entry.getValue() > 1) {
                result.append(entry.getValue());

            }
        }

        return result.toString();
    }

}
