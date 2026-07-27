/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int index = 0;
    public void buildInOrder(TreeNode root, List<Integer> inOrder){
        if(root == null) return;
        buildInOrder(root.left, inOrder);
        inOrder.add(root.val);
        buildInOrder(root.right, inOrder);
    }
    public void recovermyTree(TreeNode root, List<Integer> inOrder){
        if(root == null) return;
        recovermyTree(root.left, inOrder);
        root.val = inOrder.get(index);
        index++;
        recovermyTree(root.right, inOrder);
    }
    public void recoverTree(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        buildInOrder(root, inOrder);
        Collections.sort(inOrder);
        recovermyTree(root, inOrder);
    }
}