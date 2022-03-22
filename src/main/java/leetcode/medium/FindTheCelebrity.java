package leetcode.medium;

public class FindTheCelebrity {

    int numberOfPeople;

    //
    // t: O (N)
    // space: O (1)
    //
    public int findCelebrity(int n) {
        this.numberOfPeople = n;
        int candidate = 0;
        for (int i = 0; i < n; i++) {
            if (knows(candidate, i)) {
                candidate = i;
            }
        }
        if (this.isCelebrity(candidate)) return candidate;
        else return -1;

    }

    private boolean isCelebrity(int i) {
        for (int j = 0; j < this.numberOfPeople; j++) {
            if (i == j) continue;
            if (knows(i, j) || !knows(j, i)) return false;
        }
        return true;
    }

    private boolean knows(int i, int j) {
        // here must be some logic
        return false;
    }
}
