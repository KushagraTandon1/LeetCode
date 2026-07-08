class Solution {
    public int dfs(int node, ArrayList<ArrayList<Integer>> adjacencyList, boolean [] visited){
        int count = 0;
        visited[Math.abs(node)] = true;

        for(int adjacent : adjacencyList.get(Math.abs(node))){
            if(!visited[Math.abs(adjacent)]){
                count += dfs(adjacent, adjacencyList, visited) + (adjacent > 0 ? 1 : 0); 
            }
        }

        return count;

    }
    public int minReorder(int n, int[][] connections) {
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        boolean [] visited = new boolean[n];
        Arrays.fill(visited, false);

        for(int i = 0; i < n; i++){
            adjacencyList.add(new ArrayList<>());
        }

        for(int i = 0; i < connections.length; i++){
            int x = connections[i][0];
            int y = connections[i][1];
            adjacencyList.get(x).add(y);
            adjacencyList.get(y).add(-x);
        }

        return dfs(0, adjacencyList, visited);
    }
}