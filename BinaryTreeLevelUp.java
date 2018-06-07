/*
482. Binary Tree Level Sum
Given a binary tree and an integer which is the depth of the target level.

Calculate the sum of the nodes in the target level.

Example
Given a binary tree:

     1
   /   \
  2     3
 / \   / \
4   5 6   7
   /       \
  8         9
For depth = 2, return 5.
For depth = 3, return 22.
For depth = 4, return 17.
*/
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: the root of the binary tree
     * @param level: the depth of the target level
     * @return: An integer
     */
    private int sum;
    public int levelSum(TreeNode root, int level) {
        // write your code here
        sum = 0;
        int depth = 1;
        if (level <= 0 || root == null ) {
            return 0;
        }
        
        helper(root, level, depth);
        return sum;
    }
    
    public void helper(TreeNode root, int level, int depth) {
        if (depth > level) {
            return;
        }
        
        if (root == null) {
            return;
        }
        
        if (depth == level ) {
            sum += root.val;
        }
        
        helper(root.left, level, depth +1);
        helper(root.right, level, depth +1);        
    }
}