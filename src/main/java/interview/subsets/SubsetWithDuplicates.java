package interview.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetWithDuplicates {

    // [1, 5, 2, 3, 3]
    // [1, 2, 3, 3, 5]
    //                                              []
    //                                            []  [1]
    //                                       []  [1]  [2] [1,2]
    //                            []  [1]  [2] [1,2]  [3]  [1,3]  [2,3] [1,2,3]
    // []  [1]  [2] [1,2]  [3]  [1,3]  [2,3] [1,2,3]  [3,3]  [1,3,3]  [2,3,3] [1,2,3,3]
    //
    // t: O (N*LogN + N * 2^N) => O (N * (LogN + 2^N)) => O (N * 2^N)
    // space: O (2^N)
    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        Arrays.sort(nums); // N*LogN
        subsets.add(new ArrayList<>());
        int prev = 0;
        for (int j = 0; j < nums.length; j++) { // N
            int size = subsets.size();
            for (int i = nums[j] == prev ? size / 2: 0; i < size; i++) { // 2^N
                List<Integer> set = new ArrayList<>(subsets.get(i));
                set.add(nums[j]);
                subsets.add(set);
            }
            prev = nums[j];
        }
        return subsets;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = SubsetWithDuplicates.findSubsets(new int[] { 1, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = SubsetWithDuplicates.findSubsets(new int[] { 1, 5, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
}
