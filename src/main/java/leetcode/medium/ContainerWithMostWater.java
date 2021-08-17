package leetcode.medium;

public class ContainerWithMostWater {

    // i
    // 1,8,6,2,5,4,8,3,7
    //                 j
    // t: O (N)
    // space: O (1)
    //
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1, max = Integer.MIN_VALUE;
        while (left < right) {
            int s = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(max, s);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{2,3,4,5,18,17,6}));
    }
}
