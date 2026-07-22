class Solution {
    public int minFlips(int a, int b, int c) {
        Map<String, Integer> getCount = new HashMap<>();
        getCount.put("000", 0);
        getCount.put("001", 1);
        getCount.put("010", 1);
        getCount.put("011", 0);
        getCount.put("100", 1);
        getCount.put("101", 0);
        getCount.put("110", 2);
        getCount.put("111", 0);

        int minbitFlips = 0;

        for(int i = 0; i < 32; i++){
            int a_bit = a & 1;
            int b_bit = b & 1;
            int c_bit = c & 1;
            a = a >> 1;
            b = b >> 1;
            c = c >> 1;
            String value = "" + a_bit + b_bit + c_bit;
            minbitFlips += getCount.get(value);
        }
        return minbitFlips;
    }
}