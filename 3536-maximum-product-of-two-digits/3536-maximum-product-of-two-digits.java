class Solution {
    public int maxProduct(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        while(n != 0){
            int digit = n % 10;
            list.add(digit);
            n = n / 10;
        }
        Collections.sort(list);
        int size = list.size() - 1;
        int answer = list.get(size) * list.get(size - 1);
        return answer;
    }
}