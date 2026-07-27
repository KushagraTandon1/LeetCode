class Solution {

    public void countingSort(int [] nums, int exponent){
        int size = nums.length;
        int [] output = new int[size];
        int [] count = new int[10];

        for(int i = 0; i < size; i++){
            count[(nums[i] / exponent) % 10]++;
        }

        for(int i = 1; i < 10; i++){
            count[i] += count[i - 1];
        }

        for(int i = size - 1; i >= 0; i--){
            output[count[(nums[i] / exponent) % 10] - 1] = nums[i];
            count[(nums[i] / exponent) % 10]--;
        }

        for(int i = 0; i < size; i++){
            nums[i] = output[i];
        }
    }

    public void sortMyArray(int [] nums){
        int maximum = Arrays.stream(nums).max().getAsInt();
        for(int exp = 1; maximum / exp > 0; exp *= 10){
            countingSort(nums, exp);
        }
    }

    public int maximumGap(int[] nums) {
        int answer = 0, size = nums.length;
        sortMyArray(nums);
        for(int i = 1; i < size; i++){
            answer = Math.max(answer, nums[i] - nums[i - 1]);
        }
        return answer;
    }
}