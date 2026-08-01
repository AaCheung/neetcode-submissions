class Solution {
    public int maxProfit(int[] prices) {
        int[] highestAfter = new int[prices.length];
        int[] lowestBefore = new int[prices.length];

        highestAfter[prices.length - 1] = prices[prices.length - 1];
        for ( int i = prices.length - 2; 0 <= i; i-- ) {
            highestAfter[i] = Math.max( prices[i], highestAfter[i+1] );
        }

        lowestBefore[0] = prices[0];
        for ( int i = 1; i < prices.length; i++ ) {
            lowestBefore[i] = Math.min( lowestBefore[i-1], prices[i] );
        }

        int max = 0;
        for ( int i = 0; i < prices.length; i++ ) {
            max = Math.max( max, highestAfter[i] - lowestBefore[i] );
        }
        return max;
        
    }
}
