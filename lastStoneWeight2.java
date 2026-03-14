class Solution {
    public static int solve(int index,int sum,int total,int[] stones,int[][] dp){
        if(index==stones.length) return Math.abs(total-2*sum);
        if(dp[index][sum]!=-1) return dp[index][sum];
        int include=solve(index+1,sum+stones[index],total,stones,dp);
        int exclude=solve(index+1,sum,total,stones,dp);
        return dp[index][sum]=Math.min(include,exclude);
    }
    public int lastStoneWeightII(int[] stones) {
        int n=stones.length;
       
        
        int total=0;
        for(int s:stones) total+=s;
        int[][] dp=new int[n][total+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,0,total,stones,dp);
    }
}