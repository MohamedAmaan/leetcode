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
    public List<Integer> inorderTraversal(TreeNode root) {
    List <Integer> ans =new LinkedList<>();
    inorderHelper(root,ans);
    return ans;    
    }
    private static void inorderHelper(TreeNode node, List <Integer> ans){
        if(node==null) return;
        inorderHelper(node.left,ans);
        ans.add(node.val);
        inorderHelper(node.right,ans);

    }
}