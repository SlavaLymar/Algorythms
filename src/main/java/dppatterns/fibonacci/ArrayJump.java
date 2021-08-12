package dppatterns.fibonacci;

public class ArrayJump {

    //
    // Input = {1,1,3,6,9,1,0,1,3}
    // Output = 4
    //
    //
    // 2, 1, 1, 1, 4
    //
    // t: O (N ^ 2)
    // space: O (1)
    //
    public int countMinJumps(int[] jumps) {
        int jCounter = 0;
        for (int i = 0; i < jumps.length; ) {
            int val = jumps[i];
            if (i + val >= jumps.length) {
                jCounter++;
                break;
            }
            int nextJump = i, max = Integer.MIN_VALUE;
            for (int j = i + 1; j <= i + val && j < jumps.length; j++) {
                max = Math.max(max, jumps[j] + j);
                if (jumps[j] + j >= max) {
                    nextJump = j;
                }
            }
            System.out.println("i: " + i + " nextJump: " + nextJump);
            i = nextJump;
            if (i >= jumps.length - 1) {
                i = jumps.length;
            }
            jCounter++;
        }
        return jCounter;
    }

    public static void main(String[] args) {
        ArrayJump aj = new ArrayJump();
        int[] jumps = {6, 1, 1, 100, 4};
        System.out.println(aj.countMinJumps(jumps));
        jumps = new int[]{1, 1, 3, 6, 9, 3, 0, 1, 3};
        System.out.println(aj.countMinJumps(jumps));
    }
}
