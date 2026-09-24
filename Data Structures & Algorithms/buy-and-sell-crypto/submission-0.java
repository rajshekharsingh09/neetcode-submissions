class Solution {
    public int maxProfit(int[] prices) {
        int[] minL = new int[prices.length];

        minL[0] = prices[0];

        for (int i = 1; i < prices.length; i++) {
            minL[i] = Math.min(prices[i], minL[i - 1]);
        }

        int result = 0;

        for (int i = 1; i < prices.length; i++) {
            result = Math.max(result, prices[i] - minL[i - 1]);
        }

        return result;
    }
}
