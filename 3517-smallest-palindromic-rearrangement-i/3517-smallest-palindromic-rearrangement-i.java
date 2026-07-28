class Solution {
    public String smallestPalindrome(String s) {
        int size = s.length();
        int [] charArray = new int[26];

        for(int i = 0; i < size; i++){
            charArray[s.charAt(i) - 'a']++;
        }

        char [] answer = new char[size];
        int low = 0, high = size - 1;

        for(int i = 0; i < 26; i++){
            while(charArray[i] > 1){
                answer[low] = (char) (i + 97);
                answer[high] = (char) (i + 97);
                low++;
                high--;
                charArray[i] -= 2;
            }
        }

        for(int i = 0; i < 26; i++){
            if(charArray[i] == 1){
                answer[low] = (char) (i + 97);
                low++;
            }
        }

        return String.valueOf(answer);
    }
}