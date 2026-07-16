class Solution {
    public int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    public long gcdSum(int[] nums) {
        int size = nums.length;
        int [] prefixGcd = new int[size];
        int curr_max = 0;
        long answer = 0;
        int start = 0, end = size - 1;
        for(int i = 0; i < size; i++){
            if(i == 0){
                curr_max = nums[i];
                prefixGcd[i] = nums[i];
            }else{
                curr_max = Math.max(curr_max, nums[i]);
                prefixGcd[i] = gcd(curr_max, nums[i]);
            }
        }
        Arrays.sort(prefixGcd);
        while(start < end){
            answer += (long) gcd(prefixGcd[start], prefixGcd[end]);
            start++;
            end--;
        }
        return answer;
    }
}