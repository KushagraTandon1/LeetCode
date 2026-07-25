class Solution {
    public int mostWordsFound(String[] sentences) {
        int maximum = Integer.MIN_VALUE;
        for(int i = 0; i < sentences.length; i++){
            String [] string = sentences[i].split(" ");
            maximum = Math.max(string.length, maximum);
        }   
        return maximum;
    }
}