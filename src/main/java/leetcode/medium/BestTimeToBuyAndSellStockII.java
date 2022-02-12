package leetcode.medium;

public class BestTimeToBuyAndSellStockII {

    //
    //            i
    // [7,1,5,3,6,4], min = 4, profit = 7;
    //
    //    i
    // [7,1,5,2,6,100], min = 1, profit = 0;
    //
    //
    //  7 1 5 2 6 100
    //            p
    //          p _
    //  _        | |
    //   |  p   _| |
    //   |  _  |   |
    //   | | |_|   |
    //   |_|       |
    //    v   v
    //
    // t: O (N)
    // space: O (1)
    //
    public int maxProfit(int[] prices) {
        int profit = 0;
        if (prices == null || prices.length == 1) return profit;
        for (int i = 0; i < prices.length; i++) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i++;
            }
            int valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i++;
            }
            int peak = prices[i];
            profit += peak - valley;
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStockII().maxProfit(
                new int[]{7,1,5,3,6,4}
        ));
        System.out.println(new BestTimeToBuyAndSellStockII().maxProfit(
                new int[]{7,1,5,2,6,100}
        ));
    }
}
