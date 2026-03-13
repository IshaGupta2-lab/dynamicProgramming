class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) sum += num;

        
        if ((target + sum) % 2 != 0 || sum < Math.abs(target)) return 0;
        
        int s1 = (target + sum) / 2;
        
    
        int[] dp = new int[s1 + 1];
        dp[0] = 1; 

        for (int num : nums) {
            for (int j = s1; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        
        return dp[s1];
    }
}