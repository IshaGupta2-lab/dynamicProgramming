class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        // Rob houses excluding the first house
        int robExcludingFirst = robRange(nums, 1, nums.length - 1);

        // Rob houses excluding the last house
        int robExcludingLast = robRange(nums, 0, nums.length - 2);

        // The result is the maximum of robbing either excluding the first or last house
        return Math.max(robExcludingFirst, robExcludingLast);
    }

    // Helper function to solve the House Robber problem
    private int robRange(int[] nums, int start, int end) {
        int prev2 = 0, prev1 = 0;
        for (int i = start; i <= end; i++) {
            int current = Math.max(prev1, nums[i] + prev2);
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }
}