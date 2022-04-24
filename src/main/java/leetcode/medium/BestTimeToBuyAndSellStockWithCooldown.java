package leetcode.medium;

public class BestTimeToBuyAndSellStockWithCooldown {

    //
    // 1,2,3,0,2
    //
    // t: O (N)
    // space: O (1)
    //
    public int maxProfit(int[] prices) {

        int sold = Integer.MIN_VALUE, held = Integer.MIN_VALUE, reset = 0;

        for (int price : prices) {
            int preSold = sold;
            sold = held + price;
            held = Math.max(held, reset - price);
            reset = Math.max(reset, preSold);
        }
        return Math.max(sold, reset);
    }

    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStockWithCooldown().maxProfit(
                new int[]{ 1,2,3,0,2 }
        ));
    }
}
