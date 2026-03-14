import java.util.*;

class Solution {

    long[][][] dp;
    long NEG = -(long)1e15;

    public long solve(int i, int state, int k, int[] prices){

        if(i == prices.length){
            if(state == 0) return 0;
            return NEG;
        }

        if(dp[i][state][k] != Long.MIN_VALUE)
            return dp[i][state][k];

        long profit;

        if(state == 0){

            long skip = solve(i+1,0,k,prices);

            long buy = NEG;
            long shortSell = NEG;

            if(k > 0){
                buy = -prices[i] + solve(i+1,1,k-1,prices);
                shortSell = prices[i] + solve(i+1,2,k-1,prices);
            }

            profit = Math.max(skip, Math.max(buy, shortSell));
        }

        else if(state == 1){

            long sell = prices[i] + solve(i+1,0,k,prices);
            long hold = solve(i+1,1,k,prices);

            profit = Math.max(sell, hold);
        }

        else{

            long buyBack = -prices[i] + solve(i+1,0,k,prices);
            long hold = solve(i+1,2,k,prices);

            profit = Math.max(buyBack, hold);
        }

        return dp[i][state][k] = profit;
    }

    public long maximumProfit(int[] prices, int k) {

        int n = prices.length;

        dp = new long[n][3][k+1];

        for(long[][] a : dp)
            for(long[] b : a)
                Arrays.fill(b, Long.MIN_VALUE);

        return solve(0,0,k,prices);
    }
}