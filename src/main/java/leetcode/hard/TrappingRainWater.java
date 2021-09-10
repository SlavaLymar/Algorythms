package leetcode.hard;

public class TrappingRainWater {

    //  l
    // [4,2,0,3,2,5], lmax = 4, rmax = 5, sum = 0 | arr[l] < arr[r]: upd l else upd r
    //            r
    //            _
    //  _        | |
    // | |    _  | |
    // | |_  | |_| |
    // | | | | | | |
    // | | | | | | |
    //  4 2 0 3 2 5
    //
    //
    //
    //                l
    // [0,1,0,2,1,0,1,3,2,1,2,1], lmax = 2, rmax = 2, sum = 6
    //                r
    //
    // t: O (N)
    // space: O (1)
    //
    public static int trap(int[] height) {
        int left = 0, right = height.length - 1, leftMax = height[left], rightMax = height[right], sum = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    sum += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    sum += rightMax - height[right];
                }
                right--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
