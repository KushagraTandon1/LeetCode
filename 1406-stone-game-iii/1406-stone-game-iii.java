class Solution {
    public int canAliceWin(int index, int [] stoneValue, int n, int [] dp){
        if(index == n) return 0;
        if(dp[index] != -1) return dp[index];
        int max_score = stoneValue[index] - canAliceWin(index + 1, stoneValue, n, dp);
        if(index + 1 < n){
            max_score = Math.max(max_score, 
            (stoneValue[index] + stoneValue[index + 1]) - canAliceWin(index + 2, stoneValue, n, dp));
        }
        if(index + 2 < n){
            max_score = Math.max(max_score, 
            (stoneValue[index] + stoneValue[index + 1] + stoneValue[index + 2]) - canAliceWin(index + 3, stoneValue, n, dp));
        }
        return dp[index] = max_score;
    }
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int [] dp = new int[n];
        Arrays.fill(dp, -1);
        int netScore = canAliceWin(0, stoneValue, n, dp);
        if(netScore == 0) return "Tie";
        if(netScore > 0) return "Alice";
        return "Bob";

    }
}