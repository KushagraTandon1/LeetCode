class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int [] componentArray = new int[n];
        boolean [] resultant = new boolean[queries.length];
        int component = 0;

        for(int i = 1; i < n; i++){
            if(nums[i] - nums[i - 1] > maxDiff) component++;
            componentArray[i] = component;
        }
        
        for(int i = 0; i < queries.length; i++){
            int left = queries[i][0];
            int right = queries[i][1];
            if(componentArray[left] == componentArray[right]) resultant[i] = true;
        }
        return resultant;
    }
}