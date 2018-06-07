/**
Given a binary tree, find all paths that sum of the nodes in the path equals to a given number target.
A valid path is from root node to any of the leaf nodes.
*/

import java.util.ArrayList;

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
    /*
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // write your code here
        List<List<Integer>> result = new ArraryList<>(); 
        if (root == null){
            return result;
        }
        ArrayList<Integer> path = new ArrayList<Integer>();
        path.add(root.val);
        binaryTreePathSumHelper(root,root.val,target,path,result);
        return result;
    }

    public void binaryTreePathSumHelper(Treenode root,
                                        int sum,
                                        int target,
                                        ArrayList<Integer> path,
                                        List<List<Integer>> result) {

        // meet leaf
        if (root.left == null && root.right == null) {
            if (sum == target) {
                result.add(new ArralyList<Integer>(path));
            }
            return;
        }

        // go left
        if(root.left != null) {
            path.add(root.left.val);
            binaryTreePathSumHelper(root.left,sum + root.left.val,target,path,result);
            path.remove(path.size() -1);
        }

        //go right
        if(root.right != null) {
            path.add(root.right.val);
            binaryTreePathSumHelper(root.right,sum + root.right.val,target,path,result);
            path.remove(path.size() -1);
        }
    }
}
