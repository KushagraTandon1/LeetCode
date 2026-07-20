class Solution {
    public void shiftElement(int [][] grid){

        int temp = grid[0][0];
        int row = grid.length, col = grid[0].length;
        int last = grid[row - 1][col - 1];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(i == 0 && j == 0) continue;
                int value = grid[i][j];
                grid[i][j] = temp;
                temp = value;
            }
        }
        grid[0][0] = last;
    }
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        int row = grid.length, col = grid[0].length;
        int size = row * col;
        int [] vector = new int[size];
        int index = 0;
        List<List<Integer>> answer = new ArrayList<>();

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                vector[index] = grid[i][j];
                index++;
            }
        }

        while(k != 0){
            shiftElement(grid);
            k--;
        }

        for(int i = 0; i < row; i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < col; j++){
                list.add(grid[i][j]);
            }
            answer.add(list);
        }
        return answer;

    }
}