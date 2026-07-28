class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();
        while(columnNumber != 0){
            int index = (columnNumber - 1) % 26;
            System.out.println(index);
            char ch = (char) (index + 65);
            result.append(String.valueOf(ch));
            columnNumber = (columnNumber - 1) / 26;
        }
        return result.reverse().toString();
    }
}