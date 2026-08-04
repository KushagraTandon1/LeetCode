class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 1; i < nums.length; i++){
            int start = nums[i - 1];
            int end = nums[i];
            
            if(end - start > 1){
                for(int index = start + 1; index < end; index++){
                    result.add(index);
                }
            }
        }

        return result;
    }
}