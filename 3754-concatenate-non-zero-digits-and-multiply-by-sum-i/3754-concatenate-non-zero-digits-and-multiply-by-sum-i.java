class Solution {
    public long sumAndMultiply(int n) {
        long sum = 0;
        long number = 0;
        while(n != 0){
            if(n%10 != 0) number = number * 10 + n % 10;
            n = n / 10;
        }
        long temp = 0;
        while(number != 0){
            sum += number % 10;
            temp = temp * 10 + number % 10;
            number = number / 10;
        }
        return (long) (temp * sum);
    }
}