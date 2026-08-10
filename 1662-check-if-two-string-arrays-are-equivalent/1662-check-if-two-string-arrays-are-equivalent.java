class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder string1 = new StringBuilder();
        StringBuilder string2 = new StringBuilder();

        for(int i = 0; i < word1.length; i++){
            string1.append(word1[i]);
        }

        for(int i = 0; i < word2.length; i++){
            string2.append(word2[i]);
        }

        if(string1.length() != string2.length()) return false;
        for(int i = 0; i < string2.length(); i++){
            if(string1.charAt(i) != string2.charAt(i)) return false;
        }


        return true;
    }
}