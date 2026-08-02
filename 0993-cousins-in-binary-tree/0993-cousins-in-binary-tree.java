class Solution {
    TreeNode parentX;
    TreeNode parentY;
    int depthX;
    int depthY;

    public void dfs(TreeNode root, int x, int y, int currDepth, TreeNode parent){
        if(root == null) return;
        if(root.val == x){
            parentX = parent;
            depthX = currDepth;
        }
        if(root.val == y){
            parentY = parent;
            depthY = currDepth;
        }
        dfs(root.left, x, y, currDepth + 1, root);
        dfs(root.right, x, y, currDepth + 1, root);
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, x, y, 0, null);
        return depthX == depthY && parentX != parentY ? true : false;
    }
}