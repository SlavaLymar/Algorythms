package interview.binarysearch;

public class SearchInfiniteSortedArray {

    //  s
    // [1, 3, 8, 10, 15], key = 15
    //     e
    //
    // t: O (Log N)
    // space: O (1)
    public static int search(ArrayReader reader, int key) {
        int start = 0, end = 1;
        if (reader.get(start) == key) return start;
        if (reader.get(end) == key) return end;
        while (reader.get(end) < key && end < reader.arr.length - 1) {
            end += (Math.abs(end - start) + 1) * 2;
            start = end < reader.arr.length - 1 ? end + 1 : reader.arr.length - 1;
            if (reader.arr[start] == key) {
                return start;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ArrayReader reader = new ArrayReader(new int[] { 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30 });
        System.out.println(SearchInfiniteSortedArray.search(reader, 16));
        System.out.println(SearchInfiniteSortedArray.search(reader, 11));
        reader = new ArrayReader(new int[] { 1, 3, 8, 10, 15 });
        System.out.println(SearchInfiniteSortedArray.search(reader, 15));
        System.out.println(SearchInfiniteSortedArray.search(reader, 200));
    }

    static class ArrayReader {
        int[] arr;

        ArrayReader(int[] arr) {
            this.arr = arr;
        }

        public int get(int index) {
            if (index >= arr.length)
                return Integer.MAX_VALUE;
            return arr[index];
        }
    }
}
