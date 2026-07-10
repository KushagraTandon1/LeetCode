class TreeAncestor {
    int [][] ancestor;
    int col;
    public TreeAncestor(int n, int[] parent) {
        col = (int) (Math.log(n)/Math.log(2)) + 1;
        ancestor = new int[n][col];
        for(int i = 0; i < n; i++) Arrays.fill(ancestor[i], -1);

        for(int i = 0; i < n; i++){
            ancestor[i][0] = parent[i];
        }

        for(int j = 1; j < col; j++){
            for(int node = 0; node < n; node++){
                if(ancestor[node][j - 1] != -1){
                    ancestor[node][j] = ancestor[ancestor[node][j - 1]][j - 1];
                }
            }
        }

    }
    
    public int getKthAncestor(int node, int k) {
        for(int i = 0; i < col; i++){
            if((k & (1 << i)) != 0){
                node = ancestor[node][i];
                if(node == -1) return -1;
            }
        }return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */