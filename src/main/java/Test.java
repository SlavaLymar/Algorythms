import java.util.ArrayList;
import java.util.List;

public class Test {

    private List<int[]> list = new ArrayList<>();

    //
    //               s
    // [3,4] [6,7] [10,11]             [12,13]
    //               me
    //
    //
    // t: O (log N)
    // space: O (N)
    //
    public boolean check(int[] task) {
        if (task == null) {
            return false;
        }
        if (list.size() == 0) {
            list.add(task);
            return true;
        }
        boolean result = false;
        int start = 0, end = list.size() - 1, mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            int[] interval = list.get(mid);
            if (start == end) {
                if (task[0] >= interval[1]) {
                    list.add(mid + 1, task);
                    result = true;
                    break;
                } else if (task[1] <= interval[0]) {
                    list.add(mid, task);
                    result = true;
                    break;
                } else {
                    break;
                }
            }
            if (task[0] < interval[1]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.check(new int[]{7, 11}));
        System.out.println(test.check(new int[]{1, 3}));
        System.out.println(test.check(new int[]{3, 7}));
        System.out.println(test.check(new int[]{2, 5}));
        System.out.println(test.check(new int[]{1, 2}));
    }
}
