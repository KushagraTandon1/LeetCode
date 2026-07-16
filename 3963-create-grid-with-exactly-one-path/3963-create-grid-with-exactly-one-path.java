class Solution {
    public String getString(char[] str){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length; i++){
            sb.append(str[i]);
        }
        return sb.toString();
    }
    public String[] createGrid(int m, int n) {
        String [] answer = new String[m];
        char [][] string = new char[m][n];
        for(int i = 0; i < n; i++){
            string[0][i] = '.';
        }
        for(int i = 1; i < m; i++){
            string[i][n - 1] = '.';
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(string[i][j] != '.') string[i][j] = '#';
            }
        }

        for(int i = 0; i < m; i++){
            answer[i] = getString(string[i]);
        }
        return answer;

    }
}