package leetcode.hard;

public class MedianOfTwoSortedArr {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] arr = new int[nums1.length + nums2.length];
        int indexArr = 0;
        int index1 = 0;
        int index2 = 0;

        for (int i = 0; i < arr.length; i++) {
            if (index2 == nums2.length) {
                arr[indexArr++] = nums1[index1++];
                continue;
            } else if (index1 == nums1.length) {
                arr[indexArr++] = nums2[index2++];
                continue;
            }
            if (nums1[index1] <= nums2[index2]) {
                arr[indexArr++] = nums1[index1++];
            } else {
                arr[indexArr++] = nums2[index2++];
            }
        }

        return arr.length % 2 == 0 ? findMedianFromEven(arr) : findMedianFromOdd(arr);
    }

    private double findMedianFromOdd(int[] arr) {
        return arr[arr.length / 2] ;
    }

    private double findMedianFromEven(int[] arr) {
        return arr.length > 0 ? (arr[(arr.length / 2) - 1] + arr[arr.length / 2]) / 2d : 0;
    }
}
