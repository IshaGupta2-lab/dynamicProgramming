import java.util.Arrays;

class Solution {
    int count = 0;
    public int solve(int i,int[] nums,int[] dp){
        if(i < 2) return 0;
        if(dp[i] != -1) return dp[i];
        int curr = 0;
        if(nums[i]-nums[i-1] == nums[i-1]-nums[i-2]){
            curr = 1 + solve(i-1,nums,dp);
            count += curr;
        } 
        else{
            solve(i-1,nums,dp);
        }
        return dp[i] = curr;
    }
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        solve(n-1,nums,dp);
        return count;
    }
}