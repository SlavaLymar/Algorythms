package leetcode.medium;

import java.util.*;

public class FlattenNestedListIterator {


    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    static class NestedIntegerImpl implements NestedInteger {

        private Integer integer;
        private List<NestedInteger> nestedIntegers;

        public NestedIntegerImpl(Integer integer) {
            this.integer = integer;
            this.nestedIntegers = Collections.emptyList();
        }

        public NestedIntegerImpl(List<NestedInteger> nestedIntegers) {
            this.nestedIntegers = nestedIntegers;
        }

        @Override
        public boolean isInteger() {
            return this.integer != null && this.nestedIntegers.isEmpty();
        }

        @Override
        public Integer getInteger() {
            return this.integer;
        }

        @Override
        public List<NestedInteger> getList() {
            return this.nestedIntegers;
        }
    }

    public static class NestedIterator implements Iterator<Integer> {

        private Queue<Integer> queue;

        public NestedIterator(List<NestedInteger> nestedList) {
            this.queue = new ArrayDeque<>();
            this.init(nestedList);
        }

        private void init(List<NestedInteger> nestedList) {
            for (NestedInteger nestedInteger : nestedList) {
                if (nestedInteger.isInteger()) {
                    this.queue.offer(nestedInteger.getInteger());
                } else {
                    this.init(nestedInteger.getList());
                }
            }
        }

        @Override
        public Integer next() {
            return this.queue.poll();
        }

        @Override
        public boolean hasNext() {
            return !this.queue.isEmpty();
        }
    }

    public static void main(String[] args) {
        // [[1,1],2,[1,1]]

//        List<NestedInteger> nestedIntegers = new ArrayList<>();
//        List<NestedInteger> nestedIntegers11 = new ArrayList<>();
//        nestedIntegers11.add(new NestedIntegerImpl(1));
//        nestedIntegers11.add(new NestedIntegerImpl(1));
//
//        nestedIntegers.add(new NestedIntegerImpl(nestedIntegers11));
//        nestedIntegers.add(new NestedIntegerImpl(2));
//        nestedIntegers.add(new NestedIntegerImpl(nestedIntegers11));
//
//        NestedIterator nestedIterator = new NestedIterator(nestedIntegers);
//        while (nestedIterator.hasNext()) {
//            System.out.print(nestedIterator.next() + " ");
//        }


//        [1,[4,[6]]]
        List<NestedInteger> nestedIntegers = new ArrayList<>();
        nestedIntegers.add(new NestedIntegerImpl(1));

        List<NestedInteger> nestedIntegers46 = new ArrayList<>();
        nestedIntegers46.add(new NestedIntegerImpl(4));
        ArrayList<NestedInteger> nestedIntegers6 = new ArrayList<>();
        nestedIntegers6.add(new NestedIntegerImpl(6));
        nestedIntegers46.add(new NestedIntegerImpl(nestedIntegers6));

        nestedIntegers.add(new NestedIntegerImpl(nestedIntegers46));

        NestedIterator nestedIterator = new NestedIterator(nestedIntegers);
        while (nestedIterator.hasNext()) {
            System.out.print(nestedIterator.next() + " ");
        }
    }
}


