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
    public int subTreesum(TreeNode root, Map<Integer, Integer> sumMap){
        if(root == null) return 0;
        int leftSum = subTreesum(root.left, sumMap);
        int rightSum = subTreesum(root.right,  sumMap); 
        int totalSum = root.val + leftSum + rightSum;
        sumMap.putIfAbsent(totalSum, 0);
        sumMap.put(totalSum, sumMap.get(totalSum) + 1);
        return totalSum;
    }
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int maxi = -1;

        subTreesum(root, sumMap);
        
        for(Map.Entry<Integer, Integer> sum : sumMap.entrySet()){
            if(sum.getValue() > maxi){
                maxi = sum.getValue();
            }
        }
        
        for(Map.Entry<Integer, Integer> sum : sumMap.entrySet()){
            if(sum.getValue() == maxi){
                result.add(sum.getKey());
            }
        }


        int[] arr = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }
}