class Solution {
    public int maximumProduct(int[] nums) {
       Arrays.sort(nums);
       int maxi_1 = 1;
       int maxi_2 = 1;
       int size = nums.length;
    
       maxi_1 = nums[0] * nums[1] * nums[size - 1];
       maxi_2 = nums[size - 1] * nums[size - 2] * nums[size - 3];
       return Math.max(maxi_2, maxi_1);
    }
}
