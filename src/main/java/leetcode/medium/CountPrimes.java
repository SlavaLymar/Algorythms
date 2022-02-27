package leetcode.medium;

public class CountPrimes {

    //
    // 2,3,5,7,11,13,17,19,23,29
    //
    // t: O (sqr(N) * LogLogN)
    // space: O (N)
    //
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        boolean[] numbers = new boolean[n];

        // mark numbers that are not prime
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (numbers[i] == false) {
                for (int j = i * i; j < n; j += i) {
                    numbers[j] = true;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < n; i++) {
            if (numbers[i] == false) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new CountPrimes().countPrimes(1000));
    }
}
