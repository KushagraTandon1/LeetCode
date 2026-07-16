class Solution {
    public int getLeastFrequentDigit(int n) {
        int [] count = new int[10];
        int answer = 10, min = 10;
        while(n != 0){
            count[n % 10]++;
            n = n / 10;
        }

        for(int i = 0; i < 10; i++){
            if(count[i] == 0)continue;
            else if(count[i] < min){
                min = count[i];
                answer = i;
            }else if(count[i] == min){
                answer = Math.min(answer, i);
            }
        }

        return answer;
    }
}