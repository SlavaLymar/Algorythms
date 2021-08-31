package leetcode.easy;

public class RemoveElement {

    //
    // nums = [0,1,2,2,3,0,4,2], val = 2
    //  e
    // [0,1,2,2,3,0,4,2]
    //  i
    //
    // t: O (N)
    // space: O (1)
    //
    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int elem: nums){
            if (elem != val){
                nums[i] = elem;
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
    }
}
