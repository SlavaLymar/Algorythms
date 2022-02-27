package leetcode.medium;

public class HouseRobber {

    //
    // nums = [2, 5, 1, 3, 6, 2, 4]
    //
    //                   i
    //    2 5 1 3  6  2  4
    //  0 2 5 5 8 11 11 15
    //
    //
    // t: O (N)
    // t: O (1)
    //
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        int n1=0, n2=nums[0], temp;
        for(int i=1; i < nums.length; i++) {
            temp = Math.max(n1 + nums[i], n2);
            n1 = n2;
            n2 = temp;
        }
        return n2;
    }

    public static void main(String[] args) {
        System.out.println(new HouseRobber().rob(new int[]{2, 5, 1, 3, 6, 2, 4}));
    }
}
