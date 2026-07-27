class Solution {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int size = nums.length;
        return (nums[size - 1] - 1) * (nums[size - 2] - 1);
    }
}