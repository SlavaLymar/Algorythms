package leetcode.medium;

import java.util.NoSuchElementException;

public class Flatten2DVector {

    private int[][] v;
    private int inner;
    private int outer;

    public Flatten2DVector(int[][] vec) {
        this.v = vec;
        this.inner = 0;
        this.outer = 0;
    }

    private void advanceToNext() {
        while (this.outer < this.v.length && this.inner == this.v[outer].length) {
            this.inner = 0;
            this.outer++;
        }
    }

    public int next() {
        if (hasNext()) return this.v[outer][inner++];
        else throw new NoSuchElementException();
    }

    public boolean hasNext() {
        this.advanceToNext();
        return this.outer < this.v.length;
    }

    public static void main(String[] args) {
        Flatten2DVector vector = new Flatten2DVector(new int[][]{
                {1,2}, {3}, {4}
        });
        System.out.println(vector.hasNext());
        System.out.println(vector.next());
        System.out.println(vector.next());
        System.out.println(vector.next());
        System.out.println(vector.hasNext());
        System.out.println(vector.next());
        System.out.println(vector.hasNext());
        System.out.println(vector.next());
    }
}
