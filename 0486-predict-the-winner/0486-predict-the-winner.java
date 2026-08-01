class Solution {
    public int getWinner(int i, int j, int [] nums, int [][] dp){
        if(i == j) return dp[i][j] = nums[i];
        if(dp[i][j] != -1) return dp[i][j];
        int takeLeft = nums[i] - getWinner(i + 1, j, nums, dp);
        int takeRight = nums[j] - getWinner(i, j - 1, nums, dp);
        return Math.max(takeLeft, takeRight);
    }
    public boolean predictTheWinner(int[] nums) {
        int size = nums.length;
        int [][] dp = new int[size][size];
        for(int i = 0; i < size; i++){
            Arrays.fill(dp[i], -1);
        }
        return getWinner(0, size - 1, nums, dp) >= 0;
    }
}