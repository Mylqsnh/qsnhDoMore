package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NestedIterator_341 {

    public static void main(String[] args) {
        //        [1,1],2,[1,1]
        ArrayList<NestedInteger> nestedIntegers = new ArrayList<>(Arrays.asList(
                new NestedInteger(Arrays.asList(new NestedInteger(1), new NestedInteger(1))),
                new NestedInteger(2),
                new NestedInteger(Arrays.asList(new NestedInteger(1), new NestedInteger(1)))
        ));
        NestedIterator_341 nestedIterator341 = new NestedIterator_341(nestedIntegers);
        while (nestedIterator341.hasNext()) {
            System.out.println(nestedIterator341.next());
        }
    }
    LinkedList<NestedInteger> children;

    public NestedIterator_341(List<NestedInteger> nestedList) {
        this.children = new LinkedList<>(nestedList);
    }

    public Integer next() {
        return children.remove().getInteger();
    }

    public boolean hasNext() {

        while (!children.isEmpty() && !children.get(0).isInteger()) {
            List<NestedInteger> first = children.remove().getList();
            for (int i = first.size() - 1; i >= 0; i--) {
                children.addFirst(first.get(i));
            }
        }

        return !children.isEmpty();
    }

}

class NestedInteger {
    private Integer val;
    private List<NestedInteger> list;

    public NestedInteger(Integer val) {
        this.val = val;
        this.list = null;
    }
    public NestedInteger(List<NestedInteger> list) {
        this.list = list;
        this.val = null;
    }

    // 如果其中存的是一个整数，则返回 true，否则返回 false
    public boolean isInteger() {
        return val != null;
    }

    // 如果其中存的是一个整数，则返回这个整数，否则返回 null
    public Integer getInteger() {
        return this.val;
    }

    // 如果其中存的是一个列表，则返回这个列表，否则返回 null
    public List<NestedInteger> getList() {
        return this.list;
    }
}
