class Solution {
     TreeNode prev = new TreeNode(Integer.MIN_VALUE);
        TreeNode first = null;
        TreeNode second = null;
    public void recover(TreeNode root){
        if(root == null) return;
        recover(root.left);
        if(first == null && prev.val > root.val){
            first = prev;
        }
        if(first != null && prev.val > root.val){
            second = root;
        }
        prev = root;
        recover(root.right);
    }
    public void recoverTree(TreeNode root) {
        recover(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        
    }
}