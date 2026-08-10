class Solution {
    public int findClosestNumber(int[] nums) {
        int closest = Integer.MAX_VALUE;
        int maximum = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            closest = Math.abs(nums[i]) < closest ? Math.abs(nums[i]) : closest;
        }

        for(int i = 0; i < nums.length; i++){
            if(Math.abs(nums[i]) == closest){
                maximum = Math.max(maximum, nums[i]);
            }
        }
        return maximum;
    }
}