package leetcode.medium;

import java.util.*;

public class InsertDeleteGetRandomO1 {

    private List<Integer> list;
    private Map<Integer, Integer> map;
    private Random random;

    public InsertDeleteGetRandomO1() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
        this.random = new Random();
    }

    public boolean insert(int val) {
        if (this.map.containsKey(val)) return false;

        this.map.put(val, this.list.size());
        this.list.add(this.list.size(), val);
        return true;
    }

    public boolean remove(int val) {
        if (!this.map.containsKey(val)) return false;

        int lastElement = this.list.get(list.size() - 1);
        int idx = this.map.get(val);
        this.list.set(idx, lastElement);
        this.map.put(lastElement, idx);

        this.list.remove(list.size() - 1);
        this.map.remove(val);
        return true;
    }

    public int getRandom() {
        return this.list.get(this.random.nextInt(this.list.size()));
    }

    public static void main(String[] args) {

//        ["RandomizedSet","insert","remove","insert","getRandom","remove","insert","getRandom"]
//        [[],[1],[2],[2],[],[1],[2],[]]

        InsertDeleteGetRandomO1 insertDeleteGetRandomO1 = new InsertDeleteGetRandomO1();
        System.out.println("insert '1': " + insertDeleteGetRandomO1.insert(1));
        System.out.println("remove '2': " + insertDeleteGetRandomO1.remove(2));
        System.out.println("insert '2': " + insertDeleteGetRandomO1.insert(2));
        System.out.println("getRandom : " + insertDeleteGetRandomO1.getRandom());
        System.out.println("remove '1': " + insertDeleteGetRandomO1.remove(1));
        System.out.println("insert '2': " + insertDeleteGetRandomO1.insert(2));
        System.out.println("getRandom : " + insertDeleteGetRandomO1.getRandom());
    }
}
