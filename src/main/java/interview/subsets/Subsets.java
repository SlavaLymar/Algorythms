package interview.subsets;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    // 1, 5, 3
    // [[], [1], [5], [1, 5], [3], [1, 3], [1, 5], [1, 5, 3]]
    //                      []
    //                    []  [1]
    //               []  [1]   [5] [1, 5]
    //   []  [1]  [5] [1, 5]   [3] [1, 3] [1, 5] [1, 5, 3]
    //
    // T = O (N * 2 ^ N), Space = O (2 ^ N)
    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        for (int num : nums) { // 3
            int size = subsets.size(); // 4
            for (int i = 0; i < size; i++) { // 3
                List<Integer> set = new ArrayList<>(subsets.get(i)); // [1, 5]
                set.add(num); // [1, 5, 3]
                subsets.add(set); // [[], [1], [5], [1, 5], [3], [1, 3], [5, 3], [1, 5, 3]]
            }
        }
        return subsets;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Subsets.findSubsets(new int[] { 1, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = Subsets.findSubsets(new int[] { 1, 5, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
}
