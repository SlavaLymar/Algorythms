package interview.twoheaps;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class MaximizeCapital {

    static class Max {
        int availableCapital;
        Min capitalProfit;

        public Max(int availableCapital, Min capitalProfit) {
            this.availableCapital = availableCapital;
            this.capitalProfit = capitalProfit;
        }
    }

    static class Min {
        int capital;
        int profit;

        public Min(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }
    }

    // Input: Project Capitals=[0,1,2], Project Profits=[1,2,3], Initial Capital=1, Number of Projects=2
    // Output: 6
    //        max ({iCapital + profit, {capital, profit}})                     min ({capital, profit})
    //        3 1 2                                                            0 1
    //        1 0 1                                                            1 2
    //                                                                         2 3
    //
    public static int findMaximumCapital(int[] capital, int[] profits, int numberOfProjects, int initialCapital) {
        int length = profits.length;
        PriorityQueue<Min> minCapitalHeap =
                new PriorityQueue<>(length, Comparator.comparingInt(cap -> cap.capital));
        PriorityQueue<Max> maxProfitHeap =
                new PriorityQueue<>(length, (p1, p2) -> Integer.compare(p2.availableCapital, p1.availableCapital));

        for (int i = 0; i < length; i++) {
            minCapitalHeap.offer(new Min(capital[i], profits[i]));
        }

        int availableCapital = initialCapital;
        for (int i = 0; i < numberOfProjects; i++) {
            Iterator<Min> iterator = minCapitalHeap.iterator();
            Min minNum;
            while (iterator.hasNext()) {
                minNum = iterator.next();
                if (minNum.capital <= availableCapital) {
                    maxProfitHeap.offer(
                            new Max(availableCapital + minNum.profit, minNum)
                    );
                } else {
                    break;
                }
            }
            Max maxProfit = maxProfitHeap.remove();
            availableCapital = maxProfit.availableCapital;
            minCapitalHeap.remove(maxProfit.capitalProfit);
        }
        return availableCapital;
    }

    public static void main(String[] args) {
        int result = MaximizeCapital.findMaximumCapital(new int[]{0, 1, 2}, new int[]{1, 2, 3}, 2, 1);
        System.out.println("Maximum capital: " + result);
        result = MaximizeCapital.findMaximumCapital(new int[]{0, 1, 2, 3}, new int[]{1, 2, 3, 5}, 3, 0);
        System.out.println("Maximum capital: " + result);
    }
}
