class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        List<List<String>> suggestionWords = new ArrayList<>();
        Arrays.sort(products);
        int left = 0, right = products.length - 1;

        for(int i = 0; i < searchWord.length(); i++){
            char ch = searchWord.charAt(i);

            while(left <= right && (i >= products[left].length() || products[left].charAt(i) != ch)){
                left += 1;
            }

            while(left <= right && (i >= products[right].length() || products[right].charAt(i) != ch)){
                right -= 1;
            }
            
            List<String> list = new ArrayList<>();
            for(int start = left; start < Math.min(left + 3, right + 1); start++){
                list.add(products[start]);
            }
            suggestionWords.add(list);
        } 
        return suggestionWords;
    }
}