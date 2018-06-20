# Leetcode 129. Sum Root to Leaf Numbers
@Author: Wangshu Zhang

# Thoughts
* The basic idea is using DFS to traverse every path, from root to the left node. One trick is that whenever meeting a next level's node, we multiple the current sum 10, and add the node's value of next level.

### Code
```Java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val 2= x; }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] sum = new int[1];
        int res = helper(root, root.val, sum);
        return res;
    }
    private int helper(TreeNode root, int num, int[] sum) {
        if (root.left == null && root.right == null) {
            sum[0] += num;
        }
        if (root.left != null) {
            helper(root.left, 10 * num + root.left.val, sum);
        }
        if (root.right != null) {
            helper(root.right, 10 * num + root.right.val, sum);
        }
        return sum[0];
    }
}
```

# Summary
* This problem only requires us return an integer sum, but if it asked us to return all paths, probably we need to store result into a list of list.
