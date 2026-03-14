class Solution {
    public static int solve(int n,int[] dp){
        if(n==1) return 1;
        if(dp[n]!=-1) return dp[n];
        int maxPro=0;
        for(int i=1;i<n;i++){
            int notBreak=i*(n-i);
            int breakAur=i*solve(n-i,dp);
            maxPro=Math.max(maxPro,Math.max(notBreak,breakAur));
        }
        return dp[n]=maxPro;
    }
    public int integerBreak(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp);
    }
}