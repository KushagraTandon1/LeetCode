class Solution {
    
    public int canAliceWin(int i, int j, int [] piles, int [][] dp){
        if(dp[i][j] != -1) return dp[i][j];
        if(i == j) return dp[i][j] = piles[i];
        return dp[i][j] = Math.max(piles[i] - canAliceWin(i + 1, j, piles, dp),
        piles[j] - canAliceWin(i, j - 1, piles, dp));
    }

    public boolean stoneGame(int[] piles) {
        int size = piles.length;
        int [][] dp = new int[size][size];
        for(int i = 0; i < size; i++) Arrays.fill(dp[i], -1);
        return canAliceWin(0, size - 1, piles, dp) >= 0;
    }
}