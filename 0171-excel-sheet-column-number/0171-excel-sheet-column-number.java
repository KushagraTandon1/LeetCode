class Solution {
    public int titleToNumber(String columnTitle) {
        int titleNumber = 0;
        for(int i = 0; i < columnTitle.length(); i++){
            int value = (int) columnTitle.charAt(i) - 64;
            titleNumber = titleNumber * 26 + value;
        }
        return titleNumber;
    }
}