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
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        int startIndex = 0, endIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            startIndex = 0;
            // if current and the previous elements are same, create new subsets only from the subsets
            // added in the previous step
            if (i > 0 && nums[i] == nums[i - 1]) {
                startIndex = endIndex + 1;
            }
            endIndex = subsets.size() - 1;
            for (int j = startIndex; j <= endIndex; j++) {
                // create a new subset from the existing subset and add the current element to it
                List<Integer> set = new ArrayList<>(subsets.get(j));
                set.add(nums[i]);
                subsets.add(set);
            }
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
