# LeetCode_30dayChallenge

* Author：Wangshu Zhang
* Version：2020-04-30

# Problem: Check If a String Is a Valid Sequence from Root to Leaves Path in a Binary Tree

### Code
```Java
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
    public boolean isValidSequence(TreeNode root, int[] arr) {
        return dfs(root, arr, 0);
    }
    private boolean dfs(TreeNode root, int[] arr, int i) {
        if (i >= arr.length) {
            return false;
        }
        if (root == null) {
            return false;
        }
        if (root.val != arr[i]) {
            return false;
        }
        if (root.left == null && root.right == null && i == arr.length - 1) {
            return true;
        }
        boolean left = dfs(root.left, arr, i + 1);
        boolean right = dfs(root.right, arr, i + 1);
        return left == true || right == true;
    }
}
```
