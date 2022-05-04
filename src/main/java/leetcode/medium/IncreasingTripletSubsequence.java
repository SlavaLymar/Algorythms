package leetcode.medium;

public class IncreasingTripletSubsequence {

    //
    // 10,20,3,2,1,1,2,0,4
    //
    // t: O (N)
    // space: O (1)
    //
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) return false;

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= first) first = num;
            else if (num <= second) second = num;
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(
                new IncreasingTripletSubsequence().increasingTriplet(new int[] { 10,20,3,2,1,1,2,0,4 })
        );
    }
}
