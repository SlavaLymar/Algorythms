package leetcode.hard;

public class BestTimeToBuyAndSellStockIII {

    //         i
    //  [1,2,4,2,5,7,2,4,9,0]
    //   v   p
    //
    // t: O (N)
    // space: O (1)
    //
    public int maxProfit(int[] prices) {
        int t1Cost = Integer.MAX_VALUE, t2Cost = Integer.MAX_VALUE;
        int t1Profit = 0, t2Profit = 0;

        for (int price : prices) {
            // the maximum profit if only one transaction is allowed
            t1Cost = Math.min(t1Cost, price);
            t1Profit = Math.max(t1Profit, price - t1Cost);
            // reinvest the gained profit in the second transaction
            t2Cost = Math.min(t2Cost, price - t1Profit);
            t2Profit = Math.max(t2Profit, price - t2Cost);
        }

        return t2Profit;
    }

    public static void main(String[] args) {
//        System.out.println(
//                new BestTimeToBuyAndSellStockIII().maxProfit(
//                        new int[]{1, 7, 4, 2}
//                )
//        );
//        System.out.println(
//                new BestTimeToBuyAndSellStockIII().maxProfit(
//                        new int[]{1, 4, 2}
//                )
//        );
//        System.out.println(
//                new BestTimeToBuyAndSellStockIII().maxProfit(
//                        new int[]{1, 2, 3, 4, 5}
//                )
//        );
        System.out.println(
                new BestTimeToBuyAndSellStockIII().maxProfit(
                        new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0}
                )
        );
//        System.out.println(
//                new BestTimeToBuyAndSellStockIII().maxProfit(
//                        new int[]{3, 3, 5, 0, 0, 3, 1, 4}
//                )
//        );
    }
}
