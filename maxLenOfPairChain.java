import java.util.*;

class Solution {
    int[][] dp;
    public int solve(int index, int prev, int[][] pairs){
        if(index == pairs.length)
            return 0;
        if(dp[index][prev+1] != -1)
            return dp[index][prev+1];
        int take = 0;
        if(prev == -1 || pairs[prev][1] < pairs[index][0]){
            take = 1 + solve(index + 1, index, pairs);
        }
        int skip = solve(index + 1, prev, pairs);
        return dp[index][prev+1] = Math.max(take, skip);
    }
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a,b) -> a[0] - b[0]);
        int n = pairs.length;
        dp = new int[n][n+1];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i],-1);
        return solve(0, -1, pairs);
    }
}