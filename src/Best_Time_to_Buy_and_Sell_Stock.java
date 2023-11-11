import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/">121. Best Time to Buy and Sell Stock</a> <br>
 * Easy <br>
 * <br>
 * You are given an array prices where prices[i] is the price of a given stock on the ith day. <br>
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock. <br>
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0. <br>
 * <br>
 * Example 1: <br>
 * Input: prices = [7,1,5,3,6,4] <br>
 * Output: 5 <br>
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5. <br>
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell. <br>
 * <br>
 * Example 2: <br>
 * Input: prices = [7,6,4,3,1] <br>
 * Output: 0 <br>
 * Explanation: In this case, no transactions are done and the max profit = 0. <br>
 * <br>
 * Constraints: <br>
 * - 1 <= prices.length <= 10^5 <br>
 * - 0 <= prices[i] <= 10^4 <br>
 */

public class Best_Time_to_Buy_and_Sell_Stock {

    /**
     * Solution <br>
     * Runtime: 2ms --
     * Beats:
     * 75.75% --
     * Memory 60.7 MB --
     * Beats:
     * 75.48%
     */
    public int maxProfit(int[] prices) {
        // Check if the prices array is empty or has only one element
        if (prices == null || prices.length <= 1) {
            return 0; // No transactions can be done
        }

        // Initialize variables to track the minimum buying price and maximum profit
        int minPrice = prices[0];
        int maxProfit = 0;

        // Iterate through the prices array starting from the second element
        for (int i = 1; i < prices.length; i++) {
            // Update the minimum buying price if the current price is lower
            minPrice = Math.min(minPrice, prices[i]);

            // Calculate the potential profit by subtracting the minimum buying price
            // from the current price
            int potentialProfit = prices[i] - minPrice;

            // Update the maximum profit if the potential profit is greater
            maxProfit = Math.max(maxProfit, potentialProfit);
        }

        return maxProfit;
    }


    @Test
    public void testMaxProfitExample1() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int expected = 5;
        int result = maxProfit(prices);
        assertEquals(expected, result);
    }

    @Test
    public void testMaxProfitExample2() {
        int[] prices = {3, 2, 1, 4, 5};
        int expected = 4;
        int result = maxProfit(prices);
        assertEquals(expected, result);
    }

    @Test
    public void testMaxProfitWithIncreasingPrices() {
        int[] prices = {1, 2, 3, 4, 5};
        int expected = 4; // Buy at day 1, sell at day 5 for a profit of 4
        int result = maxProfit(prices);
        assertEquals(expected, result);
    }

    @Test
    public void testMaxProfitWithDecreasingPrices1() {
        int[] prices = {5, 4, 3, 2, 1};
        int expected = 0; // Cannot achieve profit with decreasing prices
        int result = maxProfit(prices);
        assertEquals(expected, result);
    }

    @Test
    public void testMaxProfitWithDecreasingPrices2() {
        int[] prices = {7, 6, 4, 3, 1};
        int expected = 0;
        int result = maxProfit(prices);
        assertEquals(expected, result);
    }

    @Test
    public void testMaxProfitWithSinglePrice() {
        int[] prices = {5};
        int expected = 0; // Cannot perform any transactions with only one price
        int result = maxProfit(prices);
        assertEquals(expected, result);
    }

    @Test
    public void testMaxProfitWithEmptyPrices() {
        int[] prices = {};
        int expected = 0; // Cannot perform any transactions with empty prices
        int result = maxProfit(prices);
        assertEquals(expected, result);
    }

    @Test
    public void testMaxProfitWithConstantPrices() {
        int[] prices = {5, 5, 5, 5, 5};
        int expected = 0; // Cannot perform any transactions with constant prices
        int result = maxProfit(prices);
        assertEquals(expected, result);
    }

}
