class Solution {

    public void dfs(int node, int [] visited, List<List<Integer>> adjacentList){
        
        visited[node] = 1;

        for(int adjacent : adjacentList.get(node)){
            if(visited[adjacent] == 0){
                dfs(adjacent, visited, adjacentList);
            }
        }

    }


    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> adjacentList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int [] visited = new int[n];

        for(int i = 0; i < n; i++){
            adjacentList.add(new ArrayList<>());
        }    

        for(int i = 0; i < invocations.length; i++){
            int x = invocations[i][0];
            int y = invocations[i][1];
            adjacentList.get(x).add(y);
        }

        dfs(k, visited, adjacentList);
        boolean check = true;
        for(int i = 0; i < invocations.length; i++){
            int x = invocations[i][0];
            int y = invocations[i][1];
            if(visited[x] == 0 && visited[y] == 1){
                check = false;
            }
        }
        if(check == false){
            for(int i = 0; i < n ; i++){
                list.add(i);
            }
        }else{
            for(int i = 0 ; i < visited.length; i++){
                if(visited[i] == 0){
                    list.add(i);
                }
            }
        }
        return list;
    }
}