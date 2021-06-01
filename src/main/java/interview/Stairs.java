package interview;

public class Stairs {

    public static void main(String[] args) {
        System.out.println((ways1(4)));
        System.out.println((ways2(4)));
    }

    //            _____
    //         __| 3
    //      __| 2
    //   __| 1
    //__| 0
    //
    //
    // 0, 1, 2, 3

    // steps - ways
    // 0 - 1
    // 1 - 1
    // 2 - 2
    // 3 - 3
    // 4 - 5
    // 5 - 8
    public static int ways1(int stepNum) {
        if (stepNum == 0 || stepNum == 1) {
            return 1;
        } else {
            return ways1(stepNum - 1) + ways1(stepNum - 2);
        }
    }

    public static int ways2(int stepNum) {
        if (stepNum == 0 || stepNum == 1) {
            return 1;
        }
        int[] ways = new int[stepNum + 1];
        ways[0] = 1; ways[1] = 1;
        for (int i = 2; i < ways.length; i++) {
            ways[i] = ways[i - 1] + ways[i - 2];
        }
        return ways[stepNum];
    }
}
