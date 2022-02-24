package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

    //
    // nums = [0,3,5,50,75], lower = 0, upper = 99
    //
    // result: ["1->2", "4", "6->49", "51->74", "76->99"]
    //         i
    // 0     0 3 5 50 75    99
    //
    //
    // t: O (N)
    // space: O (N)
    //
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if (nums == null) return result;
        if (nums.length == 0)  {
            process(result, lower, upper);
            return result;
        }
        for (int i = 0; i <= nums.length; i++) {
            if (i == 0) {
                process(result, lower, nums[i] - 1);
            } else if (i == nums.length) {
                process(result, nums[i - 1] + 1, upper);
            } else {
                process(result, nums[i - 1] + 1, nums[i] - 1);
            }
        }
        return result;
    }

    private void process(List<String> result, int from, int to) {
        if (from <= to) {
            result.add(format(from, to));
        }
    }

    private String format(int from, int to) {
        if (from == to) {
            return String.valueOf(from);
        } else {
            return String.format("%d->%d", from, to);
        }
    }

    public static void main(String[] args) {
        System.out.println(new MissingRanges().findMissingRanges(
                new int[]{0,3,5,50,75}, 0, 9));
    }
}
