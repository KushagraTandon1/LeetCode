class Solution {

    public int getProduct(int n){
        int product = 1;
        while(n != 0){
            product = product * (n % 10);
            n = n / 10;
        }
        return product;
    }

    public int smallestNumber(int n, int t) {
        while(n != 101){
            if(getProduct(n) % t == 0){
                return n;
            }
            n++;
        }
        return -1;
    }
}