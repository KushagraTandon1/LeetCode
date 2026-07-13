class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i < 10; i++){
            int j = i + 1;
            int value = i;
            while(j <= 9){
                value = value * 10 + j;
                if(value >= low && value <= high){
                    list.add(value);
                }
                j++;
            }
        }
        Collections.sort(list);
        return list;
    }
}