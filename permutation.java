class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); 
        boolean[] visited = new boolean[nums.length];
        helper(nums, new ArrayList<>(), res, visited);
        return res;
    }

    private void helper(int[] nums, List<Integer> temp, List<List<Integer>> res, boolean[] visited) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;

            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;

            visited[i] = true;
            temp.add(nums[i]);
            helper(nums, temp, res, visited);
            visited[i] = false;
            temp.remove(temp.size() - 1);
        }
    }
}