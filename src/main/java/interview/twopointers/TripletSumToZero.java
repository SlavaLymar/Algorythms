package interview.twopointers;

import java.util.*;

public class TripletSumToZero {

    public static void main(String[] args) {
        System.out.println(searchTriplets(new int[]{-3, 1, 0, 2, -1, 1, -2}));
    }

    // -3, 0, 1, 2, -1, 1, -2
    // O(N log N) + 2 * N
    // O(N + N)
    // -3, -2, -1, 0, 1, 1, 2
    //  l                   r
    //
    public static List<List<Integer>> searchTriplets(int[] arr) {
        Arrays.sort(arr);
        Map<Integer, Integer> numberFrequency = new HashMap<>();
        for (int number : arr) {
            numberFrequency.put(number, numberFrequency.getOrDefault(number, 0) + 1);
        }

        List<List<Integer>> triplets = new ArrayList<>();
        int left = 0;
        int right = arr.length - 1;
        while (right - left >= 2) {

            while (right - left > 2 && arr[left] == arr[left + 1]) {
                left++;
            }
            while (right - left > 2 && arr[right] == arr[right - 1]) {
                right--;
            }

            int lNumber = arr[left];
            numberFrequency.put(lNumber, numberFrequency.get(lNumber) - 1);
            int rNumber = arr[right];
            numberFrequency.put(rNumber, numberFrequency.get(rNumber) - 1);
            int sum = lNumber + rNumber;
            if (numberFrequency.containsKey(-sum) && numberFrequency.get(-sum) > 0) {
                triplets.add(Arrays.asList(lNumber, rNumber, -sum));
            }
            if (sum < 0) {
                left++;
            } else {
                right--;
            }
            numberFrequency.put(lNumber, numberFrequency.get(lNumber) + 1);
            numberFrequency.put(rNumber, numberFrequency.get(rNumber) + 1);
        }
        return triplets;
    }
}
