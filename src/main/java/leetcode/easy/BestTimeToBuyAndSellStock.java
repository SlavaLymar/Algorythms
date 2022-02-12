package leetcode.easy;

public class BestTimeToBuyAndSellStock {

    //
    //            i
    // [7,1,5,3,6,4] minprice = 1; profit = 5;
    //
    // t: O (N)
    // space: O (1)
    //
    public int maxProfit(int[] prices) {
        int profit = 0;
        if (prices == null || prices.length == 1) return profit;
        int minPrice = prices[0];
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                int curProfit = price - minPrice;
                if (curProfit > profit) {
                    profit = curProfit;
                }
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStock().maxProfit(
                new int[]{7,1,5,3,6,4}
        ));
    }
}
