package leetcode.easy;

public class MajorityElement {

    //
    //     i
    // 3 2 3
    //
    // count = 1
    // candidate = 3
    //
    // t: O (N)
    // space: O (1)
    //
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += candidate == num ? 1 : - 1;
        }
        return candidate;
    }

    public static void main(String[] args) {
        System.out.println(new MajorityElement().majorityElement(new int[]{2,2,1,1,1,2,2}));
    }
}
