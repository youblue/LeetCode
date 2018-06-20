# Leetcode 110. Balanced Binary Tree
@Author: Wangshu Zhang

# Thoughts
* The definition of balanced binary tree contains three parts, i.e., for any node in the tree,
    * Its left subtree is balanced;
    * Its right subtree is balanced;
    * The difference between left and right subtrees <= 1.
* Return value: a leaf node is a balanced binary tree.

### Code
```Java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = height(root.left);
        int right = height(root.right);
        if (isBalanced(root.left) && isBalanced(root.right) && Math.abs(left - right) <= 1) {
            return true;
        }
        return false;
    }
    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }
}
```

# Summary
* Be familiar with Divide-and-Conquer idea and pay attention to the return value.
