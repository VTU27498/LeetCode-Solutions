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
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        // subtract current node value
        targetSum -= root.val;

        // check if it's a leaf
        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }

        // recurse on left and right
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
}
