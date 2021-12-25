package leetcode.easy;

public class MergeSortedArray {

    //   p1    p
    // [[4,0,0,0,5,6]  [1,2,3,5,6]
    //                      p2
    //
    //  p1         p
    // [[1,0,0,0,0,0]  [1,3,4,5,6]
    //                          p2
    //
    // t: O (m + n)
    // space: O (1)
    //
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null || n == 0) return;
        int p1 = m - 1, p = nums1.length - 1, p2 = nums2.length - 1;
        while (p >= 0) {
            if (p2 < 0) break;
            if (p1 >= 0 && nums1[p1] >= nums2[p2]) {
                nums1[p--] = nums1[p1--];
            } else {
                nums1[p--] = nums2[p2--];
            }
        }
    }
}
