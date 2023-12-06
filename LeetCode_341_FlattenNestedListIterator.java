import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
public class LeetCode_341_FlattenNestedListIterator {
    
}

class Solution_LeetCode_341_FlattenNestedListIterator  {



}

class NestedIntegerImpl implements NestedInteger {

    @Override
    public boolean isInteger() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isInteger'");
    }

    @Override
    public Integer getInteger() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getInteger'");
    }

    @Override
    public List<NestedInteger> getList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getList'");
    }

}

class NestedIterator implements Iterator<Integer> {

   

    public NestedIterator(List<NestedInteger> nestedList) {
        
        flattenNestedList(nestedList);
    }

    private List<Integer> flattenNestedList (List<NestedInteger> nestedList) {

        List<Integer> result = new ArrayList<>();
        for (NestedInteger obj : nestedList) {
            if (obj.isInteger()) {
                result.add(obj.getInteger());
            } else {
                result.addAll(flattenNestedList(obj.getList()));
            }
        }

         return result;

    }


    @Override
    public Integer next() {
        return null;      
    }

    @Override
    public boolean hasNext() {
        return true;
    }
}


 // This is the interface that allows for creating nested lists.
 // You should not implement it, or speculate about its implementation
interface NestedInteger {
 
      // @return true if this NestedInteger holds a single integer, rather than a nested list.
      public boolean isInteger();
 
      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      public Integer getInteger();
 
      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return empty list if this NestedInteger holds a single integer
      public List<NestedInteger> getList();
 }
 